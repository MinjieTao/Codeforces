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
  String s = input.next();
  int n = s.length();
  int k = input.nextInt();
  int[] freq =new int[26];
  for(int i = 0; i<n; i++)
  {
      freq[s.charAt(i)-'a']++;
  }
  boolean[] go = new boolean[26];
  for(int i = 0; i<26; i++)
  {
      int min = 1000000, mindex = -1;
      for(int j = 0; j<26; j++)
      {
          if(freq[j] < min && !go[j])
          {
              min = freq[j];
              mindex = j;
          }
      }
      if(min<=k)
      {
          k -= min;
          go[mindex] = true;
      }
      else
          break;
  }
  int count = 0;
  for(int i = 0; i<26; i++)
      if(freq[i] > 0 && !go[i]) count++;
  out.println(count);
  for(int i = 0; i<n; i++)
      if(!go[s.charAt(i)-'a']) out.print(s.charAt(i));
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