import java.util.*;
public class Army {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] d = new int[n-1];
        for(int i = 0; i<n-1; i++)
            d[i] = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        
            int sum = 0;
        for(int i = a-1; i< b-1; i++)
            sum += d[i];
        System.out.println(sum);
        
    }

}