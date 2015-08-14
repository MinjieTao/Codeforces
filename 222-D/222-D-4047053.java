import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), k = input.nextInt();
  int[] as = new int[n], bs = new int[n];
  for(int i = 0; i<n; i++) as[i] = input.nextInt();
  for(int i = 0; i<n; i++) bs[i] = input.nextInt();
  Random r = new Random();
  for(int i = 0; i<100000; i++)
  {
    int a = r.nextInt(n), b = r.nextInt(n);
    int t1 = as[a], t2 = bs[a];
    as[a] = as[b]; as[b] = t1; bs[a] = bs[b]; bs[b] = t2;
  }
  Arrays.sort(as);
  Arrays.sort(bs);
  int i = 0, j = n-1;
  for(j = n-1; j>=0; j--)
  {
    while(i<n && as[i]+bs[j] < k) i++;
    i++;
    if(i>n) break;
  }
  out.println(1+" "+(n-1-j));


  out.close();
}
static long pow(long a, long p)
{
  if(p==0) return 1;
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