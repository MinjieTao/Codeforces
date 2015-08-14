import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] need = new int[3];
    int[] have = new int[3];
    long[] cost = new long[3];
    String s = input.next();
    for(int i = 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c == 'B') need[0]++;
        else if(c == 'S') need[1]++;
        else need[2]++;
    }
    for(int i = 0; i<3; i++) have[i] = input.nextInt();
    for(int i = 0; i<3; i++) cost[i] = input.nextLong();
    long money = input.nextLong();
    int i;
    for(i = 0; i<100; i++)
    {
        long c = 0;
        for(int j = 0; j<3; j++)
        {
            if(need[j] > have[j])
            {
                c += cost[j] * (need[j] - have[j]);
            }
            have[j] = Math.max(0, have[j] - need[j]);
        }
        if(c<=money)
        {
            money -= c;
        }
        else break;
    }
    if(i<100) System.out.println(i);
    else
    {
        long denom = 0;
        for(int j = 0; j<3; j++) denom += cost[j]*need[j];
        long res = (money/denom);
        System.out.println(res+100);
    }
}
}