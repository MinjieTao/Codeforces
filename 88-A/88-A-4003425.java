import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  String[] data = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
  String a = input.next(), b =  input.next(), c = input.next();
  int[] nums = new int[3];
  for(int i = 0; i<12; i++)
  {
    if(a.equals(data[i])) nums[0] = i;
    if(b.equals(data[i])) nums[1] = i;
    if(c.equals(data[i])) nums[2] = i;
  }
  Arrays.sort(nums);
  if(nums[1] - nums[0] == 3 && nums[2] - nums[1] == 4) out.println("minor");
  else if(nums[1] - nums[0] == 4 && nums[2] - nums[1] == 3) out.println("major");
  else if(nums[1] - nums[0] == 5 && nums[2] - nums[1] == 3) out.println("minor");
  else if(nums[1] - nums[0] == 5 && nums[2] - nums[1] == 4) out.println("major");
  else if(nums[1] - nums[0] == 4 && nums[2] - nums[1] == 5) out.println("minor");
  else if(nums[1] - nums[0] == 3 && nums[2] - nums[1] == 5) out.println("major");
  else out.println("strange");


  out.close();

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