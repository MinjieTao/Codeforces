import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    Point[] data = new Point[n];
    for(int i = 0; i<n; i++) data[i] = new Point(input.nextInt(), input.nextInt());
    Arrays.sort(data);
    ArrayList<String> commands = new ArrayList<String>();
    for(int i = 0; i<n; i++)
    {
        Point at = data[i];
        if(at.x > 0) commands.add("1 " + at.x+" R");
        else if(at.x < 0) commands.add("1 " + -at.x+" L");
        if(at.y > 0) commands.add("1 " + at.y+" U");
        else if(at.y < 0) commands.add("1 " + -at.y+" D");
        commands.add("2");
        if(at.x > 0) commands.add("1 " + at.x+" L");
        else if(at.x < 0) commands.add("1 " + -at.x+" R");
        if(at.y > 0) commands.add("1 " + at.y+" D");
        else if(at.y < 0) commands.add("1 " + -at.y+" U");
        commands.add("3");
    }
    out.println(commands.size());
    for(String s: commands) out.println(s);
    
    
    out.close();
}
static class Point implements Comparable<Point>
{
    int x, y;
    public Point(int xx, int yy)
    {
        x = xx; y = yy;
    }
    @Override
    public int compareTo(Point p) {
        // TODO Auto-generated method stub
        if(Math.abs(x) == Math.abs(p.x)) return Math.abs(y) - Math.abs(p.y);
        return Math.abs(x) - Math.abs(p.x);
    }
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