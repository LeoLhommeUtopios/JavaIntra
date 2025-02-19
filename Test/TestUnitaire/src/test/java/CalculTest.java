import org.example.Demo1.Calcul;
import org.example.Demo1.DivideByZeroException;
import org.junit.Assert;
import org.junit.Test;

public class CalculTest {

    private Calcul calcul;

    @Test
    public void WhenAddintion_1_2_Then_3 (){
        //Arrange
        calcul = new Calcul();
        double x = 1;
        double y = 2;

        //Act
         double result = calcul.addition(x,y);

         //Assert
        Assert.assertEquals(3,result,0.0001);
    }

    @Test
    public void WhenDivision_30_10_Then_3(){
        //Arrange
        calcul = new Calcul();
        double x = 30;
        double y = 10;

        //Act
        double result = calcul.division(x,y);

        //Assert
        Assert.assertEquals(3,result,0.01);
    }

    @Test
    public void WhenDivision_10_0_Then_DivideByZeroException (){
        //Arrange
        calcul = new Calcul();
        double x = 10;
        double y = 0;

        //ACt Arrange
        Assert.assertThrows(DivideByZeroException.class,()->{calcul.division(x,y);});
    }


}
