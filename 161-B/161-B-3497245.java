import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    ArrayList<Cart> cs = new ArrayList<Cart>();
    ArrayList<Cart> ps = new ArrayList<Cart>();
    double tot = 0;
    int numc = 0;
    for(int i = 0; i<n; i++)
    {
        int price = input.nextInt(), type = input.nextInt();
        if(type == 1)
        {
            cs.add(new Cart(price, i+1));
            numc++;
        }
        else
        {
            ps.add(new Cart(price, i+1));
        }
        tot += price;
    }
    Collections.sort(cs);
    double res = tot;
    for(int i = 0; i<Math.min(k-1, numc); i++) res -= .5*cs.get(i).price;
    if(numc >= k)
    {
        double diff = .5*cs.get(numc-1).price;
        if(ps.size()>0)
        {
            Collections.sort(ps);
            diff = Math.min(diff, .5*ps.get(ps.size()-1).price);
        }
        res -= diff;
    }
    out.printf("%.1f\n",res);
    for(int i = 0;i<Math.min(k-1,numc); i++) out.println(1+" "+cs.get(i).index);
    for(Cart p: ps) cs.add(p);
    for(int i = Math.min(k-1,numc); i<k-1; i++) out.println(1+" "+cs.get(i).index);
    out.print(n-k+1);
    for(int i = k-1; i<n; i++) out.print(" "+cs.get(i).index);
    out.println();
    out.close();
}
static class Cart implements Comparable<Cart>
{
    int price, index;
    Cart(int p, int i)
    {
        price = p; index = i;
    }
    @Override
    public int compareTo(Cart that) {
        // TODO Auto-generated method stub
        return that.price - this.price;
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