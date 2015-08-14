import java.util.*;
import java.io.*;
public class doublecola
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int num = input.nextInt();
String[] names = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
System.out.println(names[finder2(num)]);
//System.out.println(finder(num));
}

public static String finder(int i)
{
ArrayList<String> names = new ArrayList<String>();
names.add("Sheldon");
names.add("Leonard");
names.add("Penny");
names.add("Rajesh");
names.add("Howard");
for(int j = 0; j < i +1; j++)
{
names.add(names.get(j));
names.add(names.get(j));
if(names.size()>=i)
return names.get(i-1);


}
return "fail";
}
public static int finder2(int i)
{
int place = (i-1)/5 +2;
//System.out.println(place);
double d = Math.log((double)place)/Math.log(2.0);
//System.out.println(d);
int erval = (int)d;
if(d!=(int)d)
erval++;
//System.out.println(erval);
int pos = (int)(i - 5*(Math.pow(2.0,(double)(erval-1))-1));
double check = Math.pow(2.0, erval -1.0);
int out = ((pos-1)/(int)check);
return out;

}
}