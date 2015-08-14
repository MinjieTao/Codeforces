import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  String s = input.nextLine();
  boolean[] contains = new boolean[1001];
  while(s.length()>0)
  {
    int comma = s.indexOf(',');
    if(comma == -1)
    {
      int x = Integer.parseInt(s);
      contains[x] = true;
      s = "";
    }
    else
    {
      String current = s.substring(0, comma);
      int x = Integer.parseInt(current);
      contains[x] = true;
      s = s.substring(comma+1);
    }
  }
  ArrayList<Integer> start = new ArrayList<Integer>(), end = new ArrayList<Integer>();
  for(int i = 0; i<1001; i++)
  {
    if(!contains[i]) continue;
    int a = i, b = i;
    while(b<1000 && contains[b+1]) b++;
    start.add(a);
    end.add(b);
    i = b;
  }
  for(int i = 0; i<start.size(); i++)
  {
    if(i>0) out.print(",");
    if(start.get(i).intValue() == end.get(i).intValue()) out.print(start.get(i));
    else out.print(start.get(i)+"-"+end.get(i));
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

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}