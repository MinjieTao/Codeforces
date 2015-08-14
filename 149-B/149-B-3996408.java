import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  String s = input.next();
  String a = s.substring(0,s.indexOf(':'));
  String b = s.substring(s.indexOf(':')+1);
  int max = 0;
  for(int i = 0; i<s.length(); i++)
  {
      char c = s.charAt(i);
      if(c>='0' && c<='9') max = Math.max(max, c-'0');
      else if(c>='A' && c<='Z') max = Math.max(max,10+c-'A');
  }
  ArrayList<Integer> res = new ArrayList<Integer>();
  for(int i = max+1; i<=65; i++)
  {
      int h = 0, m=0, pow = 0;
      for(int j = a.length()-1; j>=0; j--)
      {
          char c = a.charAt(j);
          int val = (c>='0'&&c<='9') ? c-'0' : c+10-'A';
          for(int k = 0; k<pow; k++) val *= i;
          h += val;
          pow++;
      }
      pow = 0;
      for(int j = b.length()-1; j>=0; j--)
      {
          char c = b.charAt(j);
          int val = (c>='0'&&c<='9') ? c-'0' : c+10-'A';
          for(int k = 0; k<pow; k++) val *= i;
          m += val;
          pow++;
      }
      if(m<=59 && h<=23) res.add(i);
  }
  if(res.size()==0) out.println(0);
  else if(res.get(res.size()-1) == 65)
      out.println(-1);
  else
      for(int x: res) out.print(x+" ");
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