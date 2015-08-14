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
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  boolean okay = true;
  boolean found1 = false, found2 = false;
  int left = -1, right = -1;
  for(int i = 0; i<n; i++)
  {
    if(!found1 && data[i] != i+1)
    {
      found1 = true;
      left = i;
    }
    else if(found1 && !found2 && (data[i] != data[i-1]-1 || i == n-1))
    {
      found2 = true;
      right = data[i] == i+1 ? i-1:i;
    }
    else if(found2 && data[i] != i+1)
      okay = false;
  }
  //sout.println(left+" "+right);
  if(!found1 || !found2) okay = false;
  else for(int i = left; i<=right; i++)
    okay &= data[i] == right - (i-left) + 1;
  if(okay) out.println((1+left)+" "+(1+right));
  else out.println(0+" "+0);


  out.close();
}
static double angle(double dx1, double dy1, double dx2, double dy2)
{
  return Math.acos((dx1*dx2+dy1*dy2)/Math.sqrt(dx1*dx1+dy1*dy1)/Math.sqrt(dx2*dx2+dy2*dy2));
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