import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  String s = input.next(), t = input.next();
  int[] freq = new int[10];
  for(int i = 0; i<t.length(); i++) freq[t.charAt(i)-'0']++;
  char[] res = s.toCharArray();
  int i = 0, j = 9;
  while(i<s.length() && j>=0)
  {
    while(j>=0 && freq[j] == 0) j--;
    if(j==-1) break;
    if(j > res[i] - '0')
    {
      freq[j]--;
      res[i] = (char)('0'+j);
    }
    i++;
  }
  for(char c: res) out.print(c);



  out.close();

}
static void sort(int[] data)
{
  Random r = new Random();
  int n = data.length;
  for(int i = 0; i<2*n; i++)
  {
    int a = r.nextInt(n), b = r.nextInt(n), temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  Arrays.sort(data);
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}