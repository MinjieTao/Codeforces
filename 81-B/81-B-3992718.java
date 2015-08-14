import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  String s = input.nextLine().trim();
  while(s.contains("  "))
      s = s.replaceAll("  "," ");
  for(int i = 0; i<s.length(); i++)
  {
      char c = s.charAt(i);
      
      if(i!=s.length()-1 && c == ',')
      {
          out.print(c);
          out.print(' ');
      }
      else if(s.charAt(i) == '.' && i>0 && s.charAt(i-1) != ',' && !(i>1 && s.charAt(i-1) == ' ' && s.charAt(i-2) == ','))
      {
          out.print(" ...");
          i+=2;
      }
      else if(s.charAt(i) == '.')
      {
          out.print("...");
          i+=2;
      }
      else if(s.charAt(i) == ' ' && s.charAt(i+1) >= '0' && s.charAt(i+1) <='9' && s.charAt(i-1) >='0' && s.charAt(i-1) <='9')
          out.print(' ');
      else if(s.charAt(i) == ' ') out.print("");
      else
          out.print(c);
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