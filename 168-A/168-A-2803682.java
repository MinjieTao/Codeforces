import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), x = input.nextInt(), y = input.nextInt();
        int needed = (int)Math.ceil(n*y/100.);
        System.out.println(Math.max(0, needed - x));
    }
}