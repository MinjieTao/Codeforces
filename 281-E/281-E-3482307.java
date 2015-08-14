import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for(int i =0; i<n; i++) adj[i] = new ArrayList<Integer>();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        adj[a-1].add(b-1);
        adj[b-1].add(a-1);
    }
    double res = 0;
    int[] dist = new int[n];
    dist[0] = 1;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        res += 1./dist[at];
        for(int i: adj[at])
            if(dist[i]==0)
            {
                dist[i] = dist[at]+1;
                q.offer(i);
            }
    }
    out.println(res);
    out.close();
}
//Fast Scanner
//throw IOException
//input.init(System.in);
public static class input {
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
}
}