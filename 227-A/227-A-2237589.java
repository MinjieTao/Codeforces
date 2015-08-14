import java.util.Scanner;

import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt(), x3 = input.nextInt(), y3 = input.nextInt();
    long cross = (x2-x1)*(y3 - y1) - (x3-x1)*(y2-y1);
    if(cross == 0)
        System.out.println("TOWARDS");
    else if (cross < 0)
        System.out.println("RIGHT");
    else System.out.println("LEFT");
}
}