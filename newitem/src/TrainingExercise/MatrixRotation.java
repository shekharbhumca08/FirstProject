package TrainingExercise;
import java.io.*;

public class MatrixRotation {
	
	public static void main(String[] args)
	{
		System.out.println("Please enter a matrix of 3*3 order");
		StringBuilder inputMatrixInALine = new StringBuilder();
		try
		{
			BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
			String inputRow ;
			
			while((inputRow = BR.readLine()) != null && (inputRow.length()!= 0))
			{
					inputMatrixInALine.append(inputRow).append(" ");
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if( inputMatrixInALine.length() > 0)
		{
			String[] elementsAsString = inputMatrixInALine.toString().split(" ");
			int numOfElements = elementsAsString.length;
			int[] elementsAsInt = new int[numOfElements];
			int[][] tempMatrix = new int[3][3];
			for(int i=0;i<numOfElements;i++)
			{
				elementsAsInt[i] = Integer.parseInt(elementsAsString[i]);
			}
			int rowIndex,colIndex;
			for(int i=0;i<numOfElements;i++)
			{
				rowIndex=i/3;
				colIndex=i%3;
				tempMatrix[rowIndex][colIndex]=elementsAsInt[i];

			}
			
			int[][] rotatedMat = Matrix.rotateMatrixBy90Deg(tempMatrix);
			
			System.out.println("Rotated Matrix is :");
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(rotatedMat[i][j]+" ");
				}
				System.out.println();
			}

		}
	}
}
class Matrix
{
	static int[][] rotateMatrixBy90Deg(int[][] mat)
	{
		int[][] rotatedMatrix = new int[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				rotatedMatrix[j][2-i]=mat[i][j];
			}
		}
		return rotatedMatrix;
	}
	
}