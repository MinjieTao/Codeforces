import java.util.*;
public class b21 {
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  int a1 = input.nextInt(), b1 = input.nextInt(), c1 = input.nextInt();
  int a2 = input.nextInt(), b2 = input.nextInt(), c2 = input.nextInt();
  if(a1 == 0 && b1 == 0 && c1 != 0 || a2 == 0 && b2 == 0 && c2 != 0) System.out.println(0);
  else if(a1*b2 - a2*b1 != 0) System.out.println(1);
  else if(a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) System.out.println(-1);
  else System.out.println(0);
}
}