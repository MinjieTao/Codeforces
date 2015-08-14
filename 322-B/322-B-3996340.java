import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
  int res = a/3+b/3+c/3 + Math.min(a%3, Math.min(b%3, c%3));
  int res2 = Math.min(a,  Math.min(b,c));
  a-=res2;
  b-=res2;
  c-=res2;
  res = Math.max(res, res2);
  a+=res2;
  b+=res2;
  c+=res2;
  res2 = 0;
  if((a%3 == b%3 && c>=a%3) || (a%3 == c%3&&b>=a%3))
  {
      res2+=a%3;
      int na=a-a%3;
      int nb=b-a%3;
      int nc=c-a%3;
      res2 += na/3+nb/3+nc/3;
  }
  else if(b%3 == c%3 && a>=b%3)
  {
      res2+=b%3;
      int na=a-b%3;
      int nb=b-b%3;
      int nc=c-b%3;
      res2 += na/3+nb/3+nc/3;
  }
  res = Math.max(res, res2);
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
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}