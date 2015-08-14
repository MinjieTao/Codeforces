import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  int n = input.nextInt();
  int[] data = new int[n];
  PriorityQueue<Element> pq = new PriorityQueue<Element>();
  TreeSet<Integer> elems = new TreeSet<Integer>();
  for(int i = 0; i<n; i++)
  {
    data[i] = input.nextInt();
    pq.add(new Element(i, data[i]));
    elems.add(i);
  }
  long res = 0;
  int last = 0, size = n;
  while(!pq.isEmpty())
  {
    Element at = pq.poll();
    if(size > 2) res += ((long)at.val-last)*(size-2);
    //System.out.println(at.val+" "+last+" "+size);
    last = at.val;
    Integer prev = elems.lower(at.i), next = elems.higher(at.i);
    //System.out.println(at.i+" "+prev+" "+next);
    if(prev != null && next != null)
    {
      res += Math.max(0, Math.min(data[prev]-at.val, data[next]-at.val));
    }
    elems.remove(at.i);
    size--;
  }
  System.out.println(res);
}
static class Element implements Comparable<Element>
{
  int i, val;
  public Element(int ii, int vv)
  {
    i = ii; val = vv;
  }
  @Override
  public int compareTo(Element o) {
    return val - o.val;
  }
}
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