import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt(), n = input.nextInt();
        StringBuilder s = new StringBuilder(a+"");
        int mod = a%b;
        boolean found = mod == 0;
        for(int i = 0; i<n; i++)
        {
            int newmod = (mod*10)%b;
            int needed = b - newmod;
            if(needed == b) needed = 0;
            if(needed > 9)
                break;
            else
            {
                found = true;
                s.append(needed);
            }
            mod = 0;
        }
        System.out.println(found ? s : -1);
    }
}