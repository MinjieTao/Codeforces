import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int[] dates = new int[n], people = new int[n], lengths = new int[n];
  int[] dpm = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  for(int i = 0; i<n; i++)
  {
      int month = input.nextInt(), day = input.nextInt();
      dates[i] = day;
      for(int j = 0; j<month-1; j++) dates[i] += dpm[j];
      people[i] = input.nextInt();
      lengths[i] = input.nextInt();
  }
  PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
  for(int i = 0; i<n; i++)
  {
      pq.add((dates[i] - lengths[i]+200)*1000 + people[i]);
      pq.add((dates[i]+200)*1000-people[i]);
  }
  int cur = 0, max = 0;
  while(!pq.isEmpty())
  {
      int at = pq.poll()%1000;
      if(at>500)
      {
          cur += at-1000;
      }
      else
      {
          cur += at;
          max = Math.max(max, cur);
      }
  }
  out.println(max);
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