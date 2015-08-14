import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int n = input.nextInt();
  int[] data = new int[n+1];
  for(int i = 0; i<n;i++) data[i+1] = input.nextInt();
  if(n==1 || n%2 == 0) out.println(-1);
  else
  {
      int res = 0;
      for(int i = n; i>0; i--)
      {
          //out.println(data[i]);
          if(data[i] <= 0) continue;
          if(i%2 == 0)
          {
              res += data[i];
              data[i/2]-=data[i];
              data[i]-=data[i];
          }
          else
          {
              res += data[i];
              data[i-1]-=data[i];
              data[i/2]-=data[i];
              data[i]-=data[i];
          }
      }
      out.println(res);
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
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}