import java.util.*;
public class Chips {
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int i =1;
        while(b > 0)
        {
            //System.out.println(i);
            if(i>a)
                i -=a;
            
            if(b >= i)
            {
                b -=i;
            //System.out.println(b);
            }
            else
            {
                //System.out.println(b);
                break;
            }
            i++;
        }
        System.out.println(b);
    }

}