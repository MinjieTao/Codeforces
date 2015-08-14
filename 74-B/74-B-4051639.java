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
  int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
  input.next();
  int dir = input.next().equals("head") ? -1:1;
  String s = input.next();
  boolean found = false;
  for(int i = 0; i<s.length()-1; i++)
  {
    if(s.charAt(i) == '0')
    {
      if(m>k && m<n) m++;
      else if(m<k && m>1) m--;
    }
    else
    {
      if(dir == 1 && k!=n || k == 1) m = 1;
      else m = n;
    }
    k += dir;
    if(k > n || k<1)
    {
      dir *= -1;
      k+=2*dir;
    }
    if(k==m)
    {
      found = true;
      out.println("Controller " + (i+1));
      break;
    }
  }
  if(!found) out.println("Stowaway");


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