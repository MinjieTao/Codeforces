import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    System.out.println(Math.min(n, m)%2 == 0 ? "Malvika" : "Akshat");
}
}