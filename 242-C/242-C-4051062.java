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
  int x0 = input.nextInt(), y0 = input.nextInt(), x1 = input.nextInt(), y1 = input.nextInt();
  HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
  int n = input.nextInt();
  for(int i = 0; i<n; i++)
  {
    int r = input.nextInt(), a = input.nextInt(), b = input.nextInt();
    if(!map.containsKey(r)) map.put(r, new HashSet<Integer>());
    for(int j = a; j<=b; j++) map.get(r).add(j);
  }
  HashMap<String, Integer> dist = new HashMap<String,Integer>();
  Queue<Integer> rq = new LinkedList<Integer>(), cq = new LinkedList<Integer>();
  dist.put(x0+" "+y0, 0);
  rq.add(x0);
  cq.add(y0);
  int[] dx = {1,0,-1,0, 1, 1, -1, -1}, dy = {0,1,0,-1, 1, -1, 1, -1};
  while(!rq.isEmpty())
  {
    int atx = rq.poll(), aty = cq.poll();
    if(atx==x1 && aty == y1) break;
    int curDist = dist.get(atx+" "+aty);
    //out.println(atx+" "+aty+" "+curDist);
    for(int k = 0; k<8; k++)
    {
      int nx = atx+dx[k], ny = aty+dy[k];
      if(nx<1 || nx>1e9 || ny<1 || ny>1e9) continue;
      if(map.containsKey(nx)  && map.get(nx).contains(ny))
      {
        if(!dist.containsKey(nx+" "+ny))
        {
          dist.put(nx+" "+ny, curDist+1);
          rq.add(nx);
          cq.add(ny);
        }
      }
    }
  }
  out.println(dist.containsKey(x1+" "+y1) ? dist.get(x1+" "+y1) : -1);

  out.close();
}
static class State
{
  int row, col;
  public State(int r, int c)
  {
    row = r; col = c;
  }
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