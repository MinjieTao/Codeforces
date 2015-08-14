import java.util.*;
public class CardGame {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    char trump = input.next().charAt(0);
    String s1 = input.next();
    String s2 = input.next();
    boolean winning = false;
    if(s1.charAt(1)==trump && s2.charAt(1)!=trump)
        winning = true;
    if(s1.charAt(1)==s2.charAt(1) && intValue(s1.charAt(0)) > intValue(s2.charAt(0)))
            winning = true;
    if(!winning)
        System.out.println("NO");
    else
        System.out.println("YES");
    
}
public static int intValue(char c)
{
    if(c=='T')
        return 10;
    if(c=='J')
        return 11;
    if(c=='Q')
        return 12;
    if(c=='K')
        return 13;
    if(c=='A')
        return 14;
    else
        return(c - '0');
}
}