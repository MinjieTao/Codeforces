import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int at = 0;
    for(int i = 0; i<n; i++) at += -input.nextInt()+input.nextInt()+1;
    System.out.println(m - at%m == m?0:m-at%m);
}
}