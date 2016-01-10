package TrainingExercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;;
//import java.util.logging.ConsoleHandler;

public class DateDifference {

	public static void main(String[] args)
	{
		System.out.println("Enter two dates in DD-MON-YYYY format and we will return you differnce in days");
		System.out.println("Enter first date");
		Scanner sc = new Scanner(System.in);
		
		String firstDateString = sc.nextLine();
		
		System.out.println("Enter second date");
		String secondDateString = sc.nextLine();
		Date firstDate = convertStringToDate(firstDateString);
		Date secondDate = convertStringToDate(secondDateString);
		
		System.out.println("Difference in days : "+ findDateDiffInDays(firstDate, secondDate));
		
	}
	
	static Date convertStringToDate(String dateString)
	{
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date date=null;
		try
		{
			date = formater.parse(dateString);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			
		}
		
		return date;
	}
	static long findDateDiffInDays(Date fDate,Date tDate)
	{
		long days = (tDate.getTime() - fDate.getTime())/(1000*60*60*24);
		return days;
	}
}
