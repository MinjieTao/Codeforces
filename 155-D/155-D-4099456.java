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
  int n = input.nextInt(), m = input.nextInt();
  sieve = new int[n+1];
  Arrays.fill(sieve, 1);
  for(int i = 2; i<=n; i++)
  {
      if(sieve[i] != 1) continue;
      for(long j = (long)i*i; j<=n; j+=i) sieve[(int)j] = i;
  }
  //for(int x: factorize(13)) out.println(x);
  TreeSet<Integer>[] data = new TreeSet[n+1];
  for(int i =0; i<=n; i++) data[i] = new TreeSet<Integer>();
  boolean[] in = new boolean[n+1];
  for(int i = 0; i<m; i++)
  {
      char type = input.next().charAt(0);
      int x = input.nextInt();
      boolean contains = false;
      int bad = -1;
      HashSet<Integer> f = factorize(x);
      for(int ff: f)
      {
          //out.println(x+" "+ff+" "+data[ff].size());
          if(data[ff].size() > 0)
          {
              contains = true;
              bad = data[ff].first();
              break;
          }
      }
      if(in[x] && type == '+')
      {
          out.println("Already on");
      }
      else if(contains && type == '+')
      {
          out.println("Conflict with " + bad);
      }
      else if(type == '+')
      {
          in[x] = true;
          out.println("Success");
          for(int ff: f) data[ff].add(x);
      }
      else if(in[x])
      {
          in[x] = false;
          out.println("Success");
          for(int ff: f)
          {
              //out.println("Remove: "+ x+" "+ff);
              data[ff].remove(x);
          }
      }
      else
          out.println("Already off");
  }
  out.close();
}
static int[] sieve;
static HashSet<Integer> factorize(int n)
{
    HashSet<Integer> res = new HashSet<Integer>();
    if(n == 1)
    {
        //res.add(1);
        return res;
    }
    if(sieve[n] != 1)
    {
        res.add(sieve[n]);
        HashSet<Integer> others = factorize(n/sieve[n]);
        for(int x: others) res.add(x);
    }
    else res.add(n);
    return res;
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