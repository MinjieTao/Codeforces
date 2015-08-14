import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), k = input.nextInt(), max = 0;
  long[] data = new long[n], sum = new long[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  Random r = new Random();
  for(int i = 0; i<100000; i++)
  {
    int a = r.nextInt(n), b = r.nextInt(n);
    long temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  Arrays.sort(data);
  int[] res = new int[n];
  for(int i = 0; i<n; i++)
  {
    sum[i] = data[i];
    if(i>0) sum[i]+=sum[i-1];
    int lo = 1, hi = i+2;
    while(lo<hi-1)
    {
      int mid = (lo+hi)/2;
      long needed = data[i]*mid - (sum[i] - ((i-mid == -1) ? 0 : sum[i-mid]));
      if(needed <= k) lo = mid;
      else hi = mid;
    }
    res[i] = lo;
    max = Math.max(max, res[i]);
  }
  for(int i = 0; i<n; i++) if(res[i] == max)
  {
    out.println(res[i]+" "+data[i]);
    break;
  }
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