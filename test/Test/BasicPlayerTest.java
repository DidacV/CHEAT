package Test;

import Cheat.BasicCheat;
import Cheat.BasicStrategy;
import org.junit.*;

/**
 *
 * @author Didac
 */
public class BasicPlayerTest {
    BasicPlayerTest player;
    BasicStrategy bs;
    BasicCheat bc;
    
    @Before
    public void createPlayer(){
        bs = new BasicStrategy();
        bc = new BasicCheat();
        player = new BasicPlayerTest();
    }
    
    @Test
    public void addCard(){
        System.out.println(player.bc);
    }
}
