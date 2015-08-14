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
  String s = '#'+input.next();
  String t = input.next();
  int n = s.length();
  int[][] next = new int[n][26];
  for(int[] A: next) Arrays.fill(A, -1);
  for(int i = 1; i<n; i++)
  {
      char c = s.charAt(i);
      int at = i;
      int count = 0;
      while(s.charAt(at) != c || count==0)
      {
          ++count;
          //out.println(at+" "+(c-'a'));
          at--;
          if(at<0) at = n-1;
          next[at][c-'a'] = i;
          
      }   
  }
  int at = 0, res = 1;
  boolean good = true;
  for(int i = 0; i<t.length(); i++)
  {
      int to = next[at][t.charAt(i)-'a'];
      //out.println(to+" "+res);
      if(to==-1)
      {
          //out.println(i);
          good = false;
          break;
      }
      else if(to<=at)
      {
          at = to;
          res++;
      }
      else at = to;
  }
  out.println(good?res:-1);
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