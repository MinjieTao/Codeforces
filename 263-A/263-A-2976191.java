import java.util.*;
public class b2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int x = 0, y = 0;
    int res = 0;
    for(int i = 0; i<25; i++)
    {
        int a = input.nextInt();
        if(a==1)
        {
            y = i/5;
            x = i%5;
            res = Math.abs(x-2) + Math.abs(y-2);
        }
    }
    System.out.println(res);

}
}