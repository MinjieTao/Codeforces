import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    int[] freq = new int[n];
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        if(data[i] < 1)
        {
            res += 1 - data[i]; data[i] = 1;
        }
        if(data[i]>n)
        {
            res += data[i]-n; data[i] = n;
        }
        freq[data[i]-1]++;
    }
    ArrayList<Integer> missing = new ArrayList<Integer>();
    ArrayList<Integer> extra = new ArrayList<Integer>();
    for(int i =0 ; i<n; i++)
    {
        if(freq[i] == 0) missing.add(i);
        for(int j = 0; j<freq[i]-1; j++) extra.add(i);
    }
    for(int i = 0; i<missing.size(); i++) res += Math.abs(missing.get(i)-extra.get(i));
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