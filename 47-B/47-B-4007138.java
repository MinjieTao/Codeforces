import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int[] freq = new int[3];
for(int i = 0; i<3; i++)
{
  String s = input.next();
  char first = 'a';
  if(s.charAt(1) == '>')
    first = s.charAt(2);
  else first = s.charAt(0);
  freq[first-'A']++;
}
String res = "";
for(int i = 0; i<3; i++)
  for(int j = 0; j<3; j++)
    if(freq[j] == 2-i)
      {res+=((char)('A'+j)); break;}
if(res.length()!= 3) res = "Impossible";
out.println(res);
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

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}