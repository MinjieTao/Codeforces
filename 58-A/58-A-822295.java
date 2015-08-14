import java.util.*;
public class ChatRoom {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int h = s.indexOf('h');
        if(h == -1)
        {
            System.out.println("NO");
            return;
        }
        s = s.substring(h+1);
        h = s.indexOf('e');
        if(h == -1)
        {
            System.out.println("NO");
            return;
        }
        s = s.substring(h+1);
        h = s.indexOf('l');
        if(h == -1)
        {
            System.out.println("NO");
            return;
        }
        s = s.substring(h+1);
        h = s.indexOf('l');
        if(h == -1)
        {
            System.out.println("NO");
            return;
        }
        s = s.substring(h+1);
        h = s.indexOf('o');
        if(h == -1)
        {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }

}