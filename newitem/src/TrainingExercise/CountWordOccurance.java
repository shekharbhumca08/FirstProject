package TrainingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;;

public class CountWordOccurance {
	
	public static void main(String[] args)
	{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> strMap = new HashMap<String,Integer>();
		try
		{
			String input;
			
			while((input= BR.readLine())!=null && (input.length()!=0))
			{
				String[] str_arr = input.split(" ");
				for(String s:str_arr)
				{
					if(strMap.containsKey(s))
					{
						int value = strMap.get(s);
						strMap.put(s, value+1);
					}
					else
					{
						
						strMap.put(s,1);
					}
					
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("you have entered :" + strMap );
		
	}


}
