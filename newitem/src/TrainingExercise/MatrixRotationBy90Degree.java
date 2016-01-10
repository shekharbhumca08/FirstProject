package TrainingExercise;
import java.io.*;
import java.util.*;

class Main {

	static int N;
	public static void main(String[] args)
	{
		String inputFilePath="F:/matrices_input.txt";
		File file  = new File(inputFilePath);
		ArrayList<String> matricesList = new ArrayList<String>();
		ArrayList<String> rotatedMatricesList = new ArrayList<String>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String row;
			while((row=br.readLine())!=null)
			{
				matricesList.add(row);
			}
			br.close();			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		
		for(String matix:matricesList)
		{
			String[][] matrixFromRow=convertRowToMatrix(matix);
			if(matrixFromRow  == null)
			{
				rotatedMatricesList.add("Input at this place was not of N*N order");
			}
			else
			rotatedMatricesList.add(convertMatrixToRow(rotateMatrix(matrixFromRow)));
		}
		
		for(String rotatedMatrix:rotatedMatricesList)
		{
			System.out.println(rotatedMatrix);
		}
	}
	static String[][] convertRowToMatrix(String row)
	{
		String[] temp = row.split(" ");
		int length = temp.length;
		if(!isNumPerfectSquare(length))
		{
			//System.out.println("Invalid matrix, not fit for N*N size");
			return null;
		}
		N=(int)Math.sqrt(length);
		String[][] matrix = new String[N][N];
		
		
		for(int i=0;i<N*N;i++)
		{
			int rowIndex=i/N;
			int colIndex=i%N;
			
			matrix[rowIndex][colIndex]=temp[i];
		}
		return matrix;
	}
	static String[][] rotateMatrix(String[][] matrixToRotate)
	{
		String[][] rotatedMatrix = new String[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				rotatedMatrix[j][N-1-i]=matrixToRotate[i][j];
			}
		}
		return rotatedMatrix;
	}
	static String convertMatrixToRow(String[][] matrix)
	{
		StringBuilder matrixAsRow = new StringBuilder();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				matrixAsRow.append(matrix[i][j]).append(" ");
			}
		}
		return matrixAsRow.toString();
	}
	static boolean isNumPerfectSquare(int num)
	{
		int sqrt=(int)Math.sqrt(num);
		if(sqrt*sqrt==num)
			return true;
		else
			return false;
	}
}
