import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void enter_values_in_matrix(){
    Matrix m = new Matrix(4,4);
    m.enterValueAt(2,2,45);
    m.enterValueAt(3,3,99);
    assertEquals(m.valueOf(2,2),45);
    assertEquals(m.valueOf(1,1),0);
    assertEquals(m.valueOf(3,3),99);
  };

  @Test
  public void fill_all_values_at_a_time_in_matrix(){
    Matrix m = new Matrix(2,2);
    int[] values = {1,2,3,4};
    m.fillMatrix(values);
    assertEquals(m.valueOf(0,0),1);
    assertEquals(m.valueOf(0,1),2);
    assertEquals(m.valueOf(1,0),3);
    assertEquals(m.valueOf(1,1),4);
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

    assertEquals(sum.valueOf(0,0),6);
    assertEquals(sum.valueOf(0,1),6);
    assertEquals(sum.valueOf(0,2),6);
    assertEquals(sum.valueOf(1,0),12);
    assertEquals(sum.valueOf(1,1),12);
    assertEquals(sum.valueOf(1,2),12);
  };

  @Test
  public void add_two_matrices_1_1(){
    Matrix a = new Matrix(1,1);
    a.enterValueAt(0,0,0);

    Matrix b = new Matrix(1,1);
    b.enterValueAt(0,0,6);

    Matrix sum = a.add(b);

    assertEquals(sum.valueOf(0,0),6);
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

    assertEquals(product.valueOf(0,0),0);
    assertEquals(product.valueOf(0,1),11);
    assertEquals(product.valueOf(1,0),6);
    assertEquals(product.valueOf(1,1),7);
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

    assertEquals(product.valueOf(0,0),0);
    assertEquals(product.valueOf(0,1),3);
    assertEquals(product.valueOf(1,0),3);
    assertEquals(product.valueOf(1,1),0);
  };

  @Test
  public void mutiply_two_matrices_with_one_element(){
    Matrix a = new Matrix(1,1);
    a.enterValueAt(0,0,10);

    Matrix b = new Matrix(1,1);
    b.enterValueAt(0,0,99);

    Matrix product = a.multiply(b);
    assertEquals(product.valueOf(0,0),990);
  };

  @Test
  public void find_determinant_of_a_2X2_matrix(){
    Matrix m = new Matrix(2,2);
    m.enterValueAt(0,0,3);
    m.enterValueAt(0,1,8);
    m.enterValueAt(1,0,4);
    m.enterValueAt(1,1,6);

    assertEquals(m.findDeterminant(),-14);
  };

  @Test
  public void isSameAs_checks_if_two_matrices_are_same(){
    Matrix a = new Matrix(2,2);
    a.enterValueAt(0,0,3);
    a.enterValueAt(0,1,8);
    a.enterValueAt(1,0,4);
    a.enterValueAt(1,1,6);

    Matrix b = new Matrix(2,2);
    b.enterValueAt(0,0,3);
    b.enterValueAt(0,1,8);
    b.enterValueAt(1,0,4);
    b.enterValueAt(1,1,6);

    assertEquals(true,a.isSameAs(b));
  };

  @Test
  public void isSameAs_checks_if_order_of_two_matrices_is_different(){
    Matrix a = new Matrix(2,2);
    a.enterValueAt(0,0,3);
    a.enterValueAt(0,1,8);
    a.enterValueAt(1,0,4);
    a.enterValueAt(1,1,6);

    Matrix b = new Matrix(1,2);
    b.enterValueAt(0,0,3);
    b.enterValueAt(0,1,90);

    assertEquals(false,a.isSameAs(b));
  };

  @Test
  public void isSameAs_checks_if_two_matrices_are_not_same(){
    Matrix a = new Matrix(2,2);
    a.enterValueAt(0,0,3);
    a.enterValueAt(0,1,8);
    a.enterValueAt(1,0,2);
    a.enterValueAt(1,1,6);

    Matrix b = new Matrix(2,2);
    b.enterValueAt(0,0,3);
    b.enterValueAt(0,1,8);
    b.enterValueAt(1,0,4);
    b.enterValueAt(1,1,6);

    assertEquals(false,a.isSameAs(b));
  };

  @Test public void sub_gives_the_sub_matrix(){
    Matrix a = new Matrix(3,3);
    a.enterValueAt(0,0,1);
    a.enterValueAt(0,1,0);
    a.enterValueAt(0,2,2);
    a.enterValueAt(1,0,0);
    a.enterValueAt(1,1,3);
    a.enterValueAt(1,2,1);
    a.enterValueAt(2,0,7);
    a.enterValueAt(2,1,3);
    a.enterValueAt(2,2,4);

    Matrix subMatrix = new Matrix(2,2);
    subMatrix.enterValueAt(0,0,3);
    subMatrix.enterValueAt(0,1,1);
    subMatrix.enterValueAt(1,0,3);
    subMatrix.enterValueAt(1,1,4);

    Matrix b = a.sub(0,0);
    assertEquals(subMatrix.isSameAs(a.sub(0,0)),true);
  };

  @Test
  public void find_determinant_of_a_3X3_matrix(){
    Matrix m = new Matrix(3,3);
    m.enterValueAt(0,0,3);
    m.enterValueAt(0,1,8);
    m.enterValueAt(0,2,2);
    m.enterValueAt(1,0,4);
    m.enterValueAt(1,1,6);
    m.enterValueAt(1,2,1);

    assertEquals(m.findDeterminant(),-14);
  };
};
