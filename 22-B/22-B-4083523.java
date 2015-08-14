import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  boolean[][] grid = new boolean[n][m];
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      for(int j = 0; j<m; j++)
          grid[i][j] = s.charAt(j) == '0';
  }
  int max = 0;
  for(int i = 0; i<n; i++)
      for(int j = 0; j<m; j++)
          for(int k = j; k<m; k++)
          {
              int row = i;
              boolean good = true;
              while(row<n && good)
              {
                  for(int x = j; x<=k; x++)
                      good &= grid[row][x];
                  if(good) row++;
              }
              if(row > i)
              max = Math.max(max, (row-i)*2 + (k-j+1)*2);
              //out.println(row+" "+i+" "+k+" "+j);
          }
  out.println(max);
  out.close();
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}