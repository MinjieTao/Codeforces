import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), t = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n-1; i++) data[i] = input.nextInt();
        int at = 1;
        while(at < n)
        {
            
            at += data[at-1];
            if(at == t)
            {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}