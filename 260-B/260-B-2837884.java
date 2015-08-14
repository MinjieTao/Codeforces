import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        ArrayList<Integer> dashes = new ArrayList<Integer>();
        for(int i = 0; i<s.length(); i++)
            if(s.charAt(i) == '-') dashes.add(i);
        ArrayList<String> dates = new ArrayList<String>();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 0; i<dashes.size()-1; i++)
        {
            int d1 = dashes.get(i), d2 = dashes.get(i+1);
            if(d1 >= 2 && s.charAt(d1 - 1) != '-' && s.charAt(d1 - 2) != '-' && d2 - d1 == 3 && d2 < s.length()-4 && s.charAt(d2 + 1) != '-' && s.charAt(d2 + 2) != '-' && s.charAt(d2 + 3) != '-' && s.charAt(d2 + 4) != '-')
            {
                int day = Integer.parseInt(s.substring(d1 - 2, d1));
                int month = Integer.parseInt(s.substring(d1 +1, d1 +3));
                int year = Integer.parseInt(s.substring(d2+1, d2+5));
                if(month <= 12 && month >= 1 && day >= 1 && day <= days[month-1] && year >= 2013 && year <= 2015)
                {
                    String str = s.substring(d1 - 2, d1)+"-"+s.substring(d1 +1, d1 +3)+"-"+s.substring(d2+1, d2+5);
                    //System.out.println(str);
                    dates.add(str);
                }
            }
        }
        Collections.sort(dates);
        int count = 1;
        int bestc = 0;
        String best = "";
        for(int i = 1; i<dates.size(); i++)
        {
            if(dates.get(i).equals(dates.get(i-1)))
                count++;
            else
            {
                if(count > bestc)
                {
                    bestc = count;
                    best = dates.get(i-1);
                }
                count = 1;
            }
        }
        if(count > bestc)
        {
            best = dates.get(dates.size()-1);
        }
        System.out.println(best);
    }
}