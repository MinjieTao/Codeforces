import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    String s = input.next();
    int[] freq = new int[10];
    for(int i = 0; i<s.length(); i++) freq[s.charAt(i) - '0']++;
    int[] mods = new int[10];
    mods[1] = 1;
    mods[6] = 6;
    mods[8] = 8;
    mods[9] = 9;
    for(int i = 0; i<freq[0]; i++)
    {
        for(int j = 0; j<10; j++)
            if(j == 1 || j == 6 || j == 8 || j == 9)
                mods[j] = (mods[j] * 10)%7;
    }
    StringBuilder res = new StringBuilder("");
    for(int i = 0; i<10; i++)
    {
        if(i == 1 || i == 6 || i == 8 || i == 9)
        {
            for(int j = 0; j<freq[i]-1; j++) res.append(i);
            continue;
        }
        if(i==0) continue;
        for(int j = 0; j<freq[i]; j++) res.append(i);
    }
    int mod = 0;
    int pow = 1;
    String str = res.toString();
    int n = str.length();
    for(int i = n-1; i>=0; i--)
    {
        mod = (mod + pow * (str.charAt(i) - '0'))%7;
        pow = (pow*10)%7;
    }
    for(int i = 0; i<freq[0]+4; i++) mod = (mod*10)%7;
    int[] nums = new int[]{1, 6, 8, 9};
    //System.out.println(Arrays.toString(mods));
    for(int i = 0; i<4; i++)
        for(int j = 0; j<4; j++)
            for(int k = 0; k<4; k++)
                for(int l = 0; l<4; l++)
                {
                    if(i==j||i==k||i==l||j==k||j==l||k==l) continue;
                    //System.out.println(i+" "+j+" "+k+" "+l+" "+mod);
                    if((mods[nums[i]] + 3*mods[nums[j]] + 2*mods[nums[k]] + 6*mods[nums[l]] + mod)%7 == 0)
                    {
                        out.print(str);
                        out.print(nums[l]+""+nums[k]+""+nums[j]+""+nums[i]);
                        for(int x = 0; x<freq[0]; x++) out.print(0);
                        out.close();
                        return;
                    }
                }
    out.println(0);
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