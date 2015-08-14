import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), k = input.nextInt()-1;
  int[] data = new int[n];
  for(int i = 0; i<n; i++)
  {
    data[i] = input.nextInt()-1;
  }
  int[] rev = new int[n];
  Arrays.fill(rev, -1);
  for(int i = 0; i<n; i++) if(data[i] != -1) rev[data[i]] = i;
  ArrayList<Integer> sizes = new ArrayList<Integer>();
  boolean[] visited = new boolean[n+1];
  visited[k] = true;
  int at = k, kcount = 1;
  while(at != -1)
  {
    at = data[at];
    if(at != -1)
    {
      visited[at] = true;
      kcount++;
    }
  }
  at = k;
  while(at != -1)
  {
    at = rev[at];
    if(at != -1) visited[at] = true;
  }
  for(int i = 0; i<n; i++)
  {
    if(visited[i]) continue;
    visited[i] = true;
    at = i; int count = 1;
    while(at != -1)
    {
      at = data[at];
      if(at != -1)
      {
        visited[at] = true;
        count++;
      }
    }
    at = i;
    while(at != -1)
    {
      at = rev[at];
      if(at != -1)
      {
        visited[at] = true;
        count++;
      }
    }
    sizes.add(count);
  }
  N = sizes.size();
  ss = new int[N];
  for(int i = 0; i<N; i++) ss[i] = sizes.get(i);
  memo = new int[n+1][n+1];
  for(int[] A: memo) Arrays.fill(A, -1);
  ArrayList<Integer> res = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
    if(possible(i, 0)==1)
      res.add(i+kcount);
  for(int r: res) out.println(r);
  //out.println(kcount);
  //for(int s: sizes) out.println(s);
  out.close();
}
static int N;
static int[] ss;
static int[][] memo;
static int possible(int sum, int at)
{
  if(sum < 0) return 0;
  if(at==N && sum > 0) return 0;
  if(sum == 0) return 1;
  if(memo[sum][at] != -1) return memo[sum][at];
  return memo[sum][at] = possible(sum, at+1) | possible(sum-ss[at], at+1);
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
}
}