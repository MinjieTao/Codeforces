import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static class Comp implements Comparator<Integer> {

    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Integer o1, Integer o2) {
      // TODO(mkirsche): Auto-generated method stub
      return o2.intValue()-o1.intValue();
    }

  }
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), v = input.nextInt();
  int[] data = new int[n], types = new int[n];
  ArrayList<Integer> as = new ArrayList<Integer>(), bs = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    int t = input.nextInt();
    int x = input.nextInt();
    data[i] = x;
    types[i] = t-1;
    if(t==1) as.add(x);
    else bs.add(x);
  }
  int[][] used = new int[2][10001];
  PriorityQueue<Integer> ones = new PriorityQueue<Integer>(n,new Comp()), twos = new PriorityQueue<Integer>(n, new Comp());
  for(int i = as.size()-1; i>=0; i--) ones.add(as.get(i));
  for(int i = bs.size()-1; i>=0; i--) twos.add(bs.get(i));
  long res = 0;
  while(!ones.isEmpty() && v>0 || !twos.isEmpty() && v>1)
  {
    if(ones.isEmpty())
    {
      used[1][twos.peek()]++;
      res += twos.poll();
      v -= 2;
    }
    else if(twos.isEmpty() || v == 1)
    {
      used[0][ones.peek()]++;
      res += ones.poll();
      v--;
    }
    else if(ones.size()==1)
    {
      int a = ones.peek(), b = twos.peek();
      if(a>=b)
      {
        used[0][ones.peek()]++;
        res += ones.poll();
        v--;
      }
      else
      {
        used[1][twos.peek()]++;
        res += twos.poll();
        v -= 2;
      }
    }
    else
    {
      int a1 = ones.poll(), a2 = ones.peek(), b = twos.poll();
      if(a1+a2>=b)
      {
        used[0][a1]++;
        res += a1;
        twos.add(b);
        v--;
      }
      else
      {
        used[1][b]++;
        res += b;
        ones.add(a1);
        v -= 2;
      }
    }
  }
  out.println(res);
  for(int i = 0; i<n; i++)
  {
    if(used[types[i]][data[i]] > 0)
    {
      used[types[i]][data[i]]--;
      out.print((i+1)+" ");
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