import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    if(a == b) System.out.println("infinity");
    else if(a < b) System.out.println(0);
    else
    {
        int res = 0;
        int diff = a - b;
        for(int i = 1; i<= Math.sqrt(diff); i++)
        {
            if(diff%i != 0) continue;
            if(b < i) res++;
            if(i*i != diff && diff/i > b) res++;
        }
        System.out.println(res);
    }
}
}