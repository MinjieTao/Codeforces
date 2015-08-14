import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  char[] s = input.next().toCharArray();
  String a = input.next(), b = input.next();
  boolean good1 = false, good2 = false, found1 = false;
  for(int i = 0; i<s.length; i++)
  {
    if(!found1) {
      if(i+a.length()+b.length() > s.length) break;
      boolean okay = true;
      for(int j = 0; j<a.length(); j++) {
        if(s[i+j] != a.charAt(j)) {
          okay = false;
          break;
        }
      }
      if(okay) {
        found1 = true;
        i += a.length()-1;
      }
    }
    else {
      if(i+b.length() > s.length) break;
      boolean okay = true;
      for(int j = 0; j<b.length(); j++) {
        if(s[i+j] != b.charAt(j)) {
          okay = false;
          break;
        }
      }
      if(okay) {
        good1 = true;
      }
    }
  }
  found1 = false;
  for(int i = s.length-1; i>=0; i--)
  {
    if(!found1) {
      if(i-a.length()-b.length() < -1) break;
      boolean okay = true;
      for(int j = 0; j<a.length(); j++) {
        if(s[i-j] != a.charAt(j)) {
          okay = false;
          break;
        }
      }
      if(okay) {
        found1 = true;
        i -= a.length()-1;
      }
    }
    else {
      if(i-b.length() < -1) break;
      boolean okay = true;
      for(int j = 0; j<b.length(); j++) {
        if(s[i-j] != b.charAt(j)) {
          okay = false;
          break;
        }
      }
      if(okay) {
        good2 = true;
      }
    }
  }
  if(good1 && good2) out.println("both");
  else if(good1) out.println("forward");
  else if(good2) out.println("backward");
  else out.println("fantasy");
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