import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(), y = input.nextInt(), a = input.nextInt(), b = input.nextInt();
        int count = 0;
        String out = "";
        for(int i = Math.max(a, b+1); i<=x; i++)
            for(int j = b; j<=y && j<i; j++)
            {
                count++;
                out +=(i + " " + j + "\n");
            }
        System.out.println(count);
        System.out.print(out);
    }
}