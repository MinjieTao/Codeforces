import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), q = input.nextInt();
    ArrayList<Character> data = new ArrayList<Character>();
    String s = input.next();
    for(int i = 0; i<n; i++) data.add(s.charAt(i));
    for(int i = 0; i<q; i++)
    {
        int[] count = new int[10];
        int l = input.nextInt()-1, r = input.nextInt()-1;
        ArrayList<Character> nums = new ArrayList<Character>();
        for(int j = l; j<=r; j++) nums.add(data.get(j));
        int cp = 0, dp = 1;
        while(true)
        {
//          for(char ch: nums)
//              System.out.print(ch);
//                  System.out.println();
            if(cp < 0 || cp >= nums.size())
                break;
            char at = nums.get(cp);
            //System.out.println(cp + " " + dp + " " + at + " " + nums.size());
            if(at == '<')
            {
                dp = 0;
                cp--;
                if(cp >= 0 && (nums.get(cp) == '>' || nums.get(cp) == '<'))
                nums.remove(cp+1);
            }
            else if(at == '>')
            {
                dp = 1;
                cp++;
                if(cp < nums.size() && (nums.get(cp) == '>' || nums.get(cp) == '<'))
                {
                nums.remove(cp-1);
                cp--;
                }
            }
            else
            {
                int out = at - '0';
                //System.out.println(out);
                count[out]++;
                if(dp == 0)
                {
                    cp--;
                    if(nums.get(cp+1) == '0')
                    {
                        nums.remove(cp+1);
                    }
                    else
                    nums.set(cp+1, (char) (nums.get(cp+1)-1));
                    
                }
                else
                {
                    cp++;
                    if(nums.get(cp-1) == '0')
                    {
                        nums.remove(cp-1);
                        cp--;
                    }
                    else
                        nums.set(cp-1, (char) (nums.get(cp-1)-1));
                    
                }
            }
        }
        for(int c: count)
            System.out.print(c + " ");
                System.out.println();
    }
}
}