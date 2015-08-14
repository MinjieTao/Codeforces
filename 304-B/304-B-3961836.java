import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
  public static int n;
  public static int[][] twos, fives, memo, memo2;
  public static char[][] res, res2;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  String s1 = input.next(), s2 = input.next();
  int y1 = Integer.parseInt(s1.substring(0, 4));
  int m1 = Integer.parseInt(s1.substring(5, 7));
  int d1 = Integer.parseInt(s1.substring(8, 10));
  int y2 = Integer.parseInt(s2.substring(0, 4));
  int m2 = Integer.parseInt(s2.substring(5, 7));
  int d2 = Integer.parseInt(s2.substring(8, 10));
  if(y1>y2 || y1 == y2 && m1>m2 || y1 == y2 && m1 == m2 && d1 > d2)
  {
      int temp = y1;
      y1 = y2; y2 = temp;
      temp = m1;
      m1 = m2; m2 = temp;
      temp = d1;
      d1 = d2; d2 = temp;
  }
  int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int res = 0;
  while(y1<y2||m1<m2||d1<d2)
  {
      d1++;
      res++;
      if(!(m1 == 2 && d1 == 29 && y1 %4 == 0 && (y1 % 100 != 0 || y1%400 == 0)))
      if(d1 > days[m1-1])
      {
        m1++;
        if(m1 == 13)
        {
            y1++;
            m1 = 1;
        }
        d1 = 1;
      }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}