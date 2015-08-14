import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int[] res = new int[n];
        int lo = 0, hi = n-1;
        for(int i = 0; i<k; i++)
        {
            if(i%2 == 0) res[i] = lo++;
            else res[i] = hi--;
        }
        for(int i = k; i<n; i++)
        {
            if(k%2 == 1) res[i] = lo++;
            else res[i] = hi--;
        }
        for(int x: res) System.out.print((x+1)+" ");
    }

}