import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  String s1 = input.next().toLowerCase();
  String s2 = input.next().toLowerCase();
  String s3 = input.next().toLowerCase();
  String t1 = "", t2 = "", t3 = "";
  for(int i = 0; i<s1.length(); i++)
  {
    char c = s1.charAt(i);
    if(c >= 'a' && c <= 'z')
      t1 += c;
  }
  for(int i = 0; i<s2.length(); i++)
  {
    char c = s2.charAt(i);
    if(c >= 'a' && c <= 'z')
      t2 += c;
  }
  for(int i = 0; i<s3.length(); i++)
  {
    char c = s3.charAt(i);
    if(c >= 'a' && c <= 'z')
      t3 += c;
  }
  String[] possibleOrders = new String[]{t1+t2+t3, t1+t3+t2, t2+t1+t3, t2+t3+t1, t3+t1+t2, t3+t2+t1};
  int n = input.nextInt();
  for(int i = 0; i<n; i++)
  {
    String s = input.next().toLowerCase();
    String t = "";
    for(int j = 0; j<s.length(); j++)
    {
      char c = s.charAt(j);
      if(c>='a' && c<='z') t += c;
    }
    boolean matches = false;
    for(int j = 0; j<6; j++)
      if(t.equals(possibleOrders[j])) matches = true;
    if(matches) out.println("ACC");
    else out.println("WA");
  }

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