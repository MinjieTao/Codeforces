import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] cs =  new int[4];
    for(int i = 0; i<4; i++) cs[i] = input.nextInt();
    int n = input.nextInt(), m = input.nextInt();
    int[] as = new int[n], bs = new int[m];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<m; i++) bs[i] = input.nextInt();
    int res = cs[3];
    int cost1 = 0, cost2 = 0;
    for(int i = 0; i<n; i++) cost1 += Math.min(cs[1], as[i] * cs[0]);
    for(int i = 0; i<m; i++) cost2 += Math.min(cs[1], bs[i] * cs[0]);
    cost1 = Math.min(cost1, cs[2]);
    cost2 = Math.min(cost2, cs[2]);
    res = Math.min(res, cost1+cost2);
    System.out.println(res);
}
}