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
  int t = input.nextInt(), m = input.nextInt();
  int[] mem = new int[m];
  int id = 0;
  for(int i = 0; i<t; i++)
  {
    String s = input.next();
    if(s.equals("defragment"))
    {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for(int x: mem) if(x!= 0) list.add(x);
      Arrays.fill(mem, 0);
      for(int j = 0; j<list.size(); j++) mem[j] = list.get(j);
    }
    else if(s.equals("alloc"))
    {
      int size = input.nextInt();
      int oldId = id;
      for(int j = 0; j+size-1<m; j++)
      {
        boolean okay = true;
        for(int k = j; k<j+size; k++)
          okay &= mem[k] == 0;
        if(okay)
        {
          id++;
          for(int k = j; k<j+size; k++) mem[k] = id;
          break;
        }
      }
      if(oldId == id) out.println("NULL");
      else out.println(id);
    }
    else
    {
      int num = input.nextInt();
      boolean found = false;
      if(num>0)
      {
        for(int j = 0; j<m; j++)
        {
          if(mem[j] == num)
          {
            mem[j] = 0;
            found = true;
          }
        }
      }
      if(!found) out.println("ILLEGAL_ERASE_ARGUMENT");
    }
  }

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

  /**
   * @return
   */
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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