import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  String s = input.nextLine();
  StringTokenizer str = new StringTokenizer(s," ");
  ArrayList<String> tokens = new ArrayList<String>();
  while(str.hasMoreTokens()) tokens.add(str.nextToken());
  for(int i = 0; i<tokens.size(); i++)
  {
    s = tokens.get(i);
    char c = s.charAt(0);
    if(c<'a' || c>'z')
    {
      s = s.substring(1);
      tokens.set(i-1,tokens.get(i-1)+c);
    }
    for(int j = 0; j<s.length()-1; j++)
    {
      if(s.charAt(j) < 'a' || s.charAt(j) > 'z')
      {
        s = s.substring(0, j+1)+" "+s.substring(j+1);
        j++;
      }
    }
    tokens.set(i,s);
  }
  out.print(tokens.get(0));
  for(int i = 1; i<tokens.size(); i++) if(tokens.get(i).length() >0) out.print(" "+tokens.get(i));

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