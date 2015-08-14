import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  int[] data = new int[2*n-1];
  for(int i = 0; i<2*n-1; i++) data[i] = input.nextInt();
  Arrays.sort(data);
  boolean[] possible = new boolean[2*n];
  int count = 0;
  for(int i= 0; i<2*n-1; i++) if(data[i] < 0) count++;
  possible[count] = true;
  for(int x = 0; x<=200; x++)
  for(int i = 0; i<2*n; i++)
  {
    //out.println(i+" "+count);
    if(!possible[i]) continue;
    for(int k = n; k>0; k-=2)
    {
      //out.println(k);
      if(i+k < 2*n-1)
      possible[i+k] = true;
      if(i-k >= 0)
      possible[i-k] = true;
    }
  }
  int min = 1000;
  for(int i = 0; i<2*n-1; i++) min = Math.min(min, Math.abs(data[i]));
  int sum = 0;
  for(int i = 0; i<2*n-1; i++) sum += Math.abs(data[i]);
  if(possible[0]) out.println(sum);
  else out.println(sum-2*min);


  out.close();
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
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