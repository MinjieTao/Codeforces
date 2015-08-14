import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[] digits = new boolean[10];
        for(int i = 0; i<(n+"").length(); i++)
            digits[(n+"").charAt(i) - '0'] = true;
        int res = 0;
        for(int i = 1; i<=Math.sqrt(n); i++)
        {
            if(n%i != 0) continue;
            for(int j = 0; j<(i+"").length(); j++)
                if(digits[(i+"").charAt(j) - '0'])
                {
                    res++;
                    break;
                }
            if(i == n/i)
                continue;
            for(int j = 0; j<(n/i+"").length(); j++)
                if(digits[(n/i+"").charAt(j) - '0'])
                {
                    res++;
                    break;
                }
        }
        System.out.println(res);
    }
}