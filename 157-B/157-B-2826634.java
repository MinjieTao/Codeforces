import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int[] data = new int[n], data2 = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        Arrays.sort(data);
        for(int i = 0; i<n; i++)  data2[i] = data[n-1-i]*data[n-1-i];
        int res = 0;
        for(int i = 0; i<n; i++) res += (i%2 == 0)? data2[i] : -data2[i];
        System.out.println(res*Math.PI);
    }
}