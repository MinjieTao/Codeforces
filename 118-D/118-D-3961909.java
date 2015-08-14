import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n1 = input.nextInt(), n2 = input.nextInt(), k1 = input.nextInt(), k2 = input.nextInt();
  a = k1; b = k2;
  memo = new int[101][101][11][11];
  for(int[][][] a: memo) for(int[][] b: a) for(int[] c: b) Arrays.fill(c, -1);
          out.println(go(n1, n2, 0, 0));
  out.close();
  
}
static int[][][][] memo;
static int a, b;
static int go(int n1, int n2,  int k1, int k2)
{
    if(n1 == 0 && n2 == 0)
        return 1;
    if(n1 < 0 || n2<0) return 0;
    if(memo[n1][n2][k1][k2] != -1) return memo[n1][n2][k1][k2]; 
    if(k1 < a && k2<b)
    {
        return memo[n1][n2][k1][k2] = (go(n1-1, n2, k1+1, 0) + go(n1, n2-1, 0, k2+1))%100000000;
    }
    else if(k1<a)
        return memo[n1][n2][k1][k2] = go(n1-1, n2, k1+1, 0);
    else
        return memo[n1][n2][k1][k2] = go(n1, n2-1, 0, k2+1);
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