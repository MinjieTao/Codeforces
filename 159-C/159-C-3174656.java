import java.io.PrintWriter;
import java.util.*;
public class c {
public static void main(String[] args)
{
    PrintWriter out = new PrintWriter(System.out);
    Scanner input = new Scanner(System.in);
    int k = input.nextInt();
    String s = input.next();
    boolean allSame = true;
    int[] freq = new int[26];
    for(int i = 0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        freq[c-'a']++;
        allSame &= s.charAt(i) == s.charAt(0);
    }
    int size = s.length()*k;
    int queries = input.nextInt();
    boolean[][] gone = new boolean[k][s.length()];
    HashMap<Integer, TreeSet<Integer>> used = new HashMap<Integer, TreeSet<Integer>>();
    for(int i = 0; i<26; i++)
    {
        used.put(i, new TreeSet<Integer>());
    }
    for(int i = 0; i<queries; i++)
    {
        int p = input.nextInt();
        char c = input.next().charAt(0);
        if(allSame)
        {
            size--;
            continue;
        }
        TreeSet<Integer> usedThisChar = used.get(c-'a');
        Iterator itr = usedThisChar.iterator();
        while(itr.hasNext())
        {
            Integer j = (Integer)itr.next();
            if(j <= p)
            {
                p++;
            }
            else
                break;
        }
        //System.out.println(lower);
        //p+= lower;
        int found = 0;
        int pos = 0;
        while(found < (p+freq[c-'a']-1)%freq[c-'a']+1)
        {
            if(s.charAt(pos) == c)
                found++;
            pos++;
        }
        //System.out.println("F"+found);
        pos--;
        //System.out.println(p);
        //System.out.println(pos + " " + p/freq[c-'a']);
        //System.out.println(gone.length + " " + gone[0].length);
        gone[(p-1)/freq[c-'a']][pos] = true;
        used.get(c-'a').add(p);
        
    }
    if(allSame)
    {
        for(int i = 0; i<size; i++)
            out.print(s.charAt(0));
        out.close();
        return;
    }
    for(int m = 0; m<k; m++)
        for(int j = 0; j<s.length(); j++)
        {
            if(!gone[m][j])
                out.print(s.charAt(j));
        }
        
    out.close();
}
}