import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        if(s.substring(1).equals(s.substring(1).toUpperCase()))
        {
            if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')
                System.out.print((char)(s.charAt(0)+'a'-'A'));
            else
                System.out.print((char)(s.charAt(0)+'A'-'a'));
            System.out.println(s.substring(1).toLowerCase());
        }
        else
        {
            System.out.println(s);
        }
    }
}