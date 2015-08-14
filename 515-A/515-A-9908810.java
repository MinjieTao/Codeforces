import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    System.out.println(Math.abs(a) + Math.abs(b) <= c && (Math.abs(a)+Math.abs(b))%2 == c%2 ? "Yes" :"No");
}
}