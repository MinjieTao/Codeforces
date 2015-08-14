import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b= input.nextInt(), c = input.nextInt();
        double time = 1.0*a*c/b;
        System.out.println((int)Math.ceil(time-c));
    }
}