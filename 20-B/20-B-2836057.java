import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
        if(a == 0 && b == c && c == 0)
            System.out.println(-1);
        else if(a == 0 && b == 0) System.out.println(0);
        else if(a == 0) System.out.println("1\n"+-1.0*c/b);
        else
        {
            long disc = (long)b*b - (long)4*a*c;
            if(disc < 0)
            {
                System.out.println(0);
            }
            else
            {
                double root1 = (-b - Math.sqrt(disc))/(2.0*a);
                double root2 = (-b + Math.sqrt(disc))/(2.0*a);
                if(disc == 0)
                    System.out.println("1\n" + root1);
                else
                    System.out.println("2\n" + Math.min(root1,root2) + "\n" + Math.max(root1, root2));
            }
        }
    }
}