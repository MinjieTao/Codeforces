import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  String s = input.next();
  int n = input.nextInt();
  String[] ps = new String[n];
  int[] as = new int[n], bs = new int[n];
  boolean[][] good = new boolean[s.length()][n];
  for(int i = 0; i<n; i++)
  {
    ps[i] = input.next();
    as[i] = input.nextInt(); 
    bs[i] = input.nextInt();
    for(int j = 0; j<s.length(); j++)
    {
      int start = j, end = j+ps[i].length();
      if(end > s.length()) break;
      if(s.substring(start, end).equals(ps[i])) good[j][i] = true;
    }
  }
  HashSet<String> res =new HashSet<String>();
  for(int i = 0; i<s.length(); i++)
    for(int j = i+1; j<=s.length(); j++)
    {
      boolean okay = true;
      for(int k = 0; k<n; k++)
      {
        int count = 0;
        for(int l = 0; l<ps[k].length(); l++)
        {
          int start = l, end = l+j-i;
          if(end > ps[k].length()) break;
          //System.out.println(s.substring(i,j) + " "+ps[k].substring(start, end));
          if (ps[k].substring(start, end).equals(s.substring(i,j))) count++;
        }
        //System.out.println(k+" "+count);
        if(count < as[k] || count > bs[k])
        {
          okay = false;
          break;
        }
       
      }
      if(okay) res.add(s.substring(i,j));
    }
  //for(String str: res) out.println(str);
  out.println(res.size());
  out.close();
}
static int N;
static int[] ss;
static int[][] memo;
static int possible(int sum, int at)
{
  if(sum < 0) return 0;
  if(at==N && sum > 0) return 0;
  if(sum == 0) return 1;
  if(memo[sum][at] != -1) return memo[sum][at];
  return memo[sum][at] = possible(sum, at+1) | possible(sum-ss[at], at+1);
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
}
}