import java.util.*;
public class B278 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    if(n == 0)
    {
        System.out.println("YES\n1\n2\n2\n3");
        return;
    }
    if(n == 1)
    {
        int a = data[0], b = a, c = 3*a, d = 3*a;
        System.out.println("YES\n"+b+"\n"+c+"\n"+d);
        return;
    }
    if(n == 4)
    {
        int a = data[0], b = data[1], c = data[2], d = data[3];
        if(a+d == c+b && d == 3*a)
        {
            System.out.println("YES");
        }
        else System.out.println("NO");
        return;
    }
    if(n == 3)
    {
        for(int i = 1; i<= 1500; i++)
        {
            int[] xs = new int[]{data[0], data[1], data[2], i};
            Arrays.sort(xs);
            int a = xs[0], b = xs[1], c = xs[2], d = xs[3];
            if(a+d == c+b && d == 3*a)
            {
                System.out.println("YES\n"+i);
                return;
            }
        }
        System.out.println("NO");
        return;
    }
    for(int i = 1; i<= 1500; i++)
    {
        for(int j = 1; j<=1500; j++)
        {
            int[] xs = new int[]{data[0], data[1], j, i};
            Arrays.sort(xs);
            int a = xs[0], b = xs[1], c = xs[2], d = xs[3];
            if(a+d == c+b && d == 3*a)
            {
                System.out.println("YES\n"+i+"\n"+j);
                return;
            }
        }
    }
    System.out.println("NO");
    
}
}