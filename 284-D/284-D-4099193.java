import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  int[] data = new int[n-1];
  for(int i = 0; i<n-1; i++) data[i] = input.nextInt();
  long[] bad = new long[2*(n-1)];
  for(int i = 0; i<n-1; i++)
  {
    if(data[i] > i+1) bad[i+n-1] = data[i];
    if(data[i] + i >= n-1) bad[i] = data[i];
  }
  ArrayList<Integer>[] adj = new ArrayList[2*n-2];
  for(int i = 0; i<2*(n-1); i++) adj[i] = new ArrayList<Integer>();
  for(int i = 0; i<n-1; i++)
  {
    int nextUp = i+data[i];
    if(nextUp < n-1)
    {
      adj[nextUp+n-1].add(i);
    }
    int nextDown = i-data[i];
    if(nextDown >= 0)
    {
      adj[nextDown].add(n-1+i);
    }
  }
  Queue<Integer> q = new LinkedList<Integer>();
  for(int i = 0; i<2*(n-1); i++) if(bad[i]>0) q.add(i);
  while(!q.isEmpty())
  {
    int at = q.poll();
    for(int x: adj[at])
    {
      if(bad[x]==0)
      {
        bad[x] = data[x%(n-1)]+bad[at];
        q.add(x);
      }
    }
  }
//  for(long b: bad) out.print(b+ " ");
//  out.println();
  for(int i = 0; i<n-1; i++)
    out.println(bad[i+n-1] > 0 ? bad[i+n-1]+(i+1) : -1);


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