package Test;
import Cheat.BasicCheat;
import org.junit.*;
/**
 *
 * @author Didac
 */
public class BasicCheatTest {
    BasicCheat bc;
    
    @Before
    public void createCheatGame(){
        bc = new BasicCheat();
    }
    
    @Test
    public void initialise(){
        bc.initialise();
    }
}
