import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), a = input.nextInt(), b = input.nextInt();
    long besta = (int)1e9, bestb = (int)1e9;
    for(int i = 0; i<1000000; i++)
    {
        long na = a + i;
        long needb = ((long)6*n + na - 1) / na;
        long nb = b + Math.max(0, needb - b);
        if((long)na * nb < besta * bestb)
        {
            besta = na;
            bestb = nb;
        }
        nb = b + i;
        long needa = ((long)6*n + nb - 1) / nb;
        na = a + Math.max(0, needa - a);
        if((long)na * nb < besta * bestb)
        {
            besta = na;
            bestb = nb;
        }
    }
    System.out.println(besta*bestb+"\n"+besta+" "+bestb);
}
}