import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    double r = input.nextDouble(), h = input.nextDouble(), topHeight = 0;
    int count = 0;
    while(topHeight + r <= h+r/2)
    {
        topHeight += r;
        count += 2;
    }
    System.out.println((topHeight + r*(Math.sqrt(3))/2 <= h+r) ? count+1 : count);
}
}