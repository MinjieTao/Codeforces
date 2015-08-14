import java.util.*;
public class a
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    long m = input.nextLong();
    int r = input.nextInt();
    double res = 0;
    res += 2.*r;
    res += (m-1)*(2+Math.sqrt(2))*r;
    res += (m-2)*(m-1)*(Math.sqrt(2)-2)*r/m;
    res /= m;
    if(m>2)
      res += 2*(m-1)*(m-2)*(m)*r/(3.*m*m);
    System.out.println(res);
  }
}