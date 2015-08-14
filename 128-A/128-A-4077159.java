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
  char[][] grid = new char[8][8];
  int sr = 7, sc = 0, er = 0, ec = 7;
  for(int i = 0; i<8; i++)
  {
    String s = input.next();
    for(int j = 0; j<8; j++) grid[i][j] = s.charAt(j);
  }
  boolean[][] visited = new boolean[64][26];
  Queue<Integer> q = new LinkedList<Integer>();
  q.add(8*sr+sc);
  visited[8*sr+sc][0] = true;
  int[] dx = new int[]{0, 1, 0, -1, 1, 1, -1, -1, 0}, dy = new int[]{1,0,-1,0, 1, -1, 1, -1, 0};
  while(!q.isEmpty())
  {
    int at = q.poll();
    int moves = at/64, atr = (at%64)/8, atc = at%8;
    if(moves>=25) break;
    for(int k = 0; k<9; k++)
    {
      int ny = atr+dy[k], nx = atc+dx[k];
      if(nx<0 || ny<0 || nx>7 || ny>7) continue;
      if(ny - moves >=0 && grid[ny-moves][nx] == 'S') continue;
      if(ny - moves - 1 >=0 && grid[ny-moves-1][nx] == 'S') continue;
      if(visited[8*ny+nx][moves+1]) continue;
      visited[8*ny+nx][moves+1] = true;
      q.add(8*ny+nx+64*(moves+1));
    }
  }
  boolean good = false;
  for(int i = 0; i<25; i++) good |= visited[8*er+ec][i];
  out.println(good?"WIN":"LOSE");

  out.close();
}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
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