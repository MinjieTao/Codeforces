import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int i = input.nextInt();
    boolean good = false;
    for(int j: factors(i))
        if(good(j))
            good = true;
    if(good)
        System.out.println("YES");
    else
        System.out.println("NO");
}
public static boolean good(int i)
{
    boolean out = true;
    while(i>0)
    {
        if(i%10 != 4 && i%10 != 7)
            out = false;
        i/=10;
    }
    return out;
}
public static ArrayList<Integer> factors(int n)
{
    ArrayList<Integer> out = new ArrayList<Integer>();
    for(int i = 1; i<= Math.sqrt(n) +1; i++)
        if(i <= n && n/i == 1.0*n/i)
        {
            out.add(i);
            out.add(n/i);
        }
    return out;
            
}
}