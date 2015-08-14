import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String p1 = input.next(), p2 = input.next();
        int x1 = p1.charAt(0) - 'a', y1 = p1.charAt(1) - '1';
        int x2 = p2.charAt(0) - 'a', y2 = p2.charAt(1) - '1';
        StringBuilder out = new StringBuilder();
        int count = 0;
        while(true)
        {
            count++;
            if(x1 < x2)
            {
                if(y1<y2)
                {
                    out.append("RU\n");
                    x1++;
                    y1++;
                }
                else if(y1>y2)
                {
                    out.append("RD\n");
                    x1++;
                    y1--;
                }
                else
                {
                    out.append("R\n");
                    x1++;
                }
            }
            else if(x1 > x2)
            {
                if(y1 < y2)
                {
                    out.append("LU\n");
                    x1--;
                    y1++;
                }
                else if(y1 > y2)
                {
                    out.append("LD\n");
                    x1--;
                    y1--;
                }
                else
                {
                    out.append("L\n");
                    x1--;
                }
            }
            else if(y1>y2)
            {
                out.append("D\n");
                y1--;
            }
            else if(y1<y2)
            {
                out.append("U\n");
                y1++;
            }
            else
            {
                count--;
                break;
            }
        }
        System.out.println(count + "\n" + out);
    }
}