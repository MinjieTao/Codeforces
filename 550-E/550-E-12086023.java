import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  int cz = 0;
  for(int i = 0; i<n; i++) if(data[i] == 0) cz++;
  if(n == 1 && data[n-1] == 0) out.println("YES\n0");
  else if(n == 2 && data[0] == 1 && data[1] == 0) out.println("YES\n1->0");
  else if((cz == 2 && n > 1 && data[n-2] == 0) || data[n-1] == 1) out.println("NO");
  else
  {
    out.println("YES");
    if(n == 1)
    {
      out.println("0");
    }
    else if(data[n-2] == 1)
    {
      for(int i = 0; i<n-3; i++)
      {
        out.print(data[i]);
        out.print("->");
      }
      out.print(data[n-3]+"->"+data[n-2]+"->"+data[n-1]);
    }
    else
    {
      int secondLast = n-3;
      while(data[secondLast] == 1) secondLast--;
      if(secondLast != 0) out.print(data[0]);
      for(int i = 1; i<secondLast; i++) out.print("->"+data[i]);
      out.print(secondLast == 0 ? ("("+data[secondLast]) : ("->("+data[secondLast]));
      out.print("->(");
      for(int i = secondLast+1; i<n-1; i++) out.print(data[i] + (i == n - 2 ? "" : "->"));
      out.print(")");
      out.print(")->0");
    }
  }
  
  out.close();
}
public static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }
  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
}
}