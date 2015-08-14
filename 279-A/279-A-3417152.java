import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int x = input.nextInt(), y = input.nextInt();
    int[] dists = new int[402];
    for(int i = 1; i<=201; i++) dists[2*i-2] = dists[2*i-1] = i;
    int atx = 0, aty = 0, dir = 0;
    int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    int res = 0, turns = 0;
    for(int i = 0; i<402; i++)
    {
        for(int j = 0; j<dists[i]; j++)
        {
            atx += dx[dir]; aty += dy[dir];
            if(atx == x && aty == y) res = turns;
        }
        turns++;
        dir = (dir+1)%4;
    }
    out.println(res);
    out.close();
}
public static class input {
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
}
}