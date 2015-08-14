import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    double res = 0;
    double w = 0, l = 0;
    for(int i =0 ; i<n; i++)
    {
        if(input.nextInt()==1) w++;
        else l++;
        res = Math.max(res, w/(l+w));
    }
    System.out.println(res);
}
}