import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int d = input.nextInt(), n = input.nextInt(), res = 0;
        for(int i = 0; i<n; i++) res += i < n-1 ? (d-input.nextInt()) : 0*input.nextInt();
        System.out.println(res);
    }
}