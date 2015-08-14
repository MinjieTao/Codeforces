import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), k = input.nextInt(), last = -1;
  int[] data = new int[n];
  for(int i = 0; i<n; i++)  data[i] = input.nextInt();
  int[] freq = new int[k+1];
  for(int i = 0; i<n-1; i++)
    if(data[i] != data[i+1])
    {
      freq[data[i]]++;
      if(data[i+1] == last) freq[data[i]]++;
      last = data[i];
    }
  freq[data[n-1]]++;
  int max = 0, maxdex = 0;
  for(int i = 1; i<k+1; i++)
  {
    if(freq[i]>max)
    {
      max = freq[i];
      maxdex = i;
    }
  }
  out.println(maxdex);



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