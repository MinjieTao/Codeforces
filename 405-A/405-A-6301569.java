import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    for(int i = 0; i<n; i++) System.out.print(data[i]+" ");
}
}