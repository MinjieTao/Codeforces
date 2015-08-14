import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    for(int i = n+1; i<=10000; i++)
    {
        if(go(i))
        {
            System.out.println(i);
            break;
        }
    }
}
public static boolean go(int n)
{
    String s = n+"";
    for(int i = 0; i<s.length(); i++)
        for(int j = i+1; j<s.length(); j++)
            if(s.charAt(i)==s.charAt(j))
                return false;
    return true;
}
}