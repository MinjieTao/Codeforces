import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int min = -2000000000, max = 2000000000;
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        int x = input.nextInt();
        char c = input.next().charAt(0);
        if(s.equals("<") && c == 'Y' || s.equals(">=") && c == 'N')
            max = Math.min(max, x-1);
        if(s.equals(">") && c == 'Y' || s.equals("<=") && c == 'N')
            min = Math.max(min, x+1);
        if(s.equals(">=") && c == 'Y' || s.equals("<") && c == 'N')
            min = Math.max(min, x);
        if(s.equals("<=") && c == 'Y' || s.equals(">") && c == 'N')
            max = Math.min(max, x);
    }
    if(max >= min) System.out.println(min);
    else System.out.println("Impossible");
}
}