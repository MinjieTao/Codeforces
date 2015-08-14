import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), x = input.nextInt();
    int sum = 0;
    for(int i = 0; i<n; i++) sum += input.nextInt();
    System.out.println((int)Math.ceil(1.*Math.abs(sum)/x));
}
}