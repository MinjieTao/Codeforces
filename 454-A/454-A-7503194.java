import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            if(i+j < n/2) System.out.print('*');
            else if((n-1-i)+j < n/2) System.out.print('*');
            else if(i+(n-1-j) < n/2) System.out.print('*');
            else if((n-1-i) + (n-1-j) < n/2) System.out.print('*');
            else System.out.print('D');
        }
        System.out.println();
    }
}
}