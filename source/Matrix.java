import java.util.Arrays;
public class Matrix {

  private int[][] matrix;
  private int rows;
  private int columns;

  public Matrix(int row,int column){
    this.matrix = new int[row][column];
    this.rows = row;
    this.columns = column;
  };

  public String toString(){
    String output = "";
    for (int r = 0; r<this.rows;r++ ) {
      for (int c = 0; c<this.columns;c++ ) {
      output += this.matrix[r][c] + "  ";
      };
      output += "\n";
    };
    return output;
  };

  public void enterValueAt(int row,int column,int value){//name???
    this.matrix[row][column] = value;
  };

  public int valueOf(int row, int column){
    return this.matrix[row][column];
  };

  public void fillMatrix(int[] a){
    int count = 0;
    for (int r = 0; r<this.rows;r++ )
      for (int c = 0; c<this.columns;c++ ){
        this.matrix[r][c] = a[count];
        count++;
      }
  };

  public Matrix add(Matrix m){
    Matrix result = new Matrix(this.rows,this.columns);
    for (int r = 0;  r< this.rows; r++)
      for (int c = 0; c< this.columns; c++)
        result.enterValueAt(r,c,(this.matrix[r][c]+ m.valueOf(r,c)));
    return result;
  };

  private int[] getColumn(Matrix m,int columnNumber){
    int[] column = new int[m.rows];
    for (int i=0; i<m.rows; i++)
        column[i] = m.matrix[i][columnNumber];
    return column;
  };

  private int multiplyRowAndColumn(int[] row,int[] column){
    int result = 0;
    for (int i = 0; i<row.length; i++ )
      result = result+(row[i]*column[i]);
    return result;
  };

  public Matrix multiply(Matrix m){
    Matrix result = new Matrix(this.rows,this.rows);
      for (int r = 0;  r< this.rows; r++){
        int[] row = this.matrix[r];
        for (int c = 0; c<m.columns; c++) {
          int[] column = getColumn(m,c);
          int product = multiplyRowAndColumn(column,row);
          result.enterValueAt(r,c,product);
        };
      };
    return result;
  };

  public boolean isSameAs(Matrix m){
    return Arrays.deepEquals(this.matrix,m.matrix);
  };

  public Matrix sub(int row,int col){
    Matrix subMatrix = new Matrix(rows-1,columns-1);
    int insertAtRow = 0;

    for (int r =0; r<this.rows; r++) {
      if(r!=row){
        int insertAtCol = 0;
        for (int c = 0; c<this.columns ; c++) {
          if(c!=col){
            subMatrix.enterValueAt(insertAtRow,insertAtCol,this.valueOf(r,c));
            insertAtCol++;
          };
        };
        insertAtRow++;
      };
    };

      return subMatrix;
  };

  public int findDeterminant(){
    if(this.rows == 2 && this.columns == 2)
      return (this.matrix[0][0] * this.matrix[1][1]) - (this.matrix[0][1] * this.matrix[1][0]);
    int[] firstRow = this.matrix[0];
    int sign = 1;
    int d = 0;
    for (int i = 0; i < firstRow.length; i++) {
      d = d + (this.valueOf(0,i))*(sign * this.sub(0,i).findDeterminant());
      sign = sign * -1;
    };
    return d;
  };
};
