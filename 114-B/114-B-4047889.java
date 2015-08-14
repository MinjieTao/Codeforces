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

  int n = input.nextInt(), m = input.nextInt();
  HashMap<String, Integer> map = new HashMap<String,Integer>();
  HashMap<Integer, String> map2 = new HashMap<Integer, String>();
  for(int i = 0; i<n; i++) map.put(input.next(), i);
  for(String s: map.keySet()) map2.put(map.get(s),s);
  boolean[][] bad = new boolean[n][n];
  for(int i = 0; i<m; i++)
  {
    int a = map.get(input.next()), b = map.get(input.next());
    bad[a][b] = bad[b][a]= true;
  }
  ArrayList<String> answer = new ArrayList<String>();
  int res = 0;
  for(int i = 0; i<(1<<n); i++)
  {
    boolean good = true;
    int count = 0;
    for(int j = 0; j<n; j++)
    {
      if((i & (1<<j)) == 0) continue;
      count++;
      for(int k = 0; k<n; k++)
        if((i & (1<<k)) > 0&& bad[j][k])
          good = false;
    }
    if(good && count> res)
    {
      answer.clear();
      for(int j = 0; j<n; j++)
        if((i&(1<<j)) > 0)
          answer.add(map2.get(j));
      res = count;
    }
  }
  out.println(res);
  Collections.sort(answer);
  for(String s: answer) out.println(s);

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