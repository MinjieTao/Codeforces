import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    String t = input.next();
    int left = s.indexOf('|');
    int right = s.length()-1-left;
    for(int i = 0; i<t.length(); i++)
    {
        char c = t.charAt(i);
        if(left < right)
        {
            s = c+s;
            left++;
        }
        else
        {
            s = s+c;
            right++;
        }
    }
    if(left == right) System.out.println(s);
    else System.out.println("Impossible");
}
}