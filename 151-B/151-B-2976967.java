import java.util.*;
public class PhoneNumbers {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] taxis = new int[n];
    int[] pizzas = new int[n];
    int[] girls = new int[n];
    int maxTaxi = 0, maxPizza = 0, maxGirl = 0;
    String[] names = new String[n];
    for(int i = 0; i<n; i++)
    {
        int numbers = input.nextInt();
        names[i] = input.next();
        for(int j = 0; j<numbers; j++)
        {
            String s = input.next();
            int[] digits = new int[6];
            int[] notDashes = {0, 1, 3, 4, 6, 7};
            for(int k = 0; k<6; k++)
                digits[k] = s.charAt(notDashes[k])-'0';
            boolean allSame = true, decreasing = true;
            for(int k = 1; k<6; k++)
            {
                if(digits[k] != digits[k-1]) allSame = false;
                if(digits[k] >= digits[k-1]) decreasing = false;
            }
            if(allSame)
                taxis[i]++;
            else if(decreasing)
                pizzas[i]++;
            else
                girls[i]++;
        }
        if(taxis[i] > maxTaxi) maxTaxi = taxis[i];
        if(pizzas[i] > maxPizza) maxPizza = pizzas[i];
        if(girls[i] > maxGirl) maxGirl = girls[i];
    }
    //print output
    
    //taxi
    System.out.print("If you want to call a taxi, you should call: ");
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        if(taxis[i] == maxTaxi)
        {
            if(count == 0)
                System.out.print(names[i]);
            else
                System.out.print(", " + names[i]);
            count++;
        }
    }
    System.out.println(".");
    
    //pizza
    System.out.print("If you want to order a pizza, you should call: ");
    count = 0;
    for(int i = 0; i<n; i++)
    {
        if(pizzas[i] == maxPizza)
        {
            if(count == 0)
                System.out.print(names[i]);
            else
                System.out.print(", " + names[i]);
            count++;
        }
    }
    System.out.println(".");
    
    //girl
    System.out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
    count = 0;
    for(int i = 0; i<n; i++)
    {
        if(girls[i] == maxGirl)
        {
            if(count == 0)
                System.out.print(names[i]);
            else
                System.out.print(", " + names[i]);
            count++;
        }
    }
    System.out.println(".");
}
}