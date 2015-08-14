import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] fs = new int[10];
    for(int i = 0; i<6; i++) fs[input.nextInt()]++;
    int[] ff = new int[7];
    for(int i = 0; i<10; i++) ff[fs[i]]++;
    if(ff[4] == 1 && ff[1] == 2 || ff[5] == 1) System.out.println("Bear");
    else if(ff[4] == 1 && ff[2] == 1 || ff[6] == 1) System.out.println("Elephant");
    else System.out.println("Alien");
}
}