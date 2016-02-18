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

  private void populateWith(int num){
    for (int r = 0; r<this.matrix.length;r++ ) {
      for (int c = 0; c<this.matrix[0].length;c++ ) {
      this.matrix[r][c] = num;
      };
    };
  };

  public void enter(int row,int column,int value){
    this.matrix[row][column] = value;
  };

  public int get(int row, int column){
    return this.matrix[row][column];
  };

  public Matrix add(Matrix m){
    return new Matrix(1,1);
  };
}
