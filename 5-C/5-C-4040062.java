import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  String s = input.next();
  int n = s.length();
  Stack<Integer> stk = new Stack<Integer>();
  int[] last = new int[n], first = new int[n];
  Arrays.fill(first, -1);
  for(int i = 0; i<n; i++)
  {
    char c = s.charAt(i);
    if(c=='(') stk.push(i);
    else
    {
      if(stk.isEmpty()) continue;
      else
      {
        int l = stk.pop();
        first[i] = last[i] = l;
        if(l>0 && s.charAt(l-1) == ')' && first[l-1] != -1) first[i] = first[l-1];
      }
    }
    //out.println(i+" "+first[i]);
  }
  int max = 0, count = 0;
  for(int i = 0; i<n; i++)
  {
    if(first[i] == -1) continue;
    int d = i - first[i] + 1;
    if(d>max) {max = d; count=1;}
    else if(d==max) count++;
  }
  if(max == 0) count = 1;
  out.println(max+" "+count);

  out.close();

}
static class Cup implements Comparable<Cup>
{
  int x, i;
  public Cup(int xx, int ii)
  {
    x = xx; i = ii;
  }
  @Override
  public int compareTo(Cup o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.x - o.x;
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