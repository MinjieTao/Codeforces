import java.util.*;
public class BallGame {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int count = 1;
    for(int i = 1; i< n; i++)
    {
        count+=i;
        int j = count%(n);
        if(j==0)
            j = n;
        if(i!= n-1)
        System.out.print(j + " ");
        else
            System.out.print(j);
    }
}
}