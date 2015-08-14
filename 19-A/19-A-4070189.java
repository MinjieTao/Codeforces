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
  int n = input.nextInt();
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  HashMap<String, Integer> scored = new HashMap<String, Integer>();
  HashMap<String, Integer> allowed = new HashMap<String, Integer>();
  for(int i = 0; i<n; i++) map.put(input.next(), 0);
  for(String s: map.keySet())
  {
      scored.put(s,0);
      allowed.put(s, 0);
  }
  for(int i = 0; i<n*(n-1)/2; i++)
  {
      String s = input.next();
      String first = s.substring(0, s.indexOf('-'));
      String second = s.substring(s.indexOf('-')+1);
      s = input.next();
      int score1 = Integer.parseInt(s.substring(0, s.indexOf(':')));
      int score2 = Integer.parseInt(s.substring(s.indexOf(':')+1));
      scored.put(first, scored.get(first) + score1);
      scored.put(second, scored.get(second) + score2);
      allowed.put(second, allowed.get(second) + score1);
      int a1 = 0, a2 = 0;
      allowed.put(first, allowed.get(first) + score2);
      if(score1>score2) a1 = 3;
      else if(score2>score1) a2 = 3;
      else a1 = a2 = 1;
      map.put(first, map.get(first)+a1);
      map.put(second, map.get(second)+a2);
  }
  Team[] data = new Team[n];
  int i = 0;
  for(String s: map.keySet())
  {
      data[i++] = new Team(s, scored.get(s), allowed.get(s), map.get(s));
  }
  Arrays.sort(data);
  ArrayList<String> res = new ArrayList<String>();
  for(i = 0; i<n/2; i++) res.add(data[i].name);
  Collections.sort(res);
  for(String s: res)
      out.println(s);
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