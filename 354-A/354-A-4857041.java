import java.util.*;
public class a {
    static int n, l, r, ql, qr;
    static int[] data;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    l = input.nextInt();
    r = input.nextInt();
    ql = input.nextInt();
    qr = input.nextInt();
    data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] suml = new int[n];
    suml[0] = data[0];
    for(int i = 1; i<n; i++) suml[i] = suml[i-1] + data[i];
    int[] sumr= new int[n];
    sumr[n-1] = data[n-1];
    for(int i = n-2; i>=0; i--) sumr[i] = sumr[i+1] + data[i];
    int res = r*suml[n-1] + qr*(n-1);
    res = Math.min(res, l*suml[n-1] + ql*(n-1));
    for(int i = 0; i<n-1; i++)
    {
        int x = suml[i]*l + sumr[i+1]*r;
        if(i+1 > n-i-1) x += ql*(i+1-(n-i-1)-1);
        else if(n-i-1 > i+1) x += qr*((n-i-1) - (i+1)-1);
        res = Math.min(res, x);
    }
    System.out.println(res);
}
static int[][][] memo;
static int go(int a, int b, int last)
{
    if(a>b) return 0;
    if(memo[a][b][last] != -1) return memo[a][b][last];
    int res = 987654321;
    if(last == 1) res = Math.min(res, l*data[a]+ql + go(a+1, b, 1));
    else res = Math.min(res, l*data[a] + go(a+1, b, 1));
    if(last == 2) res = Math.min(res, r*data[b]+qr + go(a, b-1, 2));
    else res = Math.min(res, r*data[b] + go(a, b-1, 2));
    return memo[a][b][last] = res;
}
}