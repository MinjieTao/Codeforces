import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        boolean found = false;
        for(int j = i+3; j<n; j++)
        {
            if(s.charAt(j) == 'r' && s.charAt(j-1) == 'a' && s.charAt(j-2) == 'e' && s.charAt(j-3) == 'b') found = true;
            if(found) res++;
        }
    }
    System.out.println(res);
}
}