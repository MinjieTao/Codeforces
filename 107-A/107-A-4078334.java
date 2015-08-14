import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    boolean[] primes = new boolean[10000001];
    for(int i = 0; i<primes.length; i++) primes[i] = true;
    primes[0] = false;
    primes[1] = false;
    for(int i = 2; i<primes.length; i++)
    {
        if(primes[i])
        {
            for(int j = 2*i; j < primes.length; j+=i)
                primes[j] = false;
        }
    }
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), p = input.nextInt();
  int[] to = new int[n], from = new int[n];
  Arrays.fill(to, -1);
  Arrays.fill(from, -1);
  int[] dist = new int[n];
  for(int i = 0; i<p; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1, d = input.nextInt();
      to[a] = b;
      from[b] = a;
      dist[a] = d;
  }
  int count = 0;
  for(int i = 0; i<n; i++) if(from[i] == -1 && to[i] != -1) count++;
  out.println(count);
  for(int i = 0; i<n; i++)
  {
      if(from[i] != -1 || to[i] == -1) continue;
      int max = 10000000;
      int at = i;
      while(to[at] != -1)
      {
          max = Math.min(max, dist[at]);
          at = to[at];
      }
      out.println((i+1)+" "+(at+1)+" "+max);
  }
  out.close();
}

static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}