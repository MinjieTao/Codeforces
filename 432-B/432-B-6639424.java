import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] homes = new int[n], aways = new int[n], fs = new int[100001];
    for(int i = 0; i<n; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        homes[i] = a; aways[i] = b;
        fs[a]++;
    }
    int tot = n-1;
    for(int i = 0; i<n; i++)
    {
        out.println(tot + fs[aways[i]] + " " + (tot - fs[aways[i]]));
    }
    out.close();
}
}