import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void enter_values_in_matrix(){
    Matrix m = new Matrix(4,4);
    m.enterValueAt(2,2,45);
    m.enterValueAt(3,3,99);
    assertEquals(m.get(2,2),45);
    assertEquals(m.get(1,1),0);
    assertEquals(m.get(3,3),99);
  };

  @Test
  public void fill_all_values_at_a_time_in_matrix(){
    Matrix m = new Matrix(2,2);
    int[] values = {1,2,3,4};
    m.fillMatrix(values);
    assertEquals(m.get(0,0),1);
    assertEquals(m.get(0,1),2);
    assertEquals(m.get(1,0),3);
    assertEquals(m.get(1,1),4);
  }

  @Test
  public void add_two_matrices_2_3(){
    Matrix a = new Matrix(2,3);
    a.enterValueAt(0,0,0);
    a.enterValueAt(0,1,1);
    a.enterValueAt(0,2,2);
    a.enterValueAt(1,0,9);
    a.enterValueAt(1,1,8);
    a.enterValueAt(1,2,7);

    Matrix b = new Matrix(2,3);
    b.enterValueAt(0,0,6);
    b.enterValueAt(0,1,5);
    b.enterValueAt(0,2,4);
    b.enterValueAt(1,0,3);
    b.enterValueAt(1,1,4);
    b.enterValueAt(1,2,5);

    Matrix sum = a.add(b);

    assertEquals(sum.get(0,0),6);
    assertEquals(sum.get(0,1),6);
    assertEquals(sum.get(0,2),6);
    assertEquals(sum.get(1,0),12);
    assertEquals(sum.get(1,1),12);
    assertEquals(sum.get(1,2),12);
  };

  @Test
  public void add_two_matrices_1_1(){
    Matrix a = new Matrix(1,1);
    a.enterValueAt(0,0,0);

    Matrix b = new Matrix(1,1);
    b.enterValueAt(0,0,6);

    Matrix sum = a.add(b);

    assertEquals(sum.get(0,0),6);
  };

  @Test
  public void mutiply_two_matrices(){
    Matrix a = new Matrix(2,3);
    a.enterValueAt(0,0,1);
    a.enterValueAt(0,1,0);
    a.enterValueAt(0,2,2);
    a.enterValueAt(1,0,0);
    a.enterValueAt(1,1,3);
    a.enterValueAt(1,2,1);

    Matrix b = new Matrix(3,2);
    b.enterValueAt(0,0,0);
    b.enterValueAt(0,1,3);
    b.enterValueAt(1,0,2);
    b.enterValueAt(1,1,1);
    b.enterValueAt(2,0,0);
    b.enterValueAt(2,1,4);

    Matrix product = a.multiply(b);

    assertEquals(product.get(0,0),0);
    assertEquals(product.get(0,1),11);
    assertEquals(product.get(1,0),6);
    assertEquals(product.get(1,1),7);
  };

  @Test
  public void mutiply_two_matrices_with_same_dimensions(){
    Matrix a = new Matrix(2,2);
    a.enterValueAt(0,0,1);
    a.enterValueAt(0,1,0);
    a.enterValueAt(1,0,0);
    a.enterValueAt(1,1,3);

    Matrix b = new Matrix(2,2);
    b.enterValueAt(0,0,0);
    b.enterValueAt(0,1,3);
    b.enterValueAt(1,0,1);
    b.enterValueAt(1,1,0);

    Matrix product = a.multiply(b);

    assertEquals(product.get(0,0),0);
    assertEquals(product.get(0,1),3);
    assertEquals(product.get(1,0),3);
    assertEquals(product.get(1,1),0);
  };

  @Test
  public void mutiply_two_matrices_with_one_element(){
    Matrix a = new Matrix(1,1);
    a.enterValueAt(0,0,10);

    Matrix b = new Matrix(1,1);
    b.enterValueAt(0,0,99);

    Matrix product = a.multiply(b);
    assertEquals(product.get(0,0),990);
  };

  @Test
  public void find_determinant_of_a_2X2_matrix(){
    Matrix m = new Matrix(2,2);
    m.enterValueAt(0,0,3);
    m.enterValueAt(0,1,6);
    m.enterValueAt(1,0,4);
    m.enterValueAt(1,1,8);

    assertEquals(m.findDeterminant(),0);
  };
};
