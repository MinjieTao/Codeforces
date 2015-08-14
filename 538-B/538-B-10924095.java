import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int len = (n+"").length();
    int[] vals = new int[7];
    for(int i = 0; i<len; i++)
    {
        vals[6-i] += n%10;
        n/= 10;
    }
    int sum = 0;
    for(int x : vals) sum += x;
    ArrayList<Integer> res = new ArrayList<Integer>();
    while(sum > 0)
    {
        String s = "";
        for(int i = 0; i<7; i++)
        {
            if(vals[i] > 0)
            {
                s += "1";
                vals[i]--;
                sum--;
            }
            else s += "0";
        }
        while(s.length() > 0 && s.charAt(0) == '0') s = s.substring(1);
        res.add(Integer.parseInt(s));
    }
    System.out.println(res.size());
    for(int x : res) System.out.print(x+" ");
}
}