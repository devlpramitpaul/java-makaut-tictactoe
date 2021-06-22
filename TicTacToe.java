import java.io.*;
import java.util.*;
class cal
{
	String arr[] = {"1","2","3","4","5","6","7","8","9"};
	
	int check()
	{
		if((arr[0].equals(arr[1])) && (arr[1].equals(arr[2])))
			return 1;		
		else if((arr[3].equals(arr[4])) && (arr[4].equals(arr[5])))
			return 1;		
		else if((arr[6].equals(arr[7])) && (arr[7].equals(arr[8])))
			return 1;
		
		else if((arr[0].equals(arr[3])) && (arr[3].equals(arr[6])))
			return 1;		
		else if((arr[1].equals(arr[4])) && (arr[4].equals(arr[7])))
			return 1;		
		else if((arr[2].equals(arr[5])) && (arr[5].equals(arr[8])))
			return 1;
		
		else if((arr[0].equals(arr[4])) && (arr[4].equals(arr[8])))
			return 1;		
		else if((arr[2].equals(arr[4])) && (arr[4].equals(arr[6])))
			return 1;
		
		else
			return 0;
	}	
	
	void display()
	{
		System.out.println("\n"+arr[0]+"|"+arr[1]+"|" +arr[2]);
		System.out.println("-|-|-");
		System.out.println(arr[3]+"|"+arr[4]+"|" +arr[5]);
		System.out.println("-|-|-");
		System.out.println(arr[6]+"|"+arr[7]+"|" +arr[8]);
		
	}
}

class ticTacToe
{
	public static void main(String args[])
	{
		Scanner inp = new Scanner(System.in);
		cal obj = new cal();
		int n,i,ret,cntr = 1,pass=0;
		int ck[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		String entr = "O";
		
		do
		{
			if(entr.equals("O"))
				entr = "X";
			else
				entr = "O";
			
			obj.display();
			
			do
			{
				do
				{
					System.out.print("\nEnter the index where you want to put '"+entr+"' : ");
					n = inp.nextInt();
					
					if (n<=0 || n>=10)
						System.out.println("\n***Wrong Input***");
				}while(n<=0 || n>=10);
				
				if(ck[n-1] == n-1)
				{
					pass=0;
					System.out.print("\n***Wrong Input. Storage already Covered***\n");
				}
				else
					pass=1;
			}while(pass == 0);				
			
			cntr++;
			ck[n-1] = n-1;
			obj.arr[n-1] = entr;
			ret = obj.check();
		}while(ret == 0 && cntr <=9);
		
		obj.display();
		
		if(ret == 0)
			System.out.println("\n***DRAW***");
		else
			System.out.println("\n***TEAM '"+entr+"' WON***");
	}
}