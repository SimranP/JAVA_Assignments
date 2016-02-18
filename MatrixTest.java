import static org.junit.Assert.assertEquals;
import static java.util.Arrays.*;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void enter_values_in_matrix(){
    Matrix m = new Matrix(4,4);
    m.enter(2,2,45);
    m.enter(3,3,99);
    assertEquals(m.get(2,2),45);
    assertEquals(m.get(1,1),0);
    assertEquals(m.get(3,3),99);
  };

  @Test
  public void fill_all_values_at_a_time_in_matrix(){
    Matrix m = new Matrix(2,2);
    int[] a = {1,2,3,4};
    m.fillMatrix(a);
    assertEquals(m.get(0,0),1);
    assertEquals(m.get(0,1),2);
    // assertEquals(m.get(1,0),3);
    assertEquals(m.get(1,1),3);
  }

  @Test
  public void add_two_matrices_2_3(){
    Matrix a = new Matrix(2,3);
    a.enter(0,0,0);
    a.enter(0,1,1);
    a.enter(0,2,2);
    a.enter(1,0,9);
    a.enter(1,1,8);
    a.enter(1,2,7);

    Matrix b = new Matrix(2,3);
    b.enter(0,0,6);
    b.enter(0,1,5);
    b.enter(0,2,4);
    b.enter(1,0,3);
    b.enter(1,1,4);
    b.enter(1,2,5);

    Matrix result = a.add(b);

    assertEquals(result.get(0,0),6);
    assertEquals(result.get(0,1),6);
    assertEquals(result.get(0,2),6);
    assertEquals(result.get(1,0),12);
    assertEquals(result.get(1,1),12);
    assertEquals(result.get(1,2),12);
  };
  @Test
  public void add_two_matrices_1_1(){
    Matrix a = new Matrix(1,1);
    a.enter(0,0,0);

    Matrix b = new Matrix(1,1);
    b.enter(0,0,6);

    Matrix result = a.add(b);

    assertEquals(result.get(0,0),6);
  };
  
}
