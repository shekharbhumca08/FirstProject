package TrainingExercise;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TextNTokens {

	
	public static void main()
	{
		ArrayList<String> tokenList = TextInput.breakTextIntoTokens();
		if(tokenList == null)
		{
			System.out.println("No tokens found");
		}
		else
		{
					
			System.out.println("Tokens and count :" + TokenOutput.readTokensNCountThem(tokenList) );
		}
			
	}
}

 class TextInput
{
	 static ArrayList<String> breakTextIntoTokens()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> tokenList = new ArrayList<String>();
		try
		{
			String line;
			while((line=br.readLine())!=null && (line.length()!=0))
			{
				String[] tokens = line.split(" ");
				for(String token : tokens)
				{
					tokenList.add(token);
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();

		}
		
		return tokenList;
	}
}

class TokenOutput
{
	static HashMap<String,Integer> readTokensNCountThem(ArrayList<String> tempTokenList)
	{
		HashMap<String,Integer> tokenCountMap = new HashMap<String,Integer>();
		for(String token : tempTokenList)
		{
			if(tokenCountMap.containsKey(token))
			{
				tokenCountMap.put(token, tokenCountMap.get(token) + 1);
			}
			else
				tokenCountMap.put(token, 1);
			
		}
		return tokenCountMap;
	}
}
