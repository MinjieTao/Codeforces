import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] div = new int[1000001];
        for(int i = 1; i<=1000001; i++)
            for(int j =i; j<=1000000; j+=i)
                div[j]++;
        long res = 0;
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
        for(int i = 1; i<=a; i++)
            for(int j = 1; j<=b; j++)
                for(int k = 1; k<=c; k++)
                    res = (res + div[i*j*k])%(1<<30);
        System.out.println(res);
    }
}