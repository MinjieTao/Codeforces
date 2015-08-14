import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt(), x = input.nextInt();
  int[] data = new int[1001];
  for(int i = 0; i<n; i++)
  {
    int a = input.nextInt(), b = input.nextInt();
    if(a>b)
    {
      int temp = a; a = b; b = temp;
    }
    for(int j = a; j<=b; j++) data[j]++;
  }
  int res = 2000;
  for(int i = 0; i<=1000; i++)
  {
    if(x - i >= 0 && data[x-i] == n || x + i < 1001 && data[x+i] == n)
    {
      res = i;
      break;
    }
  }
  out.println(res==2000 ? -1:res);



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