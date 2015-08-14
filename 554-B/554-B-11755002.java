import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] grid = new String[n];
    for(int i = 0; i<n; i++)
        grid[i] = input.next();
    int max = 0;
    for(int i = 0; i<n; i++)
    {
        int cur = 0;
        for(int j = 0; j<n; j++) if(grid[i].equals(grid[j])) cur++;
        max = Math.max(max, cur);
    }
    System.out.println(max);
}
}