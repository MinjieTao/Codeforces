import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  String s = input.next();
  boolean[] good = new boolean[26];
  String acc = input.next();
  for(int i = 0; i<26; i++) good[i] = acc.charAt(i) == '1';
  boolean allSame = true;
  for(int i = 0; i<s.length()-1; i++) allSame &= s.charAt(i) == s.charAt(i+1);
  int k = input.nextInt(), n = s.length();
  if(allSame)
  {
    out.println(good[s.charAt(0)-'a'] ? s.length(): Math.min(k, n));
  }
  else
  {
    int[][] memo = new int[1200000][26];
    int res = 0;
    for(int i = 0; i<n; i++)
    {
      int x = 0, count = 0;
      for(int j = i; j<n; j++)
      {
        if(!good[s.charAt(j)-'a']) count++;
        if(count>k) break;
        //out.println(i+" "+j+" "+x+" "+memo[x][s.charAt(j)-'a']);
        if(memo[x][s.charAt(j)-'a'] == 0) memo[x][s.charAt(j)-'a'] = ++res;
        x = memo[x][s.charAt(j)-'a'];
      }
    }
    out.println(res);
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