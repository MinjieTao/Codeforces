import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), res = 0;
    String s = input.next();
    for(int i = 0; i<n; i++) 
        if(s.charAt(i) == '1') res++;
        else break;
    if(res < n) res++;
    System.out.println(res);
}
}