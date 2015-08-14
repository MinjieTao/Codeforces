import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    String a, b, c, d;
    boolean abab = true, abba = true, aabb = true, aaaa = true;
    for(int i = 0; i < n; i++)
    {
        a = input.next();
        b = input.next();
        c = input.next();
        d = input.next();
        int vowelsFound = 0;
        for(int j = a.length() - 1; j >=0; j--)
        {
            char ch = a.charAt(j);
            int v = ch - 'a';
            if(v == 0 || v == 4 || v == 8 || v == 14 || v == 20)
                vowelsFound++;
            if(vowelsFound == k)
            {
                a = a.substring(j);
                break;
            }
        }
        if(vowelsFound < k)
        {
            aaaa = false;
            aabb = false;
            abab = false;
            abba = false;
        }
        vowelsFound = 0;
        for(int j = b.length() - 1; j >=0; j--)
        {
            char ch = b.charAt(j);
            int v = ch - 'a';
            if(v == 0 || v == 4 || v == 8 || v == 14 || v == 20)
                vowelsFound++;
            if(vowelsFound == k)
            {
                b = b.substring(j);
                break;
            }
        }
        if(vowelsFound < k)
        {
            aaaa = false;
            aabb = false;
            abab = false;
            abba = false;
        }
        vowelsFound = 0;
        for(int j = c.length() - 1; j >=0; j--)
        {
            char ch = c.charAt(j);
            int v = ch - 'a';
            if(v == 0 || v == 4 || v == 8 || v == 14 || v == 20)
                vowelsFound++;
            if(vowelsFound == k)
            {
                c = c.substring(j);
                break;
            }
        }
        if(vowelsFound < k)
        {
            aaaa = false;
            aabb = false;
            abab = false;
            abba = false;
        }
        vowelsFound= 0;
        for(int j = d.length() - 1; j >=0; j--)
        {
            char ch = d.charAt(j);
            int v = ch - 'a';
            if(v == 0 || v == 4 || v == 8 || v == 14 || v == 20)
                vowelsFound++;
            if(vowelsFound == k)
            {
                d = d.substring(j);
                break;
            }
        }
        if(vowelsFound < k)
        {
            aaaa = false;
            aabb = false;
            abab = false;
            abba = false;
        }
        //System.out.println(d);
        if(!a.equals(b) || !c.equals(d))
            aabb = false;
        if(!a.equals(c) || !b.equals(d))
            abab = false;
        if(!a.equals(d) || !b.equals(c))
            abba = false;
    }
    if(!aabb || !abab || !abba)
        aaaa = false;
    if(aaaa)
        System.out.println("aaaa");
    else if(abba)
        System.out.println("abba");
    else if(abab)
        System.out.println("abab");
    else if(aabb)
        System.out.println("aabb");
    else
        System.out.println("NO");
}
}