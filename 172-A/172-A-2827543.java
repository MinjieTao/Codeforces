import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] data = new String[n];
        for(int i = 0; i<n; i++)
            data[i] = input.next();
        int best = data[0].length();
        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<best; j++)
            {
                if(data[i].charAt(j) != data[0].charAt(j))
                {
                    best = j;
                    break;
                }
            }
        }
        System.out.println(best);
    }
}