import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int sum = 0;
    for(int i = 0; i<5; i++) sum += input.nextInt();
    if(sum%5 == 0 && sum > 0) System.out.println(sum/5);
    else System.out.println(-1);
}
}