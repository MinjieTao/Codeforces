import java.util.*;
public class aa {
public static void main(String[] args)
{
    String[] ones = new String[]{"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"}, tens = new String[]{"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    int n = (new Scanner(System.in)).nextInt();
    System.out.println(n == 0 ? "zero" : (n < 20 ? ones[n] : tens[n/10]+(n%10 == 0 ? "" : ("-"+ones[n%10]))));
}
}