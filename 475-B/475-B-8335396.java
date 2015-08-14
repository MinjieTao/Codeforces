import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    String s = input.next(), t = input.next();
    boolean good = false;
    char a = s.charAt(0), b = s.charAt(n-1), c = t.charAt(0), d = t.charAt(m-1);
    if(a == '>' && b == '<' && c == '^' && d == 'v') good = true;
    if(a == '<' && b == '>' && c == 'v' && d == '^') good = true;
    System.out.println(good ? "YES" :"NO");
}
}