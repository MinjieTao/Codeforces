import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    boolean found = false;
    for(int i = 0; i<= s.length(); i++)
    {
        for(int j = 0; j<26 && !found; j++)
        {
            String t = s.substring(0, i)+(char)('a'+j)+s.substring(i);
            if(palindrome(t))
            {
                System.out.println(t);
                found = true;
            }
        }
    }
    if(!found) System.out.println("NA");
}
static boolean palindrome(String s)
{
    for(int i = 0; i<s.length(); i++) if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
    return true;
}
}