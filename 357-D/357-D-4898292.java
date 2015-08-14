import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    long n = input.nextLong(), m = input.nextLong();
    String s = input.next(), t = input.next();
    int g = gcd(s.length(), t.length());
    long lcm = (long)s.length()/g*t.length();
    int[][] count = new int[g][27];
    //for(int i = 0; i<s.length(); i++) count[i%g][s.charAt(i)-'a']++;
    int[] total = new int[g];
    for(int i = 0; i<t.length(); i++)
    {
        total[i%g]++;
        count[i%g][t.charAt(i)-'a']++;
    }
    long res = 0;
    for(int i= 0; i<s.length(); i++)
    {
        res += count[i%g][s.charAt(i)-'a'];
    }
    res = lcm - res;
    res *= (long)n*s.length()/lcm;
    System.out.println(res);
}
static int gcd(int a, int b)
{
    if(b==0) return a;
    return gcd(b, a%b);
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