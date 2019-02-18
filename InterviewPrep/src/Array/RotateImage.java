package Array;

public class RotateImage {
	public void rotate(int[][] matrix) {
        
        
        // reverse the matrix
        int lenOfMatrix = matrix.length;
        for(int row=0; row<lenOfMatrix/2; row++) {
            int[] tempRow = matrix[row];
            matrix[row] = matrix[lenOfMatrix-row-1];
            matrix[lenOfMatrix-row-1] = tempRow;
        }
        
        for(int i=0; i<lenOfMatrix; i++) {
            for(int j = i+1; j<matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return;
    }
}
