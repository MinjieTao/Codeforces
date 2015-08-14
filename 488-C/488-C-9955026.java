import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int hy = input.nextInt(), ay = input.nextInt(), dy = input.nextInt();
    int hx = input.nextInt(), ax = input.nextInt(), dx = input.nextInt();
    int h = input.nextInt(), a = input.nextInt(), d = input.nextInt();
    int needA = Math.max(0, dx - ay + 1);
    //System.out.println(needA);
    if(dy > ax)
    {
        System.out.println(a * needA);
        return;
    }
    int min = a * needA + d * (ax - dy);
    for(int aa = needA; aa<=needA+100; aa++)
        for(int dd = 0; dd < ax - dy; dd++)
            for(int hh = 0; hh <= 10000; hh++)
            {
                int dty =ax - (dy + dd);
                int dtx = ay + aa - (dx);
                //if(aa == 0 && dd == 0) System.out.println(dty+" "+dtx);
                int ta = (hy + hh + dty - 1) / dty;
                int tb = (hx + dtx - 1) / dtx;
                if(ta > tb)
                {
                    min = Math.min(min, aa*a+dd*d+hh*h);
                    break;
                }
            }
    System.out.println(min);
        
}
}