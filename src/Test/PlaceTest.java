package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Exception.ImpossibleAction;
import Petri.Place;
public class PlaceTest {

    @Test
    public void PlaceTest() throws ImpossibleAction{

        Place p = new Place(4);
        Assertions.assertEquals(4, p.get_nb_jetons());
        p.modify_nb_jetons(3);
        Assertions.assertEquals(3, p.get_nb_jetons());
        
        ImpossibleAction exception = Assertions.assertThrows(ImpossibleAction.class,()->{Place p2 = new Place(-3);});
        Assertions.assertEquals(exception.getMessage(),"nb_jetons can't be negative");
    }
    
    // we could also make a test of get_nb_jetons and modify_nb_jetons but it seems to work here 


}
