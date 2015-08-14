import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int l = input.nextInt();
    int r = input.nextInt();
    ArrayList<Long> luck = luck();
    //for(int i = 0; i<luck.size(); i++)
        //System.out.println(i + " " + luck.get(i));
    int start = 0; 
    int end = 0;
    for(int i = 0; i<luck.size(); i++)
    {
        if(luck.get(i)>=l)
        {
            start = i;
            break;
        }
    }
    for(int i = 0; i<luck.size(); i++)
    {
        //System.out.println(i + " " + luck.get(i));
        //System.out.println(r);
        if(luck.get(i)>=r)
        {
            end = i;
            break;
        }
    }
    long sum = 0;
    //System.out.println(start + " " + end);
    if(start==end)
    {
        sum += luck.get(start) * (r -l+1);
    }
    else
    {
    sum += luck.get(start)*(luck.get(start)-l+1);
    //System.out.println(sum);
    sum += luck.get(end)*(r-luck.get(end-1));
    //System.out.println(sum);
    for(int i = start+1; i<end; i++)
        sum+= (luck.get(i))*(luck.get(i) - luck.get(i-1));
        //System.out.println(sum);
    }
    System.out.println(sum);
    
}
public static ArrayList<Long> luck()
{
    ArrayList<Long> out = new ArrayList<Long>();
    out.add((long) 4);
    out.add((long) 7);
    for(int i = 1; i<10; i++)
    {
        int size = out.size();
        for(int j = 0; j<size; j++)
        {
            if(out.get(j).toString().length()==i)
            {
                //System.out.println(4*(int)Math.pow(10, i)+out.get(j));
                out.add(4*(long)Math.pow(10, i)+out.get(j));
            }
        }
        for(int j = 0; j<size; j++)
        {
            if(out.get(j).toString().length()==i)
            {
                //System.out.println(7*(int)Math.pow(10, i)+out.get(j));
                out.add(7*(long)Math.pow(10, i)+out.get(j));
            }
        }
    }
    return out;
}
}