import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int w = input.nextInt(), b = input.nextInt();
  
  memo = new double[1001][1001];
  for(double[] A : memo) Arrays.fill(A,-1);
          out.println(prob(w,b,0));

  out.close();
}
static double[][] memo;
static double prob(int a, int b, int t)
{
    if(a==0 && b ==0) return t == 0 ? 0 : 1;
    if(b<=0) return 1;
    if(a<=0) return 0;
    if(memo[a][b]!= -1) return memo[a][b];
    if(t == 0)
    {
        return memo[a][b]=1.*a/(a+b) + 1.*b/(a+b) * (1 - prob(a,b-1,1-t));
    }
    else if(a+b==1) return memo[a][b]=1;
    else return memo[a][b]=1.*a/(a+b) + 1.*b/(a+b) * (1.*a/(a+b-1)*(1-prob(a-1,b-1,1-t)) + 1.*(b-1)/(a+b-1)*(1-prob(a,b-2,1-t)));
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