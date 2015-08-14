import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
    String bb = input.next();
    long x = Long.parseLong(input.next(), a);
    if(bb.charAt(0) == 'R')
    {
        System.out.println(roman(x));
    }
    else
    {
        int b = Integer.parseInt(bb);
        String res = "";
        if(x == 0) System.out.println(0);
        while(x > 0)
        {
            long cur = x%b;
            if(cur < 10) res = (char)('0'+cur) + res;
            else res = (char)('A' + cur - 10) + res;
            x /= b;
        }
        System.out.println(res);
    }
}
static String roman(long x)
{
    String[] digits = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String res = "";
    for(int i = 0; i<digits.length; i++)
    {
        while(x >= vals[i])
        {
            x -= vals[i];
            res += digits[i];
        }
    }
    return res;
}
}