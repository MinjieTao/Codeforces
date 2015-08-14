import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  String s = input.next();
  int n = input.nextInt();
  int[] f = new int[26];
  for(int i = 0; i<s.length(); i++) f[s.charAt(i)-'a']++;
  int res = -1;
  String str = "";
  for(int i = 1; i<=1000; i++)
  {
      int x = 0;
      for(int j = 0; j<26; j++)
      {
          if(f[j] == 0) continue;
          x += (f[j]+i-1)/i;
      }
      if(x<=n)
      {
          res = i;
          for(int j = 0; j<26; j++)
              for(int k = 0; k<(f[j]+i-1)/i; k++)
                  str += (char)('a'+j);
          break;
      }
  }
  out.println(res);
  if(res>-1)
  {
      while(str.length()<n) str+='a';
  }
  out.println(str);
  out.close();
}
static long pow(long x, long p)
{
    if(p==0) return 1;
    if((p&1) > 0)
    {
        return (x*pow(x, p-1))%mod;
    }
    long sqrt = pow(x, p/2);
    return (sqrt*sqrt)%mod;
}
static long gcd(long a, long b)
{
    if(b==0) return a;
    return gcd(b, a%b);
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