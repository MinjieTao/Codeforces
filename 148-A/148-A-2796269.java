import java.util.*;
public class a
{
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), d = input.nextInt(), n = input.nextInt();
    int count = 0;
    for(int i = 1; i<=n; i++)
    {
    if(i%a == 0 || i%b == 0 || i%c == 0 || i%d == 0)
    count++;
    }
    System.out.println(count);
    }
}