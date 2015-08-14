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

int n = input.nextInt(), m = input.nextInt();
int[] ys = new int[n], ns = new int[n];
String[] data = new String[n];
int numy = 0;
for(int i = 0; i<n; i++)
{
  data[i] = input.next();
  boolean yes = data[i].charAt(0) == '+';
  int num = Integer.parseInt(data[i].substring(1));
  if(yes) ys[num-1]++;
  if(yes) numy++;
  else ns[num-1]++;
}
boolean[] can = new boolean[n];
int countCan = 0;
for(int i = 0; i<n; i++)
{
  int truth = ys[i] + (n-numy-ns[i]);
  if(truth == m)
  {
    can[i] = true;
    countCan++;
  }
}
for(int i = 0; i<n; i++)
{
  boolean yes = data[i].charAt(0) == '+';
  int num = Integer.parseInt(data[i].substring(1));
  if(!can[num-1]) out.println(yes ? "Lie" : "Truth");
  else if(countCan > 1) out.println("Not defined");
  else out.println(yes ? "Truth" : "Lie");
}
  
  out.close();
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