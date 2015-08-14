import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            System.out.print((i==j ? k : 0) + " ");
        }
        System.out.println();
    }
}
}