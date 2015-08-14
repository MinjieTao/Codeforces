import java.util.*;
import java.io.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int a = (int)(input.nextDouble()*10000 + .5), d = (int)(10000*input.nextDouble()+.5);
    int n =input.nextInt();
    while(d>=(long)4*a) d-= 4*a;
    int side = 0;
    int dist = 0;
    for(int i = 0; i<n; i++)
    {
        dist += d;
        while(dist >= a)
        {
            dist -= a;
            side = (side+1)%4;
        }
        if(side == 0)
        {
            out.println(dist/10000.+" "+0);
        }
        else if(side == 1)
        {
            out.println(a/10000.+" "+dist/10000.);
        }
        else if(side == 2)
        {
            out.println((a-dist)/10000.+" "+a/10000.);
        }
        else out.println(0+" "+(a-dist)/10000.);
    }
    out.close();
}
}