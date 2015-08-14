import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(new PrintStream(System.out));
  input.init(new FileInputStream(new File("input.txt")));
  PrintWriter out = new PrintWriter(new File("output.txt"));
  String s = input.next(), t = input.next();
  int[] f1 = new int[26], f2 = new int[26];
  int[] left = new int[26];
  int n = s.length();
  for(int i = 0; i<n; i++) left[s.charAt(i)-'A'] = ++f1[s.charAt(i)-'A'];
  for(int i = 0; i<n; i++) f2[t.charAt(i)-'A']++;
  int count = 0;
  char[] sa = s.toCharArray();
  for(int i = 0; i<n; i++)
  {
    left[sa[i]-'A']--;
    if(f1[sa[i]-'A'] > f2[sa[i]-'A'])
    {
      boolean found = false;
      for(int j = 0; j<sa[i]-'A'; j++)
      {
        if(f2[j] > f1[j])
        {
          found = true;
          int from = sa[i]-'A';
          f1[from]--;
          sa[i] = (char)('A'+j);
          f1[sa[i]-'A']++;
          count++;
          break;
        }
      }
      //out.println(found+" "+f1[sa[i]-'A'] + " "+left[sa[i]-'A']+" "+f2[sa[i]-'A']);
      if(!found && f1[sa[i]-'A'] - left[sa[i]-'A'] > f2[sa[i]-'A'])
      {
        for(int j = sa[i]-'A'+1; j<26; j++)
        {
          if(f2[j] > f1[j])
          {
            found = true;
            int from = sa[i]-'A';
            f1[from]--;
            sa[i] = (char)('A'+j);
            f1[sa[i]-'A']++;
            count++;
            break;
          }
        }
      }
    }
  }
  out.println(count+"\n"+new String(sa));



  out.close();
}
static boolean[][] adj;
static int[] last, visited;
static int res;
static void dfs(int x)
{
  visited[x] = 1;
  for(int i = 0; i<adj.length; i++)
  {
    if(!adj[x][i]) continue;
    if(visited[i] == 0)
    {
      last[i] = x;
      dfs(i);
    }
    else if(visited[i] == 1)
    {
      last[i] = x;
      res = i;
    }
  }
  visited[x] = 2;
}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
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

  /**
   * @return
   */
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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