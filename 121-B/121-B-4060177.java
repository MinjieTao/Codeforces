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
  int n = input.nextInt(), k = input.nextInt();
  int[] data = new int[n];
  String s = input.next();
  for(int i = 0; i<n; i++) data[i] = s.charAt(i) - '0';
  int at = 0, change = 0;
  for(int i = 0; change<k; i++)
  {
      if(at==n-1) break;
      if(at<n-2 && at%2 == 0 && data[at] == 4 && data[at+2] == 7 && (data[at+1] == 4 || data[at+1] == 7))
      {
          if((k-change)%2 == 1)
          {
              data[at+1] = 11-data[at+1];
          }
          break;
      }
      else if(data[at] == 4 && data[at+1] == 7)
      {
          change++;
          if(at%2 == 0)
              data[at+1] = 4;
          else data[at] = 7;
          if(at>0) at--;
      }
      else at++;
  }
  for(int i: data) out.print(i);
  

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