import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n =input.nextInt();
  Table[] data = new Table[n];
  for(int i = 0; i<n; i++) data[i] = new Table(input.nextInt(), 0);
  for(int i = 0; i<n; i++) data[i].d = input.nextInt();
  Arrays.sort(data);
  int[] freq = new int[201]; // 200 is the max cost
  long totalCost = 0;
  for(Table t : data) totalCost += t.d;
  long min = Long.MAX_VALUE;
  for(int i = 0; i<n; i++)
  {
    int j = i;
    while(j < n && data[j].l == data[i].l) j++;
    // j is the first index with a different length
    int count = j - i;
    long sum = 0;
    for(int k = i; k<j; k++) sum += data[k].d;
    sum += minSum(freq, count - 1);
    min = Math.min(min, totalCost - sum);
    for(int k = i; k<j; k++) freq[data[k].d]++;
    i = j - 1;
  }
  out.println(min);
  
  out.close();
}
/*
 * Returns the sum of at most k biggest numbers.
 * freq is a frequency table (f[1] is how many 1's there are, etc.)
 */
static long minSum(int[] freq, int k)
{
  long sum = 0;
  int numbersNeeded = k;
  for(int i = freq.length - 1; i>=0; i--)
  {
    long toAdd = freq[i]; // how many occurrences of i we can use
    if(toAdd > numbersNeeded) toAdd = numbersNeeded;
    sum += i * toAdd;
    numbersNeeded -= toAdd;
  }
  return sum;
}
static class Table implements Comparable<Table>
{
  int l, d;
  public Table(int ll, int dd)
  {
    l = ll; d = dd;
  }
  @Override
  public int compareTo(Table o) {
    return l - o.l; // sort by increasing length
  }
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