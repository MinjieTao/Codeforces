import java.util.*;
public class SinkingShip {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String[] names = new String[n];
    String[] pos = new String[n];
    for(int i = 0; i<n; i++)
    {
        names[i] = input.next();
        pos[i] = input.next();
    }
    for(int i = 0; i<n; i++)
    {
        if(pos[i].equals("rat"))
            System.out.println(names[i]);
    }
    for(int i = 0; i<n; i++)
    {
        if(pos[i].equals("woman") || pos[i].equals("child"))
            System.out.println(names[i]);
    }
    for(int i = 0; i<n; i++)
    {
        if(pos[i].equals("man"))
            System.out.println(names[i]);
    }
    for(int i = 0; i<n; i++)
    {
        if(pos[i].equals("captain"))
            System.out.println(names[i]);
    }
}
}