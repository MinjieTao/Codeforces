import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n= input.nextInt(), w = input.nextInt(), h = input.nextInt();
  Card[] data = new Card[n];
  for(int i = 0; i<n; i++) data[i] = new Card(input.nextInt(), input.nextInt(), i+1);
  Arrays.sort(data);
  int[] memo = new int[n];
  int[] link = new int[n];
  Arrays.fill(link, -1);
  Arrays.fill(memo,-1);
  for(int i = 0; i<n; i++) if(data[i].h>h && data[i].w>w) memo[i] = 1;
  for(int i = 0; i<n; i++)
      for(int j = 0; j<i; j++)
          if(memo[j] != -1 && data[i].w>data[j].w && data[i].h>data[j].h)
          {
              if(1+memo[j] > memo[i]) link[i] = j;
              memo[i] = Math.max(memo[i], memo[j]+1);
          }
  int res = 0, index = -1;
  for(int i = 0; i<n; i++) if(memo[i]>res) res = memo[index=i];
  out.println(res);
  String s = "";
  while(index != -1)
  {
      s = (data[index].i+" "+s);
      index = link[index];
  }
  if(s.length()>0) out.println(s);
  out.close();
  
}
static class Card implements Comparable<Card>
{
    int w, h, i;
    public Card(int ww, int hh, int ii)
    {
        w = ww; h = hh; i = ii;
    }
    @Override
    public int compareTo(Card o) {
        // TODO Auto-generated method stub
        return this.w - o.w;
    }
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