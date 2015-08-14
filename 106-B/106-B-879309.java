import java.util.*;
public class ChoosingLaptop {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n= input.nextInt();
    int ms = 0, mr = 0, mh = 0, mc = 1100, index = 0;
    ArrayList<Laptop> list = new ArrayList<Laptop>();
        for(int i = 0; i<n; i++)
        {
            int s = input.nextInt();
            int r = input.nextInt();
            int h = input.nextInt();
            int c = input.nextInt();
            list.add(new Laptop(c, r, h, s));
        }
            for(int i = 0; i<n; i++)
            {
                Laptop l = list.get(i);
                int s = l.s;
                int h = l.h;
                int r = l.r;
                for(int j = 0; j<list.size(); j++)
                {
                    Laptop l2 = list.get(j);
                    if(l2.s < l.s && l2.h<l.h && l2.r < l.r)
                    {
                        list.get(j).c = 1100;
                    }
                }   
            }
            for(int i = 0; i<list.size(); i++)
            {
                int c = list.get(i).c;
                if(c<mc)
                {
                    mc = c;
                    index = i+1;
                }
            }
        System.out.println(index);
}
public static class Laptop
{

    int c, r, h, s;
    public Laptop(int c, int r, int h, int s)
    {
        this.c = c;
        this.r = r;
        this.h = h;
        this.s = s;
    }
}
}