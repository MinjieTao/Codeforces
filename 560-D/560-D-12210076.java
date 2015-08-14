import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next(), t = input.next();
    System.out.println(reduce(s).equals(reduce(t)) ? "YES" : "NO");
}
static String reduce(String s)
{
    if(s.length()%2 == 1) return s;
    String a = reduce(s.substring(0, s.length()/2)), b = reduce(s.substring(s.length()/2));
    return a.compareTo(b) < 0 ? a + b : b + a;
}
}