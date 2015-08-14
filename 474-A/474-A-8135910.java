import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = "qwertyuiopasdfghjkl;zxcvbnm,./";
    char c = input.next().charAt(0);
    String t = input.next();
    for(int i = 0; i<t.length(); i++)
    {
        int idx = s.indexOf(t.charAt(i));
        if(c == 'R') idx--;
        else idx++;
        System.out.print(s.charAt(idx));
    }
}
}