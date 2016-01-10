package codeEvalMedium;
import java.io.*;
import java.util.*;

interface stack
{
	boolean push(int a);
	
	int pop();
}
public class StackDemo {
	
	public static void main(String[] args)
	{
		ArrayList<String> listNum = new ArrayList<String>();
		try
		{
			///E/study/shekhar/Java/Codeeval/Input_files
			File file = new File("F:/stackInterface.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String stackString;
			while((stackString=br.readLine())!=null)
			{
				listNum.add(stackString);
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		StackUsingList stackObj ;
		ArrayList<Integer> stackIntegers;
		for(String s: listNum)
		{
			stackIntegers= new ArrayList<Integer>();
			//int i=0;
			for(String temp: s.split(" "))
			{
				stackIntegers.add(Integer.parseInt(temp));
			}
			stackObj = new StackUsingList();
			//push all elements in each line
			for(int j=0;j<stackIntegers.size();j++)
			{
				stackObj.push(stackIntegers.get(j));
				//System.out.println(stackObj.stackList);
			}
			for(int j=0;!stackObj.stackList.isEmpty();j++)
			{
				int popedElement=stackObj.pop();
				if(j%2==0)
				{
					System.out.print(popedElement+" ");
				}
				
			}
			System.out.println();
		}
		
	}
}

class StackUsingList implements stack
{
	ArrayList<Integer> stackList = new ArrayList<Integer>();
	int count;
		
	public boolean push(int a)
	{
		stackList.add(a);
		count++;
		return true;
	}
	public int pop()
	{
		//if(!stackList.isEmpty())
		//{
			//int lastIndex=stackList.size();
			int popedElement=stackList.get(count-1);
			stackList.remove(count-1);
			count--;
			return popedElement;
		//}
	}
}
