import java.util.*;
public class a
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    int x = Math.abs(a)+Math.abs(b);
    if(a<0)
    System.out.println((a>0 ? x : -x) + " 0 0 " + (b>0 ? x : -x));
    else
    System.out.println("0 "+(b>0 ? x : -x) + " " + (a>0 ? x : -x)+" 0");
  }
}