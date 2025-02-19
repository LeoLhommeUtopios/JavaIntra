import jdk.jshell.spi.ExecutionControl;
import org.example.Demo3.LeapTester;
import org.junit.Assert;
import org.junit.Test;

public class LeapTesterTest {

    private LeapTester leapTester;

    @Test
    public void year400IsLeap_ThenResultShouldBetrue (){
        //Arrange
        leapTester = new LeapTester();
        //Act
        boolean res = leapTester.isLeap(400);
        //Assert
        Assert.assertTrue(res);
    }

    @Test
    public void year404IsLeap_ThenResultShouldBeTrue (){
        //Arrange
        leapTester = new LeapTester();
        //Act
        boolean res = leapTester.isLeap(404);
        //Assert
        Assert.assertTrue(res);
    }

    @Test
    public void year4000IsNotLeap_ThenShouldBeFalse (){
        //Arrange
        leapTester = new LeapTester();
        //Act
        boolean res = leapTester.isLeap(4000);
        //Assert
        Assert.assertFalse(res);
    }
}
