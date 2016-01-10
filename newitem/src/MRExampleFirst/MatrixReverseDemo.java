package MRExampleFirst;

class Matrix {

	int[][] matrics = new int[3][3];
	int[][] reversedMatrics= new int[3][3];
	
	Matrix(int[][] a)
	{
	   this.matrics = a;
	}
	public void ReverseMatrix()
	{
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				this.reversedMatrics[i][j]=this.matrics[j][i];
			}
		}
	}
	public static void DisplayMatrix(int[][] a)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
	}
}

public class MatrixReverseDemo
{
	public static void main(String[] args){
		int[][] matrcs1 = {{1,2,3},{4,5,6},{7,8,9}};
		Matrix mat1 = new Matrix(matrcs1);
		Matrix.DisplayMatrix(mat1.matrics);
		mat1.ReverseMatrix();
		Matrix.DisplayMatrix(mat1.reversedMatrics);
	}
}
