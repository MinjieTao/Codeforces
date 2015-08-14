import java.util.*;
public class a {
    public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), s = input.nextInt();
            int sum = 0;
            int[] data = new int[n];
            for(int i = 0; i<n; i++) sum += data[i] = input.nextInt();
            Arrays.sort(data);
            sum -= data[n-1];
            System.out.println(sum <= s ? "YES" : "NO");
        }
}