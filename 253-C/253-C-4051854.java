import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(new PrintStream(System.out));
  input.init(new FileInputStream(new File("input.txt")));
  //Scanner input = new Scanner(new File("input.txt"));
  PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  int r0 = input.nextInt()-1, c0 = input.nextInt()-1, r1 = input.nextInt()-1, c1 = input.nextInt()-1;
  int[] visited = new int[10000101];
  Queue<Integer> q = new LinkedList<Integer>();
  visited[100*c0+r0] = 1;
  q.add(100*c0+r0);
  int[] dx = new int[]{1,0,-1,0}, dy = {0,1,0,-1};
  while(!q.isEmpty())
  {
    int at = q.poll(), x = visited[at];
    int atr = at%100, atc = at/100;
    if(atr == r1 && atc == c1)
    {
      out.println(x-1);
      break;
    }
    for(int k = 0; k<4; k++)
    {
      int nr = atr+dy[k], nc = atc+dx[k];
      if(nr >= n || nr<0 || nc<0 || (nc>data[nr] && k==0)) continue;
      if(nc > data[nr]) nc = data[nr];
      int key = 100*nc+nr;
      if(visited[key] == 0)
      {
        visited[key] = 1+x;
        q.add(key);
      }
    }
  }

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