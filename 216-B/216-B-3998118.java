import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n = input.nextInt(), m = input.nextInt();
  g = new ArrayList[n];
  for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
  int[] as = new int[m], bs = new int[m];
  for(int i = 0; i<m; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      as[i] = a;
      bs[i] = b;
      g[a].add(b);
      g[b].add(a);
  }
  scc();
  int[] sizes = new int[count];
  int[] edgeCounts = new int[count];
  for(int i = 0; i<m; i++)
  {
      edgeCounts[id[as[i]]]++;
      edgeCounts[id[bs[i]]]++;
  }
  for(int i = 0; i<n; i++) sizes[id[i]]++;
  int res = 0;
  for(int i = 0; i<count; i++) if(sizes[i]%2 == 1 && sizes[i]!= 1 && edgeCounts[i] == 2*sizes[i]) res++;
          if((n-res)%2==1) res++;
          out.println(res);
  out.close();
  
}
static ArrayList<Integer>[] g;
static boolean[] marked;
static int[] id, low, stk;
static int pre, count;
static void scc()
{
    id = new int[g.length]; low = new int[g.length]; stk = new int[g.length+1];
    pre = count = 0;
    marked = new boolean[g.length];
    for(int i =0; i<g.length; i++)
        if(!marked[i]) dfs(i);
}
static void dfs(int i)
{
    marked[stk[++stk[0]]=i] = true;
    int min = low[i] = pre++;
    for(int j: g[i])
    {
        if(!marked[j]) dfs(j);
        if(low[j] < min) min = low[j];
    }
    if(min < low[i]) low[i] = min;
    else
    {
        while(stk[stk[0]] != i)
        {
            int j =stk[stk[0]--];
            id[j] = count;
            low[j] = g.length;
        }
        id[stk[stk[0]--]] = count++;
        low[i] = g.length;
    }
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