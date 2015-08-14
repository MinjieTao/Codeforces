import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), i = input.nextInt()-1, j = input.nextInt()-1, a = input.nextInt(), b = input.nextInt();
    int[] rs = new int[]{0, n-1, n-1, 0};
    int[] cs = new int[]{m-1, 0, m-1, 0};
    int res = 987654321;
    for(int k = 0; k<4; k++)
    {
        int dr = Math.abs(rs[k] - i);
        int dc = Math.abs(cs[k] - j);
        if(dr%a != 0 || dc%b != 0) continue;
        dr /= a;
        dc /= b;
        if(Math.abs(dr-dc)%2 != 0) continue;
        int sum = dr+dc, diff = Math.abs(dr-dc);
        //System.out.println(dr+" "+dc);
        res = Math.min(res, sum/2+diff/2);
    }
    if((i+a >= n && i-a<0 && res != 0) || (res != 0 && j+b >= m && j-b < 0)) res = 987654321;
    System.out.println(res == 987654321 ? "Poor Inna and pony!" : res);
}

}