import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int k = input.nextInt(), x = input.nextInt(), n = input.nextInt(), m = input.nextInt();
    k--;
    long[] acs = new long[52], cas = new long[52];
    acs[2] = 1;
    for(int i = 3; i<acs.length; i++)
    {
        acs[i] = (acs[i-1] + acs[i-2]);
        cas[i] = (cas[i-1] + cas[i-2]);
        if(i%2 == 1) cas[i]++;
        //System.out.println(acs[i]+" "+cas[i]);
    }
    long[] as = new long[52], cs = new long[52];
    as[0] = 1;
    cs[1] = 1;
    for(int i = 2; i<as.length; i++)
    {
        as[i] = (as[i-1] + as[i-2]);
        cs[i] = (cs[i-1] + cs[i-2]);
        //System.out.println(as[i]+" "+cs[i]);
    }
    long[] ccs = new long[52];
    ccs[4] = 1;
    for(int i = 5; i<ccs.length; i++)
    {
        ccs[i] = (ccs[i-1] + ccs[i-2]);
        if(i%2 == 0) ccs[i]++;
    }
    String s1 = "Happy new year!", s2 = "";
    boolean found = false;
    for(int i = 0; i<=n/2; i++) //this many in first string
        for(int j = 0; j<=m/2; j++) //this many in second string
        {
            if(found) break;
            long tot = as[k]*i + cs[k]*j;
            //System.out.println(i+" "+j+" "+tot+" "+acs[k]+" "+cas[k]);
            if(tot == x)
            {
                found = true;
                s1 = "";s2 = "";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n) s1 += 'Z';
                while(s2.length()<m) s2 += 'Z';
            }
            else if(tot + acs[k] == x)
            {
                if(i*2 == n || j*2 == m) continue;
                found = true;
                s1 = "";
                s2 = "C";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n-1) s1 += 'Z';
                while(s2.length()<m) s2 += 'Z';
                s1 += 'A';
            }
            else if(tot + cas[k] == x)
            {
                if(i*2 == n || j*2 == m) continue;
                found = true;
                s1 = "C";
                s2 = "";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n) s1 += 'Z';
                while(s2.length()<m-1) s2 += 'Z';
                s2 += 'A';
            }
            else if(tot + acs[k] + cas[k] + ccs[k] == x)
            {
                if(i*2+2 > n || j*2+2 > m) continue;
                found = true;
                s1 = "C";
                s2 = "C";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n-1) s1 += 'Z';
                while(s2.length()<m-1) s2 += 'Z';
                s1 += 'A';
                s2 += 'A';
            }
            else if(tot+ccs[k] == x)
            {
                if(j*2+2 > m) continue;
                s1 = "";
                s2 = "C";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n) s1 += 'Z';
                while(s2.length()<m-1) s2 += 'Z';
                s2 += 'A';
            }
            else if(tot+ccs[k]+cas[k] == x)
            {
                if(j*2+2 > m || i*2 == n) continue;
                s1 = "A";
                s2 = "C";
                for(int ii = 0; ii<i; ii++) s1 += "AC";
                for(int ii = 0; ii<j; ii++) s2 += "AC";
                while(s1.length()<n) s1 += 'Z';
                while(s2.length()<m-1) s2 += 'Z';
                s2 += 'A';
            }
        }
    if(s2.length()>0) out.println(s1+"\n"+s2);
    else out.println(s1);
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