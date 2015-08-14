import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    if(n==0) System.out.println(go(0));
    while(n>0)
    {
        System.out.println(go(n%10));
        n /= 10;
    }
}
static String go(int n)
{
    String res = "";
    if(n>=5)
    {
        n -= 5;
        res += "-O|";
    }
    else res += "O-|";
    for(int i =0; i<n; i++) res += "O";
    res += "-";
    for(int i = 0; i<4-n; i++) res += "O";
    return res;
}
}