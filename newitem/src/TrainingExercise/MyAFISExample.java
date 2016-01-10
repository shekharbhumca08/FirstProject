package TrainingExercise;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import sourceafis.simple.AfisEngine;
import sourceafis.simple.Fingerprint;
import sourceafis.simple.Person; 
import org.apache.commons.codec.binary.Base64;
//import org.apache.hadoop.tools.rumen.CDFPiecewiseLinearRandomGenerator;

public class MyAFISExample {
	public static void main(String[] args) throws IOException {
		
		byte[][] c;
		byte[][] cDecoded;
		byte[][] c1 = new byte[10][];
		ArrayList<Person> database=new ArrayList<Person>();
		try
		{
			FileInputStream inputStream;
			String fileName;
			long id=222152;
			//byte[] finger;
			//for each person, total 5 persons wil be created
			for(int i=1;i<=5;i++)
			{
				 c=new byte[10][];
				 cDecoded = new byte[10][];
				 //for each finger,total for 10 fingers
				for(int j=0;j<10;j++)
				{
					int temp=j+1;
					fileName="F:/E/study/shekhar/Java/saama training/AFIS/Minisample - Copy/000" + id +"_" + temp ;
					File file = new File(fileName);
					inputStream = new FileInputStream(file);
					int avlbl= inputStream.available();
					System.out.println("Available bytes : "+ avlbl);
					c[j]= new byte[inputStream.available()];
					
					int readBytes = inputStream.read(c[j]);
					
					System.out.println("Read bytes : "+ readBytes);
					cDecoded[j] = new byte[readBytes];
					cDecoded[j] = Base64.decodeBase64(c[j]);
					
					//DataInputStream d = new DataInputStream(inputStream);
					
					
					
					if(i==1)
					c1[j]=c[j];
				}
				
			    //byte[] b = c.toArray();
				Person p = getPerson((int)id, c);
				database.add(p);
				id+=1;
				
							
			}
			
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		String fileName1;
		FileInputStream inputStream;
		byte[][] probeTemplate= new byte[10][];
		for(int j=0;j<10;j++)
		{
			int temp=j+1;
			fileName1="F:/E/study/shekhar/Java/saama training/AFIS/Minisample1/" + 000222155 + " (" + temp + ")";
			inputStream = new FileInputStream(fileName1);
			inputStream.read(probeTemplate[j]);
			inputStream.close();
		}
		
		//String probeTemplate="Rk1SACAyMAAAAAFQAAABYAIgAMUAxQEAAAAAM0DHASnSAECQASyuAECXAUacAEDYAU6/AEDMAWmmAECsAXQsAECKAW96AECyAYghAEDFALzwAEEiASLaAEDJAZ0eAEA7AUbDAEAvAQWpAEDKAJR/AEEMAaNuAECKAdgAAEByAHCXAEDLARtzAECyAUqwAEC7AVSvAEByASkaAEDoAVu/AECXANr/AED6AVrKAEBpAOQSAEDyAX2/AEBZAOWhAEDmAZYXAEA+AVlAAECqAa8OAEElAYNOAECIAcN9AICwAGqHAICOAF8LAICbARzcAIDOAQncAICeAPn1AID3ATXUAIDfAOPmAIBiAS3AAIB1AWr8AIDoAMlyAIBKAT7BAIEkATrUAIEvATVYAIE2AQDpAICiAJoAAICPAJIKAIChAcsKAID+AHRwAIC3AFb6AAAA";
		
	   // byte[] p1=Base64.decodeBase64(probeTemplate);
		
		//c[0]=Base64.decodeBase64(t1);
		//c[1]=Base64.decodeBase64(t2);
		//c[2]=Base64.decodeBase64(t3);
		//c[3]=Base64.decodeBase64(t4);
	    /*
	     * Create AFIS Engine and set the Threshold
	     */
		AfisEngine afis = new AfisEngine();
		afis.setThreshold(12);
		
        /*
         * Creating database. More persons can be added to database.
         * Only one person is added to database in this example    
         */
		
		
		//database.add(getPerson(1,c));
		 
		/*giving dummy id -1 for probe*/
		Person probe = getPerson(6,probeTemplate);
		Iterable<Person> matches=afis.identify(probe, database);
		
		for(Person match:matches){
			System.out.println("Matched::"+match.getId());
		}
		 
		System.out.println(new Date());
		float[] score = new float[100];
		for(int i=0;i<100;i++){
	    score[i]=	afis.verify(probe, getPerson(1, c1));
		}
	     System.out.println(score);
				System.out.println(new Date());

	}
	/*
	 * Utility function to create a person from finger print template.
	 */
	static Person getPerson(int id,byte[][] t) throws IOException {
		System.out.println("length of template :" + t.length);
		System.out.println(new String(t[0]));
		Fingerprint[] arrFp = new Fingerprint[t.length];
		for(int x=0;x<t.length;x++){	
			arrFp[x] = new Fingerprint();
			arrFp[x].setIsoTemplate(t[x]);
		}
		//Fingerprint[] arrFp = new Fingerprint[5];
		Person p=new Person(arrFp);
		p.setId(id);
		return p;
	}
}
