import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int b = 0;
    while(true)
    {
        b++;
        n++;
        if((n+"").indexOf('8') != -1) break;
    }
    System.out.println(b);
}
}