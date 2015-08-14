import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int res = 0, last = 0;
        for(int i = 1; i<s.length(); i++) if(s.charAt(i) != s.charAt(i-1)) 
        {
            res+= (int)Math.ceil(1.0*(i-last)/5);
            last = i;
        }
        res += (int)Math.ceil(1.0*(s.length()-last)/5);
        System.out.println(res);
    }
}