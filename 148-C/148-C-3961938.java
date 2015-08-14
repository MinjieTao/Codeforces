import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n = input.nextInt(), a = input.nextInt(), b = input.nextInt();
  if(a == n-1 && a>0) out.println(-1);
  else
  {
      ArrayList<Integer> data = new ArrayList<Integer>();
      int sum = 1;
      data.add(1);
      if(b == 0 && a>0) data.add(sum++);
      for(int i = 0; i<b; i++)
      {
          data.add(sum+1);
          sum += (sum+1);
      }
      int last = data.get(data.size()-1);
      if(last > 50000) out.println(-1);
      else
      {
          for(int i = 0; i<a; i++) data.add(++last);
          int x = data.size();
          for(int i = 0; i<n-x; i++) data.add(1);
          for(int d: data) out.print(d+" ");
      }
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