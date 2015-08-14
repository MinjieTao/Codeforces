import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    boolean found = false;
    for(int i = 0; i<n; i++)
    {
        if(s.charAt(i) == '0')
        {
            found = true;
            System.out.println(s.substring(0, i) + s.substring(i+1));
            break;
        }
    }
    if(!found)
        System.out.println(s.substring(1));
}
}