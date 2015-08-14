import java.util.*;
import java.io.*;
public class B228 {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(System.in);
    
    int k = input.nextInt();
    //for(int k = 999999488; k >= 0; k--)
    {
        g = new boolean[10000][10000];
        at = 2;
        //System.out.println(k);
    log = 0;
    for(int i = 0; i<30;i++)
    {
        if(((1<<i) & k) > 0)
            log = i+1;
    }
    int last = 0;
    for(int i = 0; i<2*log; i++)
    {
        g[last][at] = g[at][last] = true;
        last = at;
        at++;
    }
    g[last][1] = g[1][last] = true;
    last = 0;
    for(int i = 0; i<2*log; i++)
    {
        g[last][at] = g[at][last] = true;
        g[last][at+1] = g[at+1][last] = true;
        g[at+1][at+2] = g[at+2][at+1] = true;
        g[at][at+2] = g[at+2][at] = true;
        at += 3;
        last = at - 1;
    }
    k--;
    for(int i = 1; i<30; i++)
    {
        if(((1<<i) & k) > 0)
        {
            int from = 2 + 2 * i;
            int to = 1 + 2 * log + 3 * i;
            g[from][to] = g[to][from] = true;
        }
    }
    if(k%2 == 1)
    {
        last = 0;
        for(int i = 0; i<2*log; i++)
        {
            g[last][at] = g[at][last] = true;
            last = at;
            at++;
        }
        g[last][1] = g[1][last] = true;
    }
    PrintWriter out = new PrintWriter(System.out);
    int n = at;
    out.println(at);
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
            out.print(g[i][j] ? 'Y' : 'N');
        out.println();
    }
    out.close();
    }
}
static int log;
static boolean[][] g;
static void add(int pow)
{
    int last = 2 + 2*(log - pow - 1);
    for(int i = 0; i<=pow; i++)
    {
        //System.out.println(last+" "+at);
        for(int j = 0; j<2; j++)
        {
            g[last][at+j] = g[at+j][last] = true;
            g[at+j][last+3] = g[last+3][at+j] = true;
        }
        g[last+2][last+1] = g[last+1][last+2] = true;
        at += 3;
        last = at-1;
    }
    g[last][1] = g[1][last] = true;
}
static int at;
}