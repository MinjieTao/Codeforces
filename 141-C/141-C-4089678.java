import java.util.*;
import java.io.*;
public class a {
  static long mod  = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  Person[] data = new Person[n];
  for(int i = 0; i<n; i++) data[i] = new Person(input.next(), input.nextInt());
  Arrays.sort(data);
  boolean possible = true;
  for(int i = 0; i<n; i++) possible &= data[i].h <= i;
  if(!possible) out.println(-1);
  else
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(0);
    list.add(1);
    for(int i = 1; i<n; i++)
    {
      //out.println(i+" "+data[i].h);
      if(data[i].h == 0) list.add(i+1);
      else
      {
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.addAll(list);
        Collections.sort(list2);
        int shorterThan = list2.get(list2.size()-data[i].h);
        //out.println(i+" "+shorterThan);
        boolean found = false;
        for(int j = 0; j<list.size(); j++)
        {
          //out.println(found+" "+list.get(j));
          if(!found && list.get(j) == shorterThan)
          {
            list.set(j, list.get(j)+1);
            found = true;
          }
          else if(list.get(j) >= shorterThan)
          {
            list.set(j, list.get(j)+1);
          }
        }
        list.add(shorterThan);
      }
    }
    for(int i = 0; i<n; i++)
      out.println(data[i].name+" "+list.get(i+1));
  }



  out.close();
}
static class Person implements Comparable<Person>
{
  String name;
  int h;
  public Person(String n, int hh)
  {
    name = n;
    h = hh;
  }
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Person o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.h - o.h;
  }
}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
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

  /**
   * @return
   */
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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