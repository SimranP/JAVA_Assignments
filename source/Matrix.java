public class Matrix {

  private int[][] matrix;
  private int rows;
  private int columns;

  public Matrix(int row,int column){
    this.matrix = new int[row][column];
    this.rows = row;
    this.columns = column;
  };

  public void print(){
    for (int r = 0; r<this.rows;r++ ) {
      for (int c = 0; c<this.columns;c++ ) {
      System.out.print(this.matrix[r][c] + "  ");
      };
      System.out.println("");
    };
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

  // private Matrix sub(int r,int c){
  //
  // };

  private int getDeterminant(){
    return (this.matrix[0][0] * this.matrix[1][1]) - (this.matrix[0][1] * this.matrix[1][0]);
  };

  public int findDeterminant(){
    return this.getDeterminant();
  };
};
