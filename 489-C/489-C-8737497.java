import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int len = input.nextInt(), sum = input.nextInt();
    if(sum < 1 || sum > 9*len) System.out.println((len == 1 && sum == 0) ? "0 0" : "-1 -1");
    else
    {
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = min[0] = 1;
        sum--;
        int sum2 = sum;
        for(int i = 0; i<len; i++)
        {
            int need1 = Math.min(sum, 9 - max[i]);
            sum -= need1;
            max[i] += need1;
            int need2 = Math.min(sum2, 9 - min[len-1-i]);
            sum2 -= need2;
            min[len-1-i] += need2;
        }
        String m1 = "", m2 = "";
        for(int i = 0; i<len; i++)
        {
            m1 += min[i];
            m2 += max[i];
        }
        System.out.println(m1+" "+m2);
    }
}
}