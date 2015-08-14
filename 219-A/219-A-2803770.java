import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        int[] freq = new int[26];
        for(int i = 0; i<s.length(); i++)
            freq[s.charAt(i)-'a']++;
        boolean possible = true;
        for(int i = 0; i<26; i++)
            if(freq[i]%n != 0)
                possible = false;
        if(!possible)
            System.out.println(-1);
        else
        {
            for(int i = 0; i<n; i++)
            {
                for(int j = 0; j<26; j++)
                {
                    for(int k = 0; k<freq[j]/n; k++)
                    {
                        System.out.print((char)('a'+j));
                    }
                }
            }
        }
    }
}