import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int count = 1, res = 0;
    for(int i = 1; i<s.length(); i++)
    {
        if(s.charAt(i) == s.charAt(i-1)) count++;
        else
        {
            if(count%2 == 0) res++;
            count = 1;
        }
    }
    if(count%2 == 0) res++;
    System.out.println(res);
}
}