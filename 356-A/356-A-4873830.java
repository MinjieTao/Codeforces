import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    TreeSet<Integer> alive = new TreeSet<Integer>();
    for(int i = 1; i<=n; i++) alive.add(i);
    int[] res = new int[n];
    for(int i = 0; i<m; i++)
    {
        int l = input.nextInt(), r = input.nextInt(), x = input.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a: alive.subSet(l, r+1))
        {
            //System.out.println(i+" "+a+" "+x);
            if(a == x)
            {
                res[a-1] = 0;
                continue;
            }
            res[a-1] = x;
            list.add(a);
        }
        for(int a: list) alive.remove(a);
    }
    PrintWriter out = new PrintWriter(System.out);
    for(int i = 0; i<n; i++) out.print(res[i]+" ");
    out.close();
}
//Fast Scanner
//throw IOException
//input.init(System.in);
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