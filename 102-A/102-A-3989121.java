import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n=  input.nextInt(), m = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  boolean[][] adj = new boolean[n][n];
  for(int i = 0; i<m; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      adj[a][b] = adj[b][a] = true;
  }
  int res = 987654321;
  for(int i = 0; i<n; i++)
      for(int j = i+1; j<n; j++)
      {
          for(int k = j+1; k<n; k++)
          if(adj[i][j] && adj[i][k] && adj[j][k])
              res = Math.min(res, data[i]+data[j]+data[k]);
      }
  out.println(res==987654321 ? -1:res);
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