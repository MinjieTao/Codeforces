import java.util.*;
public class a {
    public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            char[] a = input.next().toCharArray();
            int count = 0;
            for(int i = 0; i<n; i++)
                if(a[i] == 'x') count++;
            System.out.println(Math.abs(n/2 - count));
            for(int i = 0; i<n; i++)
            {
                if(count < n/2 && a[i] == 'X')
                {
                    count++;
                    a[i] = 'x';
                }
                else if(count > n/2 && a[i] == 'x')
                {
                    count--;
                    a[i] = 'X';
                }
            }
            System.out.println(new String(a));
        }
}