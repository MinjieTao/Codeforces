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
  int n = input.nextInt(), m = n;
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  int max = 1000;
  int[] res = new int[n];
  boolean good = true;
  for(int i = 0; i<n; i++)
  {
      ArrayList<Integer> possible = new ArrayList<Integer>();
      for(int j = 0; j<4; j++)
          for(int k = 0; k<10; k++)
          {
              int mult = 1;
              for(int l = 0; l<j; l++) mult*=10;
              int x = data[i];
              x -= mult*((x/mult)%10);
              x += mult*k;
              //out.println(i+" "+x);
              possible.add(x);
          }
      int best = -1;
      Collections.sort(possible);
      for(int j = 0; j<possible.size(); j++)
      {
          int at = possible.get(j);
          if(at>=1000 && at<=2011 && at>=max)
          {
              best = at;
              break;
          }
      }
      if(best==-1) good = false;
      else res[i] = best;
      max = Math.max(max, best);
  }
  if(!good) out.println("No solution");
  else
      for(int x: res) out.println(x);

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