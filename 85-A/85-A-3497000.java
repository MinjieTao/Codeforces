import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    if(n==1) out.println("a\na\nb\nb");
    else if(n==2) out.println("aa\nbb\ncc\ndd");
    else if(n==3) out.println("aab\nddb\necc\neff");
    else if(n%2 == 0)
    {
        char[][] res = new char[4][n];
        res[1][0] = res[2][0] = 'z';
        int at = 0, col = 0;
        while(col < n-2)
        {
            res[0][col] = res[0][col+1] = (char)('a'+at++);
            if(at==26) at = 0;
            res[3][col] = res[3][col+1] = (char)('a'+at++);
            if(at == 26) at = 0;
            res[1][col+1] = res[1][col+2] = (char)('a'+at++);
            if(at == 26) at = 0;
            res[2][col+1] = res[2][col+2] = (char)('a'+at++);
            if(at==26) at = 0;
            col += 2;
        }
        res[0][col] = res[0][col+1] = (char)('a'+at++);
        if(at == 26) at = 0;
        res[3][col] = res[3][col+1] = (char)('a'+at++);
        if(at == 26) at = 0;
        res[1][col+1] = res[2][col+1] = (char)('a'+at++);
        for(int i = 0; i<4; i++) out.println(new String(res[i]));
    }
    else
    {
        char[][] res = new char[4][n];
        res[2][0] = res[3][0] = 'z';
        int at = 0, col = 0;
        while(col < n-2)
        {
            res[0][col] = res[0][col+1] = (char)('a'+at++);
            if(at==26) at = 0;
            res[3][col+1] = res[3][col+2] = (char)('a'+at++);
            if(at == 26) at = 0;
            res[1][col] = res[1][col+1] = (char)('a'+at++);
            if(at == 26) at = 0;
            res[2][col+1] = res[2][col+2] = (char)('a'+at++);
            if(at==26) at = 0;
            col += 2;
        }
        res[0][col] = res[1][col] = (char)('a'+at++);
        for(int i = 0; i<4; i++) out.println(new String(res[i]));
    }
    out.close();
}
//Fast Scanner
//throw IOException
//input.init(System.in);
public static class input {
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
}
}