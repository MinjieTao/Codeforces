import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
  public static int n;
  public static long[][] twos, fives, memo, memo2;
  public static char[][] res, res2;
/*
5
1 12
1 3
2 15
2 5
2 1
*/
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  
  int n = input.nextInt();
  ArrayList<Integer> first = new ArrayList<Integer>(), second = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    int t = input.nextInt();
    if(t == 1) first.add(input.nextInt());
    else second.add(input.nextInt());
  }
  Collections.sort(first);
  Collections.reverse(first);
  Collections.sort(second);
  Collections.reverse(second);
  int t = 0, w = 0;
  for(int i = 0; i<first.size(); i++) w+=first.get(i);
  for(int i = 0; i<second.size(); i++) w+=second.get(i);
  while(w>t)
  {
    if(second.isEmpty() || (!first.isEmpty() && t+1>=w-first.get(0)))
    {
      t++;
      w -= first.remove(0);
    }
    else if(first.size()<2 || (!second.isEmpty() && t+2>=w-second.get(0)))
    {
      t += 2;
      w -= second.remove(0);
    }
    else
    {
      int f = first.get(0)+first.get(1), s = second.get(0);
      if(f>s)
      {
        t++;
        w -= first.remove(0);
      }
      else
      {
        t+=2;
        w -= second.remove(0);
      }
    }
  }
  out.println(t);
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