import java.util.*;
public class irrational {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int m1 = input.nextInt();
    int m2 = input.nextInt();
    int m3 = input.nextInt();
    int m4 = input.nextInt();
    int[] mods = {m1, m2, m3, m4};
    int min = 2000000000;
    for(int i: mods)
        if(i < min)
            min = i;
    int a = input.nextInt();
    int b = input.nextInt();
    int difference = min - a;
    if(difference < 0)
        difference = 0;
    if(b - a + 1 < difference)
        difference = b-a + 1;
    System.out.println(difference);
}
}