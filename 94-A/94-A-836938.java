import java.util.*;
public class Restoring {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    String[] digits = new String[10];
    for(int i = 0; i<10; i++)
        digits[i] = input.next();
    for(int i = 0; i<8; i++)
    {
        String str = s.substring(i*10, i*10 + 10);
        for(int d = 0; d<10; d++)
        {
            if(str.equals(digits[d]))
                System.out.print(d);
        }
    }
}
}