package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import Petri.Place;
public class PlaceTest {

    @Test
    public void PlaceTest() {

        Place p = new Place(4);
        Assertions.assertEquals(4, p.get_nb_jetons());
        p.modify_nb_jetons(3);
        Assertions.assertEquals(3, p.get_nb_jetons());
    }


}
