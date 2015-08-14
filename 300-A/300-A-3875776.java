import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), x;
  ArrayList<Integer> a1 = new ArrayList<Integer>(), a2 = new ArrayList<Integer>(), a3 = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    if((x=input.nextInt()) < 0 && a1.size()==0) a1.add(x);
    else if(x <= 0) a3.add(x);
    else a2.add(x);
  }
  if(a2.size() == 0)
  {
    Collections.sort(a3);
    a2.add(a3.remove(0));
    a2.add(a3.remove(0));
  }
  out.print(a1.size());
  for(int a: a1) out.print(" "+a);
  out.println();
  out.print(a2.size());
  for(int a: a2) out.print(" "+a);
  out.println();
  out.print(a3.size());
  for(int a: a3) out.print(" "+a);
  out.println();
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
}
}