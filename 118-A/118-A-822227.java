import java.util.*;
public class StringTask {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    s = s.toLowerCase();
    String t = "";
    for(int i = 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='y')
            continue;
        else
            t = t + '.' + c;
    }
    System.out.println(t);
}
}