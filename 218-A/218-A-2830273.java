import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(),k = input.nextInt();
    int[] ys = new int[2*n+1];
    for(int i = 0 ;i<2*n+1; i++) ys[i] = input.nextInt();
    int needed = k;
    for(int i = 1; i<2*n+1 && needed > 0; i+=2)
    {
        if(ys[i] - 1 > ys[i-1] && ys[i] - 1 > ys[i+1])
        {
            ys[i]--;
            needed--;
        }
    }
    for(int i: ys) System.out.print(i+" ");
}
}