import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), m = input.nextInt();
  Queue<Student> stop = new LinkedList<Student>();
  for(int i = 0; i<n; i++) stop.add(new Student(input.nextInt(), input.nextInt(), i));
  PriorityQueue<Student> bus = new PriorityQueue<Student>();
  int[] dropOffs = new int[n];
  int time = 0, position = 0;
  while(!bus.isEmpty() || !stop.isEmpty())
  {
    if(bus.size()<m)
    {
      time += position;
      position = 0;
      while(bus.size()<m && !stop.isEmpty())
      {
        Student gettingOn = stop.poll();
        time = Math.max(time, gettingOn.t);
        bus.add(gettingOn);
      }
      while(!bus.isEmpty())
      {
        Student gettingOff = bus.poll();
        time += gettingOff.x - position;
        position = gettingOff.x;
        dropOffs[gettingOff.i] = time;
        int count = 1;
        while(!bus.isEmpty() && bus.peek().x == position)
        {
          gettingOff = bus.poll();
          count++;
          dropOffs[gettingOff.i] = time;
        }
        time += 1+(count/2);
      }
    }
  }
  for(int d: dropOffs) out.print(d+" ");

  out.close();
}
static class Student implements Comparable<Student>
{
  int t, x, i;
  public Student(int tt, int xx, int ii)
  {
    t = tt;
    x = xx;
    i = ii;
  }
  @Override
  public int compareTo(Student o) {
    return this.x - o.x;
  }
}
static long pow(long a, long p)
{
  if(p==0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
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
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}