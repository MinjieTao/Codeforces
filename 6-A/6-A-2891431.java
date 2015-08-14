import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int[] d = new int[4];
    for(int i = 0; i<4; i++) d[i] = input.nextInt();
    Arrays.sort(d);
    if(d[0]+d[1]>d[2] || d[1]+d[2]>d[3]) System.out.println("TRIANGLE");
    else if(d[0]+d[1]==d[2] || d[1]+d[2]==d[3]) System.out.println("SEGMENT");
    else System.out.println("IMPOSSIBLE");
}
}