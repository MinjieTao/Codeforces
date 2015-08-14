import java.util.*;
import java.io.*;
public class longwords
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int num = input.nextInt();
input.nextLine();
for(int i = 0; i < num; i++)
{
String word = input.nextLine();
if(word.length() <= 10)
System.out.println(word);
else
System.out.println(word.charAt(0) + "" + (word.length()-2) + word.charAt(word.length()-1));
}
}
}