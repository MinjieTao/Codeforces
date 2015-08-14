import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  String[] types = new String[]{"S","M","L","XL","XXL"};
  int[] counts = new int[5];
  for(int i =0; i<5; i++) counts[i] = input.nextInt();
  int n = input.nextInt();
  for(int i = 0; i<n; i++)
  {
      String type = input.next();
      int needed = 0;
      for(int j = 0; j<5; j++) if(types[j].equals(type)) needed = j;
      if(counts[needed] > 0)
      {
          out.println(types[needed]);
          counts[needed]--;
      }
      else if(needed<4 && counts[needed+1] > 0)
      {
          out.println(types[needed+1]);
          counts[needed+1]--;
      }
      else if(needed>0 && counts[needed-1] > 0)
      {
          out.println(types[needed-1]);
          counts[needed-1]--;
      }
      else if(needed<3 && counts[needed+2] > 0)
      {
          out.println(types[needed+2]);
          counts[needed+2]--;
      }
      else if(needed>1 && counts[needed-2] > 0)
      {
          out.println(types[needed-2]);
          counts[needed-2]--;
      }
      else if(needed<2 && counts[needed+3] > 0)
      {
          out.println(types[needed+3]);
          counts[needed+3]--;
      }
      else if(needed>2 && counts[needed-3] > 0)
      {
          out.println(types[needed-3]);
          counts[needed-3]--;
      }
      else if(needed<1 && counts[needed+4] > 0)
      {
          out.println(types[needed+4]);
          counts[needed+4]--;
      }
      else if(needed>3 && counts[needed-4] > 0)
      {
          out.println(types[needed-4]);
          counts[needed-4]--;
      }
  }
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