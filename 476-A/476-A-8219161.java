import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), res = -1;
    for(int i = (n+1)/2; i<= n; i++) if(i%m == 0)
    {
        res = i;
        break;
    }
    System.out.println(res);
}
}