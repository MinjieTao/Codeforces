import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  int n = input.nextInt(), m = input.nextInt();
  blacks = new boolean[n][m];
  int count = 0;
  for(int i = 0; i<n; i++)
  {
    String s = input.next();
    for(int j = 0; j<m; j++)
    {
      blacks[i][j] = s.charAt(j) == 'B';
      if(blacks[i][j]) count++;
    }
  }
  boolean good = true;
  for(int i = 0; i<n; i++)
    for(int j = 0; j<m; j++)
    {
      int x = 0;
      if(!blacks[i][j]) continue;
      int[][] grid = new int[n][m];
      for(int[] A: grid) Arrays.fill(A, -1);
      grid[i][j] = 0;
      x++;
      int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1,0,-1,0};
      for(int k = 0; k<4; k++)
      {
        int nx = j, ny = i;
        while(true)
        {
          nx += dx[k];
          ny += dy[k];
          if(nx < 0 || ny<0 || nx>=blacks[0].length || ny >= blacks.length) break;
          if(grid[ny][nx] == -1 && blacks[ny][nx])
          {
            //out.println(1+" "+ny+" "+nx);
            grid[ny][nx] = 1;
            x++;
           }
          else if(blacks[ny][nx]) continue;
          else break;
        }
      }
      for(int ii = 0; ii<n; ii++)
        for(int jj = 0; jj<m; jj++)
        {
          if(grid[ii][jj] != 1) continue;
          for(int k = 0; k<4; k++)
          {
            int nx = jj, ny = ii;
            while(true)
            {
              nx = nx + dx[k];
              ny = ny + dy[k];
              if(nx < 0 || ny<0 || nx>=blacks[0].length || ny >= blacks.length) break;
              if(grid[ny][nx] == -1 && blacks[ny][nx])
              {
                //out.println(2+" "+ny+" "+nx);
                grid[ny][nx] = 2;
                x++;
               }
              else if(blacks[ny][nx]) continue;
              else break;
            }
          }
        }
      //out.println(i+" "+j+" "+x+" "+count);
      good &= x == count;
    }
  out.println(good?"YES":"NO");

  out.close();
}
static long pow(long a, long p)
{
  if(p==0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
}
static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;

  /** call this method to initialize reader for InputStream */
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }

  /** get next word */
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          //TODO add check for eof if necessary
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }

  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}