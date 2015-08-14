import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int[] xs = new int[n1];
        for(int i = 0; i<n1; i++) xs[i] = input.nextInt();
        n1 = input.nextInt();
        int[] ys = new int[n1];
        for(int i = 0; i<n1; i++) ys[i] = input.nextInt();
        n1 = input.nextInt();
        int[] zs = new int[n1];
        for(int i = 0; i<n1; i++) zs[i] = input.nextInt();
        Arrays.sort(xs);
        Arrays.sort(ys);
        Arrays.sort(zs);
        int a = input.nextInt(), b= input.nextInt();
        System.out.println(xs[xs.length-1]*Math.sqrt(ys[ys.length-1]*1.0*b/(a*zs[0]+b*ys[ys.length-1])));
        
    }
}