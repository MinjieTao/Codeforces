import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int count = 0;
    for(int i = 0; i<n; i++) if(data[i] + k <= 5) count++;
    System.out.println(count/3);
}
}