import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), k = input.nextInt();
  String s = input.next();
  int[] freq = new int[10];
  for(int i = 0; i<n; i++) freq[s.charAt(i)-'0']++;
  int[] count = new int[10];
  String[] ans = new String[10];
  for(int i = 0; i<10; i++)
  {
    if(freq[i] >= k)
    {
      ans[i] = s;
      count[i] = 0;
    }
    else
    {
      int needed = k - freq[i];
      int diff = 0;
      int[] change = new int[10];
      while(needed > 0)
      {
        diff++;
        if(i + diff < 10)
        {
          int x = Math.min(freq[i+diff], needed);
          change[i+diff] += x;
          needed -= x;
          count[i] += x*diff;
        }
        if(i - diff >= 0)
        {
          int x = Math.min(freq[i-diff], needed);
          change[i-diff] += x;
          needed -= x;
          count[i] += x*diff;
        }
      }
      char[] modified = new char[n];
      for(int j = 0; j<n; j++) modified[j] = s.charAt(j);
      for(int j = 0; j<n; j++)
      {
        char c = s.charAt(j);
        if(change[c-'0'] > 0 && (c-'0') > i)
        {
          change[c-'0']--;
          modified[j] = (char)('0'+i);
        }
      }
      for(int j = n-1; j>=0; j--)
      {
        char c = s.charAt(j);
        if(change[c-'0'] > 0)
        {
          change[c-'0']--;
          modified[j] = (char)('0'+i);
        }
      }
      ans[i] = new String(modified);
    }
  }
  int mindex = 0;
  for(int i = 1; i<10; i++)
  {
    if(count[i] < count[mindex] || count[i] == count[mindex] && ans[i].compareTo(ans[mindex]) < 0)
      mindex = i;
  }
  out.println(count[mindex]+"\n"+ans[mindex]);

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