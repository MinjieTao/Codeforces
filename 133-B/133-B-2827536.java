import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] twopow = new int[501];
        twopow[0] = 1;
        for(int i = 1; i<twopow.length; i++)
            twopow[i] = (2*twopow[i-1])%1000003;
        String s = input.next();
        String str = "";
        for(int i = 0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='>')
                str += "1000";
            else if(c=='<')
                str += "1001";
            else if(c=='+')
                str += "1010";
            else if(c=='-')
                str += "1011";
            else if(c=='.')
                str += "1100";
            else if(c==',')
                str+="1101";
            else if(c=='[')
                str+= "1110";
            else
                str+="1111";
        }
        int res = 0;
        for(int i = 0; i<str.length(); i++)
        {
            char c = str.charAt(str.length()-i-1);
            if(c=='1')
                res += twopow[i];
            res%=1000003;
        }
        System.out.println(res);
    }
}