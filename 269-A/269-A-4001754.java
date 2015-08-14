import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n = input.nextInt();
  Square[] data = new Square[n];
  int[] ks = new int[n], as = new int[n];
  for(int i = 0; i<n;i++) data[i] = new Square(input.nextInt(), input.nextInt());
  Arrays.sort(data);
  for(int i = 0; i<n; i++)
  {
      ks[i] = data[i].k;
      as[i] = data[i].a;
  }
  //sort!
  for(int i = 0; i<n-1;i++)
  {
      int diff = ks[i+1]-ks[i];
      if(diff <=50)
      while(diff>0 && as[i]>1)
      {
          diff--;
          as[i] = (as[i]+3)/4;
      }
      else
          as[i]=1;
      as[i+1]=Math.max(as[i+1],as[i]);
  }
  int needed = ks[n-1]+1;
  while(as[n-1]>4)
  {
      as[n-1] = (as[n-1]+3)/4;
      needed++;
  }
  out.println(needed);
  out.close();
  
}
static class Square implements Comparable<Square>
{
    int k, a;
    public Square(int kk, int aa)
    {
        k = kk; a = aa;
    }
    @Override
    public int compareTo(Square o) {
        // TODO Auto-generated method stub
        return this.k - o.k;
    }
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