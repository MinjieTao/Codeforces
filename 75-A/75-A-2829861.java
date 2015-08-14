import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        int c = a+b;
        String s1 = a+"", s2 = b+"", s3 = c+"";
        s1 = s1.replaceAll("0", "");
        s2 = s2.replaceAll("0", "");
        s3 = s3.replaceAll("0", "");
        a = Integer.parseInt(s1);
        b = Integer.parseInt(s2);
        c = Integer.parseInt(s3);
        System.out.println(a+b == c ? "YES" : "NO");
    }
}