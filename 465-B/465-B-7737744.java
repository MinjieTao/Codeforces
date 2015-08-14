import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int cur = 0, res = 0;
    for(int i = 0; i<n; i++)
    {
        if(input.nextInt() == 1) cur++;
        else if(cur > 0)
        {
            res += cur + 1;
            cur = 0;
        }
    }
    if(cur > 0) res += cur+1;
    if(res > 0) res--;
    System.out.println(res);
}
}