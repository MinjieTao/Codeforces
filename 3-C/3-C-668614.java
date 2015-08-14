import java.util.*;
import java.io.*;
public class tictactoe
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int[] board = new int[9];
int num0 = 0;
int num1 = 0;
int num2 = 0;
String s = input.next() + input.next() + input.next();
for(int i = 0; i < 9; i++)
{
String c = s.substring(i,i+1);
if(c.equals("."))
{
board[i] = 0;
num0++;
}
else if(c.equals("0"))
{
board[i] = 2;
num2++;
}
else
{
board[i] = 1;
num1++;
}
}
//System.out.println(num0 + " " + num1 + " " + num2);
if(!((num1 == (num2 + 1) && num0%2==0)  || ((num1 == num2) && (num0%2!=0))) || (hasWon(1, board) && hasWon(2, board)))
System.out.println("illegal");
else if(hasWon(1, board))
{
if(num0%2==0)
System.out.println("the first player won");
else
System.out.println("illegal");
}
else if(hasWon(2, board))
{
if(num0%2==1)
System.out.println("the second player won");
else
System.out.println("illegal");
}
else if(num0==0)
System.out.println("draw");
else if(num0%2==1)
System.out.println("first");
else
System.out.println("second");




}


public static Boolean hasWon(int k, int[] board)
{
Boolean b = false;
for(int i = 0; i < 9; i+=3)
{
if(board[i] == k && board[i+1] == k && board[i+2] == k)
b = true;
}
for(int i = 0; i < 3; i++)
{
if(board[i] == k && board[i+3] == k && board[i+6] == k)
b = true;
}
if(board[0] == k && board[4] == k && board[8] == k)
b = true;
if(board[2] == k && board[4] == k && board[6] == k)
b = true;
return b;
}
}