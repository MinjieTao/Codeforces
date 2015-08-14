import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int xp = input.nextInt(), yp = input.nextInt(), xv = input.nextInt(), yv = input.nextInt();
    boolean w = false;
    if(xp <= xv && yp <= yv) w = true;
    if(xp + yp <= Math.max(xv,  yv)) w = true;
    System.out.println(w ? "Polycarp" : "Vasiliy");
    
}
}