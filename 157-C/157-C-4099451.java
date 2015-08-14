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
  String s = input.next(), t = input.next();
  int min = 5000;
  for(int i = 0; i<2001; i++) s = "."+s+".";
  for(int i = 0; i<=s.length()-t.length(); i++)
  {
      int count = 0;
      for(int j = 0; j<t.length(); j++)
          if(s.charAt(i+j)!= t.charAt(j))
              count++;
      min = Math.min(min, count);
  }
  out.println(min);
  out.close();
}
static class Team implements Comparable<Team>
{
    String name;
    int scored, allowed, points;
    public Team(String n, int s, int a, int p)
    {
        name = n;
        scored = s;
        allowed = a;
        points = p;
    }
    @Override
    public int compareTo(Team that) {
        // TODO Auto-generated method stub
        if(this.points == that.points)
        {
            if(this.scored - this.allowed == that.scored - that.allowed)
                return that.scored - this.scored;
            else
                return that.scored - that.allowed - (this.scored - this.allowed);
        }
        else
            return that.points - this.points;
    }
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