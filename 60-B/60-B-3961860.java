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
  int x = input.nextInt(), y = input.nextInt(), z = input.nextInt();
  int[] dx = {1, 0, 0, 0, 0, -1};
  int[] dy = {0, 1, 0, 0, -1, 0};
  int[] dz = {0, 0, 1, -1, 0, 0};
  char[][][] data = new char[x][y][z];
  for(int i = 0; i<x; i++)
     for(int j = 0; j<y; j++)
     {
         String s = input.next();
         for(int k = 0; k<z; k++)
             data[i][j][k] = s.charAt(k);
     }
  int yy = input.nextInt()-1, zz = input.nextInt()-1;
  data[0][yy][zz] = 'a';
  int count = 1;
  for(int a = 0; a<x; a++)
      for(int b = 0; b<y; b++)
          for(int c = 0; c<z; c++)
          {
              for(int i = 0; i<x; i++)
                  for(int j = 0; j<y; j++)
                      for(int k = 0; k<z; k++)
                      {
                          if(data[i][j][k] != 'a') continue;
                          for(int d = 0; d<6; d++)
                          {
                              int ni = i + dx[d];
                              int nj = j + dy[d];
                              int nk = k + dz[d];
                              if(ni>=0&&ni<x&&nj>=0&&nj<y&&nk>=0&&nk<z && data[ni][nj][nk] == '.')
                              {
                                  data[ni][nj][nk] = 'a';
                                  count++;
                              }
                                  
                          }
                      }
          }
  out.println(count);
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