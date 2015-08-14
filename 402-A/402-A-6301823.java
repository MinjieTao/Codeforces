import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int k = input.nextInt(), a = input.nextInt(), b = input.nextInt(), v = input.nextInt();
    int bonus = 0;
    for(int i = 1; i<= 1000; i++)
    {
        bonus = Math.min(b, bonus + k - 1);
        int tot = v * (bonus + i);
        if(tot >= a)
        {
            System.out.println(i);
            return;
        }
    }
}
}