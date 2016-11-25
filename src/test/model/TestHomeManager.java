import model.Home;
import model.HomeCreator;
import model.HomeManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Junit tests for HomeManager.
 */
public class TestHomeManager {

    @Test
    public void testСalculateUsedPower() {
        Home home = HomeCreator.getHome();
        assertEquals("test of used power",700, HomeManager.calculateUsedPower(home));

    }


}
