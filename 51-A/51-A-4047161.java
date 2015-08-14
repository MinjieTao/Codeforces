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
  int n = input.nextInt();
  HashSet<String> data = new HashSet<String>();
  for(int i = 0; i<n; i++)
  {
    if(i>0) input.next();
    char[] s = (input.next() + input.next()).toCharArray();
    ArrayList<String> list = new ArrayList<String>();
    list.add(""+s[0]+s[1]+s[3]+s[2]);
    list.add(""+s[1]+s[3]+s[2]+s[0]);
    list.add(""+s[3]+s[2]+s[0]+s[1]);
    list.add(""+s[2]+s[0]+s[1]+s[3]);
    Collections.sort(list);
    data.add(list.get(0));
  }
  out.println(data.size());


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