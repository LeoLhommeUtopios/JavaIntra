import org.example.Demo2.Ide;
import org.example.Demo2.Jeu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    private Jeu jeu ;

    private Ide de = Mockito.mock(Ide.class);


    @Test
    public void WhenDeLancerWithValue20_ThenJeuReturnTrue (){
        //Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(20);

        //Act
        boolean result = jeu.jouer();

        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void WhenDeLancerWithValue19_ThenJeuReturnFalse (){
        //Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(19);

        //Act
        boolean result = jeu.jouer();

        //Assert
        Assert.assertFalse(result);
    }

}
