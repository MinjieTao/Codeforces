import java.util.*;
public class A231 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int idx = s.indexOf('+');
    int a = idx;
    int b = s.indexOf('=') - idx - 1;
    int c = s.length() - s.indexOf('=') - 1;
    if(c == a+b+2)
    {
        c--;
        a++;
    }
    else if(c == a+b-2)
    {
        if(a>1) a--;
        else b--;
        c++;
    }
    if(a+b == c)
    {
        for(int i = 0; i<a; i++) System.out.print('|');
        System.out.print("+");
        for(int i = 0; i<b; i++) System.out.print("|");
        System.out.print("=");
        for(int i = 0; i<c; i++) System.out.print("|");
    }
    else
        System.out.println("Impossible");
}
}