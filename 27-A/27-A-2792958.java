import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[] has = new boolean[3002];
        for(int i = 0; i<n; i++)
            has[input.nextInt()] = true;
        for(int i = 1; i<=3001; i++)
        {
            if(!has[i])
            {
                System.out.println(i);
                break;
            }
        }
    }
}