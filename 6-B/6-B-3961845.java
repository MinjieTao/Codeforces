import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
  public static int n;
  public static int[][] twos, fives, memo, memo2;
  public static char[][] res, res2;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n =input.nextInt(), m = input.nextInt();
  char c = input.next().charAt(0);
  char[][] data = new char[n][m];
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      for(int j = 0; j<m; j++) data[i][j] = s.charAt(j);
  }
  int[] dx = {1,0,-1,0};
  int[] dy = {0,1,0,-1};
  HashSet<Character> set = new HashSet<Character>();
  for(int i = 0; i<n; i++)
  {
      for(int j = 0; j<m; j++)
      {
          if(data[i][j] != c) continue;
          for(int k = 0; k<4; k++)
          {
              int ni = i + dy[k], nj = j+dx[k];
              if(ni>=0 && ni<n && nj>=0 && nj<m && data[ni][nj] != '.' && data[ni][nj] != c)
                  set.add(data[ni][nj]);
          }
      }
  }
  out.println(set.size());
  out.close();
  
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}