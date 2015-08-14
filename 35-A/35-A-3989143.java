import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(System.out);
  
  int n=  input.nextInt();
  for(int i =0; i<3; i++)
  {
      int a = input.nextInt(), b = input.nextInt();
      if(n==a) n = b;
      else if(n==b) n=a;
  }
  out.println(n);
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