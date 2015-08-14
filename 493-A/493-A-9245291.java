import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String hh = input.next(), aa = input.next();
    int n = input.nextInt();
    HashSet<String> ys = new HashSet<String>();
    HashSet<String> rs = new HashSet<String>();
    for(int i = 0; i<n; i++)
    {
        int t = input.nextInt();
        char c = input.next().charAt(0);
        String name = "";
        if(c == 'a') name += aa;
        else name += hh;
        name += " "+input.nextInt();
        char type = input.next().charAt(0);
        if(rs.contains(name)) continue;
        if(type == 'r')
        {
            rs.add(name);
            System.out.println(name+" "+t);
        }
        else if(type == 'y')
        {
            if(ys.contains(name))
            {
                rs.add(name);
                System.out.println(name+" "+t);
            }
            else ys.add(name);
        }
    }
}
}