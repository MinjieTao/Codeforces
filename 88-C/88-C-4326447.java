import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        int g = gcd(a, b);
        a/=g; b/=g;
        if(a<b-1) System.out.println("Dasha");
        else if(b<a-1) System.out.println("Masha");
        else System.out.println("Equal");
    }
    static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}