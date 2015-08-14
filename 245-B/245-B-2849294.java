import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String a;
        if(s.charAt(0) == 'f')
            a = "ftp";
        else
            a = "http";
        System.out.print(a + "://");
        System.out.print(s.charAt(a.length()));
        s = s.substring(a.length()+1);
        int i = s.indexOf("ru");
        String b = s.substring(0, i);
        s = s.substring(i+2);
        System.out.print(b + "." + "ru");
        if(s.length()>0) System.out.print("/"+s);
    }
}