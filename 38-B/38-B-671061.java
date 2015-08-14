import java.util.*;
import java.math.*;
public class chess
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String rook = input.next();
String knight = input.next();
int counter = 0;
char rowr = rook.substring(0,1).charAt(0);
int colr = Integer.parseInt(rook.substring(1,2));
char rowk = knight.substring(0,1).charAt(0);
int colk = Integer.parseInt(knight.substring(1,2));
char[] rows = new char[8];
int[] cols = new int[8];
for(int i = 0; i < 8; i++)
{
rows[i] = (char)('a' + i);
cols[i] = 1 + i;
}
for(int i = 0; i < 8; i++)
{
for(int j = 0; j < 8; j++)
{
Boolean legit = true;
if((rows[i] == rowr) || (cols[j] == (colr)))
legit = false;
else if((Math.abs(rows[i]-rowk) + Math.abs(cols[j]-colk) == 3) && (Math.abs(rows[i]-rowk) < 3) && (Math.abs(cols[j]-colk) < 3))
legit = false;
else if((Math.abs(rows[i]-rowr) + Math.abs(cols[j]-colr) == 3) && (Math.abs(rows[i]-rowr) < 3) && (Math.abs(cols[j]-colr) < 3))
legit = false;
else if((rows[i]==rowk) && (cols[j]==colk))
legit = false;
if(legit)
{
counter++;
}
}
}
System.out.println(counter);
}
}