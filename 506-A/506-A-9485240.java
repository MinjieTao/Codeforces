import java.util.*;
public class a {
    static int[] data;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    d = input.nextInt();
    data = new int[30001];
    for(int i = 0; i<n; i++) data[input.nextInt()]++;
    memo = new int[30001][500];
    for(int[] A : memo) Arrays.fill(A, -1);
    System.out.println(go(d, d));
}
static int[][] memo;
static int d;
static int go(int at, int last)
{
    if(at > 30000) return 0;
    //System.out.println(at+" "+last);
    if(memo[at][last - d + 250] != -1) return memo[at][last - d + 250];
    int res = go(at+last, last);
    if(last > 1) res = Math.max(res, go(at+last-1, last-1));
    res = Math.max(res, go(at+last+1, last+1));
    res += data[at];
    memo[at][last - d + 250] = res;
    return res;
}
}