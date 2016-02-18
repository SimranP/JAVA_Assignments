import static org.junit.Assert.assertEquals;
import static java.util.Arrays.*;
import org.junit.Test;

public class MatrixTest{
  @Test
  public void print(){
    Matrix m = new Matrix(4,4);
    m.enter(2,2,45);
    m.enter(3,3,99);
    assertEquals(m.get(2,2),45);
    assertEquals(m.get(1,1),0);
    assertEquals(m.get(3,3),99);
  }
}
