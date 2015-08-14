import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    boolean[] hb = new boolean[n], hg = new boolean[m];
    int res = 0;
    int a = input.nextInt();
    res += a;
    for(int i = 0; i<a; i++) hb[input.nextInt()] = true;
    a = input.nextInt();
    res += a;
    for(int i = 0; i<a; i++) hg[input.nextInt()] = true;
    for(int i = 0; i<100*n*m; i++)
    {
        int count = 0;
        if(hb[i%n]) count++;
        if(hg[i%m]) count++;
        hb[i%n] |= hg[i%m];
        hg[i%m] |= hb[i%n];
        if(count == 1) res++;
    }
    System.out.println(res == m+n ? "Yes" :"No");
}
}