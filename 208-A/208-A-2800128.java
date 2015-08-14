import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        while(s.contains("WUB"))
        {
            int i = s.indexOf("WUB");
            if(i == 0)
                s = s.substring(3);
            else
            {
                System.out.print(s.substring(0, i) + " ");
                s = s.substring(i+3);
            }
        }
        System.out.println(s);
    }
}