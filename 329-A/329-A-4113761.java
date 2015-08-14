import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int n = input.nextInt();
  char[][] data = new char[n][n];
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      for(int j = 0; j<n; j++)
          data[i][j] = s.charAt(j);
  }
  boolean[][] possible = new boolean[n][n];
  for(int i = 0; i<n;i ++)
      for(int j = 0; j<n; j++)
      {
          if(data[i][j] == 'E') continue;
          for(int k = 0; k<n; k++)
          {
              possible[i][k] = possible[k][j] = true;
          }
      }
  boolean good = true;
  for(int i =0; i<n; i++)
      for(int j = 0; j<n; j++)
          good &= possible[i][j];
  if(!good) out.println(-1);
  else
  {
      boolean[] found = new boolean[n];
//    int x = n, y = n;
//    g = new ArrayList[2*n];
//    for(int i = 0; i<2*n; i++) g[i] = new ArrayList<Integer>();
//    for(int i = 0;i<n; i++)
//        for(int j = 0; j<n; j++)
//        {
//            if(data[i][j] == '.')
//            {
//                g[i].add(j+n);
//                g[i+n].add(j);
//            }
//        }
      ArrayList<Integer> is = new ArrayList<Integer>(), js = new ArrayList<Integer>();
      for(int i = 0; i<n; i++)
      {
          boolean f = false;
          for(int j = 0; j<n; j++)
              if(data[i][j] == '.')
              {
                  f = true;
                is.add(i+1);
                js.add(j+1);
                break;
              }
          found[i] = f;
      }
      if(is.size() < n)
      {
          is = new ArrayList<Integer>(); js = new ArrayList<Integer>();
          for(int j = 0; j<n; j++)
          {
              for(int i = 0 ;i<n; i++)
                  if(data[i][j] == '.')
                  {
                      is.add(i+1);
                      js.add(j+1);
                      break;
                  }
          }
      }
      for(int i = 0; i<is.size(); i++)
      {
          out.println(is.get(i)+ " "+js.get(i));
      }
      //int match = hopcroft_karp(x, y);
      //out.println(match);
  }
  
  out.close();
}
public static long[] gcd(long p, long q)
{
    if(q==0)
        return new long[] {p, 1, 0};
    long[] vals = gcd(q, p%q);
    return new long[] {vals[0], vals[2], vals[1] - (p/q)*vals[2]};
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
public static int oo = 987654321;
public static ArrayList<Integer>[] g;
public static int a, b, x; 
public static int [] match, dist;
public static boolean bfs() 
{
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i=0; i<a; i++) 
    {
        if(match[i]==-1) 
        {
            dist[i] = 0;
            q.add(i);
        }
        else dist[i] = oo;
    }
    boolean found = false;
    while(!q.isEmpty()) 
    {
        int u = q.poll();
        if(u!=-1) 
        {
            int len = g[u].size();
            for(int i=0; i<len; i++) 
            {
                int v = g[u].get(i);
                if(match[v] == -1)
                {
                    found = true;
                    x = dist[u] + 1;
                }
                else if(dist[match[v]]==oo) 
                {
                    dist[match[v]] = dist[u] + 1;
                    q.add(match[v]);
                }
            }
        }
    }
    return found;
}
     
public static boolean dfs(int u) 
{
    if(u==-1)
        return true;
    for(int i=0; i<g[u].size(); i++)
    {
        int v = g[u].get(i);
        int d = match[v] > -1 ? dist[match[v]] : x;
        if(d==dist[u]+1 && dfs(match[v])) 
        {
            match[v] = u;
            match[u] = v;
            return true;
        }
    }
    dist[u] = oo;
    return false;
}
public static int hopcroft_karp(int n, int m) 
{
    a = n; b = m;
    int res = 0;
    match = new int[a+b];
    dist = new int[a+b];
    Arrays.fill(match, -1);
    while(bfs())
        for(int i=0; i<a; i++)
            if(match[i]==-1 && dfs(i))
                res++;
    return res;
}
}