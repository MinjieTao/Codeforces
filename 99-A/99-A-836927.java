import java.math.BigInteger;
import java.util.*;
public class HelpKingdom {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int index = s.indexOf('.');
    if(s.charAt(index -1)=='9')
        System.out.println("GOTO Vasilisa.");
    else
    {
        BigInteger b = new BigInteger("0"+s.substring(0, index));;
        if(s.charAt(index+1)<'5')
            System.out.println(b);
        else
            System.out.println(b.add(BigInteger.ONE));
    }
}
}