import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ws = new int[n], hs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ws[i] = input.nextInt();
        hs[i] = input.nextInt();
    }
    int min = 1987654321;
    for(int h = 1; h<=1000; h++)
    {
        int w = 0;
        boolean valid = true;
        ArrayList<Integer> canSave = new ArrayList<Integer>();
        int lying = 0;
        for(int i = 0; i<n; i++)
        {
            if(ws[i] > h && hs[i] > h)
            {
                valid = false;
                break;
            }
            else if(ws[i] > h)
            {
                w += ws[i];
                
            }
            else if(hs[i] > h)
            {
                lying++;
                w += hs[i];
            }
            else
            {
                w += ws[i];
                if(hs[i] < ws[i]) canSave.add(ws[i] - hs[i]);
            }
        }
        Collections.sort(canSave);
        if(lying > n/2) valid = false;
        if(!valid) continue;
        for(int i = 0; i<n/2 - lying && i < canSave.size(); i++) w -= canSave.get(canSave.size() - 1 - i);
        min = Math.min(min, h*w);
    }
    System.out.println(min);

}
}