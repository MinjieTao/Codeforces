import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  
  int n = input.nextInt(), p1 = input.nextInt(), p2 = input.nextInt(), p3 = input.nextInt(), t1 = input.nextInt(), t2 = input.nextInt();
  int[] ls = new int[n], rs = new int[n];
  for(int i = 0; i<n; i++) {
    ls[i] = input.nextInt();
    rs[i] = input.nextInt();
  }
  int i = 0, time = ls[0], res = 0;
  while(i<n) {
    res += p1*(rs[i]-ls[i]);
    if(i<n-1)
    {
      int dist = ls[i+1] - rs[i];
      res += p1*(Math.min(dist, t1));
      dist -= Math.min(dist, t1);
      res += p2*(Math.min(dist, t2));
      dist -= Math.min(dist, t2);
      res += dist*p3;
    }
    i++;
  }
  out.println(res);
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