import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt(), p = input.nextInt();
    int[] data = new int[n];
    ArrayList<Integer> odds = new ArrayList<Integer>(), evens = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        if(data[i]%2 == 1) odds.add(data[i]);
        else evens.add(data[i]);
    }
    int odd = odds.size();
    int maxEven = n - odd + odd/2;
    //System.out.println(minEven+" "+maxEven);
    if(odd - Math.max(0, 2*(p - (n-odd))) < k-p || p > maxEven || odd%2 != (k - p)%2) out.println("NO");
    else
    {
        out.println("YES");
        int oddp = 0;
        int evenp = 0;
        for(int i = 0; i<k; i++)
        {
            if(i < k-p && i != k-1)
            {
                out.println(1+" "+odds.get(oddp));
                oddp++;
            }
            else
            {
                if(i == k-1)
                {
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    while(oddp < odds.size()) res.add(odds.get(oddp++));
                    while(evenp < evens.size()) res.add(evens.get(evenp++));
                    out.print(res.size());
                    for(int x: res) out.print(" "+x);
                    out.println();
                }
                else if(evenp < evens.size())
                {
                    out.println(1+" "+evens.get(evenp++));
                }
                else
                {
                    out.println(2+" "+odds.get(oddp++)+" "+odds.get(oddp++));
                }
            }
        }
    }
    out.close();
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