import java.util.*;
public class a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = input.nextInt();
        String[] others = new String[n];
        for(int i = 0; i<n; i++) others[i] = input.next();
        int[] stop = new int[s.length()];
        for(int i = 0; i<s.length(); i++) stop[i] = s.length()-i;
        for(int i = 0; i<s.length(); i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(others[j].length() + i > s.length()) continue;
                boolean match = true;
                for(int k = 0; k<others[j].length(); k++)
                {
                    match &= others[j].charAt(k) == s.charAt(i+k);
                    if(!match) break;
                }
                if(match) stop[i] = Math.min(stop[i], others[j].length()-1);
            }
        }
        for(int i = s.length()-2; i>=0; i--) stop[i] = Math.min(stop[i], stop[i+1]+1);
        int maxlen = 0, maxdex = 0;
        for(int i = 0; i<s.length(); i++)
        {
            if(stop[i] > maxlen)
            {
                maxlen = stop[i];
                maxdex = i;
            }
        }
        System.out.println(maxlen+" "+maxdex);
    }
    static int gcd(int a, int b)
    {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}