public class Matrix {

  private int[][] matrix;

  public Matrix(int row,int column){
    this.matrix = new int[row][column];
  };

  public void print(){
    for (int r = 0; r<this.matrix.length;r++ ) {
      for (int c = 0; c<this.matrix[0].length;c++ ) {
      System.out.print(this.matrix[r][c] + "  ");
      };
      System.out.println("");
    };
  };

  public void enterValueAt(int row,int column,int value){//name???
    this.matrix[row][column] = value;
  };

  public int get(int row, int column){
    return this.matrix[row][column];
  };

  public void fillMatrix(int[] a){
    int count = 0;
    for (int r = 0; r<this.matrix.length;r++ )
      for (int c = 0; c<this.matrix[0].length;c++ ){
        this.matrix[r][c] = a[count];
        count++;
      }
  };

  public Matrix add(Matrix m){
    Matrix result = new Matrix(this.matrix.length,this.matrix[0].length);
    for (int r = 0;  r< this.matrix.length; r++)
      for (int c = 0; c< this.matrix[0].length; c++)
        result.enterValueAt(r,c,(this.matrix[r][c]+ m.get(r,c)));
    return result;
  };

  private int[] getColumn(Matrix m,int columnNumber){
    int[] column = new int[m.matrix.length];
    for (int i=0; i<m.matrix.length; i++)
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
    Matrix result = new Matrix(this.matrix.length,this.matrix.length);
      for (int r = 0;  r< this.matrix.length; r++){
        int[] row = this.matrix[r];
        for (int c = 0; c<m.matrix[0].length; c++) {
          int[] column = getColumn(m,c);
          int product = multiplyRowAndColumn(column,row);
          result.enterValueAt(r,c,product);
        };
      };
    return result;
  };

  public int findDeterminant(){
      return (this.matrix[0][0] * this.matrix[1][1]) - (this.matrix[0][1] * this.matrix[1][0]);
  };
};
