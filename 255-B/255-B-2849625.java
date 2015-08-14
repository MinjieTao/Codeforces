import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int xs = 0, ys = 0;
        for(int i = 0; i<s.length(); i++)
            if(s.charAt(i) == 'x') xs++;
            else ys++;
        if(xs > ys) for(int i = 0; i<xs-ys; i++) System.out.print("x");
        else for(int i = 0; i<ys-xs; i++) System.out.print("y");
    }
}