import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  String s = input.next();
  int x = 0, y = 0;
  boolean good = true;
  HashSet<String> visited = new HashSet<String>();
  visited.add("0 0");
  int n = s.length();
  for(int i = 0; i<n; i++)
  {
    char c = s.charAt(i);
    if(c=='U') y++;
    else if(c=='D') y--;
    else if(c=='L') x--;
    else x++;
    String str = x+" "+y;
    int count = 0;
    int[] dx = new int[]{0, 1, 0, -1}, dy = {1, 0, -1, 0};
    for(int k = 0; k<4; k++)
    {
      int nx = x+dx[k], ny = y+dy[k];
      String test = nx+" "+ny;
      if(visited.contains(test)) count++;
    }
    if(visited.contains(str) || count>1) good = false;
    visited.add(str);
  }
  out.println(good?"OK":"BUG");

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