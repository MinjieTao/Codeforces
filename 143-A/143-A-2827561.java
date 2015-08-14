import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int r1 = input.nextInt(), r2 = input.nextInt(), c1 = input.nextInt(), c2 = input.nextInt(), d1 = input.nextInt(), d2 = input.nextInt();
        boolean found = false;
        for(int first = 1; first < 10; first++)
        {
            int second = r1 - first;
            int third = c1 - first;
            int fourth = c2 - second;
            if(second > 0 && second < 10 && third > 0 && third < 10 && fourth > 0 && fourth < 10 && third + fourth == r2 && first + fourth == d1 && second + third == d2 && first != second && first != third && first != fourth && second != third && second != fourth && third != fourth)
            {
                found = true;
                System.out.println(first + " " + second + "\n" + third + " " + fourth);
            }
        }
        if(!found)
            System.out.println(-1);
    }
}