import java.util.*;
public class a {
    public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt(), m = input.nextInt();
            int[] data = new int[n];
            for(int i = 0; i<n; i++) data[i] = input.nextInt();
            Arrays.sort(data);
            System.out.println(data[n-m]);
        }
}