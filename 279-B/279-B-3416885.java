import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), t = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++) data[i] = input.nextInt();
    int res = 0;
    int start = -1;
    for(int i = n-1; i>=0; i--)
    {
        if(data[i]<=t) start = i;
    }
    if(start == -1)
        out.println(0);
    else
    {
        int sum = data[start];
        int best = 1;
        int i = start, j = start;
        while(j<n-1)
        {
            j++;
            sum += data[j];
            while(sum > t) sum -= data[i++];
            best = Math.max(best, j-i+1);
        }
        out.println(best);
    }
        
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