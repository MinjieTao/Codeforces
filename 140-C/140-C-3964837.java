import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  sort(data);
  int i=1, f=1;
  PriorityQueue<Snow> pq = new PriorityQueue<Snow>();
  while(i<n)
  {
    if(data[i] == data[i-1]) f++;
    else
    {
      pq.add(new Snow(data[i-1], f));
      f = 1;
    }
    i++;
  }
  pq.add(new Snow(data[i-1], f));
  ArrayList<Integer> res = new ArrayList<Integer>();
  while(pq.size()>=3)
  {
    Snow first = pq.poll(), second = pq.poll(), third = pq.poll();
    first.f--; second.f--; third.f--;
    int[] toAdd = new int[]{first.s, second.s, third.s};
    Arrays.sort(toAdd);
    res.add(toAdd[2]); res.add(toAdd[1]); res.add(toAdd[0]);
    if(first.f > 0) pq.add(first);
    if(second.f > 0) pq.add(second);
    if(third.f > 0) pq.add(third);
  }
  int x = res.size()/3;
  out.println(x);
  for(i = 0; i<x; i++) {
    out.println(res.get(3*i) + " " + res.get(3*i+1) + " " + res.get(3*i+2));
  }
  out.close();
  
}
static class Snow implements Comparable<Snow> {
  int s, f;
  public Snow(int s, int f) {
    this.s = s;
    this.f = f;
  }
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Snow o) {
    // TODO(mkirsche): Auto-generated method stub
    return o.f - this.f;
  }
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