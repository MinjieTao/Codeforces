import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  k = input.nextInt();
  g = new ArrayList[n];
  for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
  for(int i = 0; i<m; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      g[a].add(b);
      g[b].add(a);
  }
  last = new int[n];
  done = false;
  Arrays.fill(last,-1);
  dfs(0);

  out.close();
}
static int k;
static void dfs(int at)
{
    int count = 0;
    for(int i: g[at])
    {
        if(i != 0 && last[i] == -1)
        {
            count++;
            last[i] = at;
            dfs(i);
            if(done) break;
        }
    }
    if(count == 0)
    {
        HashSet<Integer> connect = new HashSet<Integer>();
        for(int i: g[at]) connect.add(i);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(at);
        while(ans.size()<=k || !connect.contains(at))
        {
            at = last[at];
            ans.add(at);
        }
        System.out.println(ans.size());
        for(int x: ans) System.out.print((1+x)+" ");
        done = true;
    }
}
static boolean done;
static int[] last;
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