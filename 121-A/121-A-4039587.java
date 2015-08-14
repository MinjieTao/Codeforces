import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int a = input.nextInt(), b = input.nextInt();
  ArrayList<Long> lucky = new ArrayList<Long>();
  int last = 0;
  lucky.add(0l);
  for(int i = 0; i<10; i++)
  {
    int count = lucky.size();
    for(int j = last; j<count; j++)
    {
      lucky.add(lucky.get(j)*10+4);
      lucky.add(lucky.get(j)*10+7);
    }
    last = count;
  }
  long res = 0;
  boolean found = false;
  for(int i = 1; i<lucky.size(); i++)
  {
    //out.println(lucky.get(i));
    long diff = Math.min(b,lucky.get(i)) - Math.max(a, lucky.get(i-1));
    if(!found && diff >=0) {found = true; diff++;}
    if(diff<0) diff = 0;
    //if(diff>0) out.println(i+" "+lucky.get(i)+" "+diff);
    res += diff*lucky.get(i);
  }
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