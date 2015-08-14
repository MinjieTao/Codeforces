import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int hour = Integer.parseInt(s.substring(0, 2));
        int minute = Integer.parseInt(s.substring(3));
        while(true)
        {
            minute++;
            if(minute == 60)
            {
                hour++;
                minute = 0;
                if(hour == 24)
                    hour = 0;
            }
            if(hour == minute/10 + 10*(minute%10))
            {
                System.out.printf("%02d:%02d", hour, minute);
                break;
            }
            
        }
    }
}