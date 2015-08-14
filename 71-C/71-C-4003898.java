import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  boolean good = false;
  for(int i = 1; i<(n+1)/2; i++)
  {
    //System.out.println(n+" "+i);
    if(n%i != 0) continue;
    //while(n%i == 0 && i>1) n/=i;
    boolean check = false;
    for(int j = 0; j<i; j++)
    {
      boolean okay = true;
      for(int k = 0; k<n/i; k++)
      {
        if(0==data[(j+k*i)%n])
        {
          okay = false;
          break;
        }
      }
      if(okay)
      {
        good = true;
        check = true;
        break;
      }
    }
    if(check) break;
  }
  out.println(good?"YES":"NO");




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