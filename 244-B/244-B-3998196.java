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
  int res = 0;
  if(n==1000000000) res++;
  for(int i = 0; i<10; i++)
      for(int j =i+1; j<10; j++)
      {
          for(int len = 1; len<=9; len++)
          {
              for(int m = 1; m<(1<<len)-1; m++)
              {
                  int x = 0;
                  int first = 0;
                  for(int k = 0; k<len; k++)
                  {
                      if(k==0) first = (m&(1<<k)) > 0 ? i:j;
                      x*=10;
                      if((m&(1<<k)) > 0) x += i;
                      else x += j;
                  }
                  if(first!= 0 && x<=n)
                  {
                      //out.println(x);
                      res++;
                  }
              }
          }
      }
  for(int i = 1; i<10; i++)
      for(int len = 1; len<10; len++)
      {
          int x = 0;
          for(int k = 0; k<len; k++)
          {
              x*=10;
              x+=i;
          }
          if(x<=n) res++;
      }
  //res += n/10;
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