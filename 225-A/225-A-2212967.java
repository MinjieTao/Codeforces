import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int top = input.nextInt();
    int[][] data = new int[n][2];
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        data[i][0] = input.nextInt();
        if(data[i][0] == top || data[i][0] == 7-top)
            good = false;
        data[i][1] = input.nextInt();
        if(data[i][1] == top || data[i][1] == 7-top)
            good = false;
    }
    System.out.println(good ? "YES" : "NO");
}
}