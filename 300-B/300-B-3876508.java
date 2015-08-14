import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  boolean[][] adj = new boolean[n][n];
  for(int i = 0; i<m; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1;
    adj[a][b] = adj[b][a] = true;
  }
  boolean[] visited = new boolean[n];
  ArrayList<Integer> one = new ArrayList<Integer>(), two = new ArrayList<Integer>(), three = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    if(visited[i]) continue;
    ArrayList<Integer> com = new ArrayList<Integer>();
    visited[i] = true;
    com.add(i);
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(i);
    while(!q.isEmpty())
    {
      int at = q.poll();
      for(int j =0; j<n; j++)
      {
        if(adj[at][j])
        if(!visited[j])
        {
          visited[j] = true;
          com.add(j);
          q.add(j);
        }
      }
    }
    //out.println(com.size());
    if(com.size()==1)
      for(int a: com)
        one.add(a+1);
    if(com.size()==2)
      for(int a: com)
        two.add(a+1);
    if(com.size()==3)
      for(int a: com)
        three.add(a+1);
  }
  int a = one.size(), b = two.size(), c = three.size();
  //out.println(a+" "+b+" "+c);
  if(a+b+c < n || b/2+c/3 > n/3) out.println(-1);
  else
  {
    for(int i = 0; i<c/3; i++)
    {
      out.println(three.remove(0)+" "+three.remove(0)+" "+three.remove(0));
    }
    for(int i = 0; i<b/2; i++)
    {
      out.println(two.remove(0)+" "+two.remove(0) + " "+one.remove(0));
    }
    while(one.size()>0)
    {
      out.println(one.remove(0)+" "+one.remove(0)+" "+one.remove(0));
    }
  }
  out.close();
  
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}