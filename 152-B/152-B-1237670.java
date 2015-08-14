import java.util.*;
public class b {
    public static long total;
public static void main(String[] args)
{
    total = 0;
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    int x = input.nextInt();
    int y = input.nextInt();
    int k = input.nextInt();
    int[] vx = new int[k];
    int[] vy = new int[k];
    for(int i = 0; i<k; i++)
    {
        vx[i] = input.nextInt();
        vy[i] = input.nextInt();
    }
    for(int i =0; i<k; i++)
    {
        int stepx;
        if(vx[i] > 0)
            stepx = (n-x)/vx[i];
        else if(vx[i] == 0)
            stepx = 1234567890;
        else
            stepx = -1*(x-1)/vx[i];
        int stepy;
        if(vy[i] > 0)
            stepy = (m-y)/vy[i];
        else if(vy[i] == 0)
            stepy = 1234567890;
        else
            stepy = -1*(y-1)/vy[i];
        int steps = Math.min(stepx, stepy);
        //System.out.print(total + " ( ");
        total += steps;
        //System.out.println(total);
        x += steps*vx[i];
        y += steps*vy[i];
    }
    System.out.println(total);
}
}