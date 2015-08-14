import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        int sum1 = 0, sum2 = 0;
        boolean okay = true;
        for(int i= 0; i<n; i++)
        {
            char c = s.charAt(i);
            if(c != '4' && c != '7')
                okay = false;
            if(i<n/2) sum1 += c-'0';
            else sum2 += c-'0';
        }
        System.out.println(okay && sum1 == sum2 ? "YES" : "NO");
    }
}