import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long res = 0;
    int n = input.nextInt();
    String s = input.next();
    for(int i = 0; i<n; i++) if(s.charAt(i) == 'B') res += (1l << i);
    System.out.println(res);
}
}