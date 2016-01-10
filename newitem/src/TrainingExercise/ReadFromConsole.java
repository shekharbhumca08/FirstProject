package TrainingExercise;

import java.io.*;
import java.util.*;

public class ReadFromConsole {
	
	public static void main(String[] args)
	{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strList = new ArrayList<String>();
		try
		{
			String input;
			
			while((input= BR.readLine())!=null && (input.length()!=0))
			{
				String[] str_arr = input.split(" ");
				for(String s:str_arr)
				{
					strList.add(s);
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("you have entered :" + strList.size() + "  words");
		
	}

}
