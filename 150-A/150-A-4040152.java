import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  long n = input.nextLong();
  ArrayList<Long> primes = new ArrayList<Long>();
  for(int i = 2; i<=Math.sqrt(n); i++)
  {
    while(n%i ==0)
    {
      n/=i;
      primes.add((long) i);
    }
  }
  //for(long i: primes) out.println(i);
  if(n>1) primes.add(n);
  if(primes.size() <= 1) out.println(1+"\n"+0);
  else if(primes.size() > 2) out.println(1+"\n"+primes.get(0)*primes.get(1));
  else out.println(2);

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
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}