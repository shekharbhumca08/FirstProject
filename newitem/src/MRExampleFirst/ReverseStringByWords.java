package MRExampleFirst;

//import java.util.Scanner;

public class ReverseStringByWords {

	public static void main(String args[])
	{
		String original,reversed="";
		//Scanner in = new Scanner(System.in);
		
		//original = in.nextLine();
		original="Reverse me";
		String[] stringArr = original.split(" ");
		int numOfWords = stringArr.length;
		
		for(int i=0;i<numOfWords;i++)
		{
			reversed = reversed + stringArr[numOfWords-i-1]+" ";
		}
		reversed = reversed.substring(0,reversed.length()-1);
		
		System.out.println(reversed);
	}
}
