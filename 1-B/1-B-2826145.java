import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int t = 0; t<n; t++)
        {
            String s = input.next();
            if(s.indexOf('R') > -1 &&  s.indexOf('R') < s.length()-1 && s.charAt(s.indexOf('R')+1) <= '9' && s.indexOf('C') > s.indexOf('R'))
            {
                int rownum = Integer.parseInt(s.substring(1+s.indexOf('R'), s.indexOf('C')));
                int colnum = Integer.parseInt(s.substring(s.indexOf('C')+1));
                String str = "";
                if(colnum <= 26)
                {
                    str += (char)('A'+colnum-1);
                }
                else if(colnum <= 26 + 26*26)
                {
                    while(colnum > 0)
                    {
                        str = (char)('A'+(colnum-1)%26)+str;
                        colnum--;
                        colnum /= 26;
                    }
                }
                else if(colnum <= 26+26*26+26*26*26)
                {
                    while(colnum > 0)
                    {
                        str = (char)('A'+(colnum-1)%26)+str;
                        colnum--;
                        colnum /= 26;
                    }
                }
                else if(colnum <= 26+26*26+26*26*26+26*26*26*26)
                {
                    while(colnum > 0)
                    {
                        str = (char)('A'+(colnum-1)%26)+str;
                        colnum--;
                        colnum /= 26;
                    }
                }
                else
                {
                    while(colnum > 0)
                    {
                        str = (char)('A'+(colnum-1)%26)+str;
                        colnum--;
                        colnum /= 26;
                    }
                }
                System.out.println(str + rownum);
            }
            else
            {
                String col = "";
                int ch = 0;
                while(s.charAt(ch) > '9')
                {
                    col += s.charAt(ch);
                    ch++;
                }
                int colNum = 0;
                for(int i = 0; i<col.length(); i++)
                {
                    colNum *= 26;
                    colNum += col.charAt(i)-'A'+1;
                }
                System.out.println("R" + s.substring(col.length()) + "C" + colNum);
            }
        }
        
    }
}