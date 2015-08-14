import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] as = new int[4], ds = new int[4];
    for(int  i= 0; i<2; i++)
    {
        as[i] = input.nextInt();
        ds[i] = input.nextInt();
    }
    for(int  i= 2; i<4; i++)
    {
        ds[i] = input.nextInt();
        as[i] = input.nextInt();
    }
    int ans = 0;
    if(as[0] > as[2] && as[0] > as[3] && ds[1] > ds[2] && ds[1] > ds[3]) ans = 1;
    if(as[1] > as[2] && as[1] > as[3] && ds[0] > ds[2] && ds[0] > ds[3]) ans = 1;
    
    boolean second = true;
    second &= (as[2] > as[0] && ds[3] > ds[1] || as[3] > as[0] && ds[2] > ds[1]);
    second &= (as[2] > as[1] && ds[3] > ds[0] || as[3] > as[1] && ds[2] > ds[0]);
    if(second) ans = 2;
    
    if(ans == 0) System.out.println("Draw");
    else if(ans == 1) System.out.println("Team 1");
    else System.out.println("Team 2");
}
}