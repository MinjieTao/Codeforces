import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int n = s.length();
    int res = 1;
    for(int i = 1; i<n; i++) res += (1<<i);
    s = s.replaceAll("4","0");
    s = s.replaceAll("7","1");
    res += Integer.parseInt(s, 2);
    System.out.println(res);
}
}