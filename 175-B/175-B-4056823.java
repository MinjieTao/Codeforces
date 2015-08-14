import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt();
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  ArrayList<Integer> data = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      int x = input.nextInt();
      if(!map.containsKey(s) || map.get(s) < x) map.put(s, x);
  }
  for(String s: map.keySet()) 
      data.add(map.get(s));
  Collections.sort(data);
  int a = data.get(data.size()-(int)Math.ceil(map.keySet().size()*.010000001));
  int b = data.get(data.size()-(int)Math.ceil(map.keySet().size()*.10000001));
  int c = data.get(data.size()-(int)Math.ceil(map.keySet().size()*.20000001));
  int d = data.get(data.size()-(int)Math.ceil(map.keySet().size()*.50000001));
  out.println(data.size());
  for(String s: map.keySet())
  {
      out.print(s+" ");
      int x = map.get(s);
      if(x>=a) out.println("pro");
      else if(x>=b) out.println("hardcore");
      else if(x>=c) out.println("average");
      else if(x>=d) out.println("random");
      else out.println("noob");
  }
  

  out.close();
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}