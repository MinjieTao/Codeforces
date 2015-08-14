import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  Random r = new Random();
  for(int i = 0; i<100000; i++)
  {
    int a = r.nextInt(n), b = r.nextInt(n);
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  Arrays.sort(data);
  int x = 1;
  long res = 0;
  long times = 1;
  int at = 3*n/4, change = 3*n/4;
  while(change>0)
  {
    for(int i = at-change; i<at; i++) res += times*data[i];
    change /= 4;
    at += change;
    times++;
    //out.println(change+" "+res);
  }
//  while(x<=n)
//  {
//    for(int i = 0; i<x; i++) res += data[n-i-1];
//    x*=4;
//  }
  res += times*data[n-1];
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