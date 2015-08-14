import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    long start = 3 - n%3;
    int count = 0;
    while(true)
    {
        long need = start * (start+1) / 2 * 3 - start;
        if(need <= n)
        {
            count++;
            start+=3;
        }
        else break;
    }
    System.out.println(count);
}
}