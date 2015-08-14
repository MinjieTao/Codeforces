import java.util.*;
import java.io.*;
public class c {
    public static int n;
    public static int[] data;
    public static int[][] memo;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    //insert code here
    n = input.nextInt();
    data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    memo = new int[n+1][2];
    for(int i = 0; i<memo.length; i++)
        Arrays.fill(memo[i], -1);
    int res;
    if(data[0] < 0)
        res = go(1, 0);
    else
        res = 1 + go(1, 0);
    out.println(res);
    out.close();
}
public static int go(int at, int sign)
{
    if(at == n)
    {
        if(sign == 1)
            return 0;
        else
            return 1234567;
    }
    if(memo[at][sign] != -1)
        return memo[at][sign];
    if(data[at] == 0)
        return memo[at][sign] = Math.min(1+ go(at+1, sign), 1+go(at+1, 1));
    else if(data[at] < 0)
    {
        if(sign == 0)
            return memo[at][sign] = Math.min(go(at+1, 0), 1+go(at+1, 1));
        else
            return memo[at][sign] = 1 + go(at+1, sign);
    }
    else
    {
        if(sign == 0)
        {
            return memo[at][sign] = Math.min(1+go(at+1, 0), go(at+1, 1));
        }
        else
            return memo[at][sign] = go(at+1, 1);
    }
}
}