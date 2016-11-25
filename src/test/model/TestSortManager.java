import model.Home;
import model.SortManager;
import model.appliancesHierarchy.EnergyEfficiency;
import model.appliancesHierarchy.climateАppliances.Conditioner;
import model.appliancesHierarchy.kettles.Kettle;
import model.appliancesHierarchy.kettles.Termopot;
import model.appliancesHierarchy.televisors.LcdTV;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Junit tests for SortManager.
 */
public class TestSortManager {
    static Home home;
    Home expectedHome;


    @BeforeClass
public static void createHome(){
     home = new Home();
    home.addAppliance(new Conditioner("LG", "ZX-330", 200, EnergyEfficiency.A, true, 200, "external", true));
    home.addAppliance(new Kettle("Bosh", "Crater", 250, EnergyEfficiency.B, true, 2));
    home.addAppliance(new Termopot("Bosh", "Crater", 250, EnergyEfficiency.A, true, 2, 100));
    home.addAppliance(new LcdTV("Samsung", "LX220", 150, EnergyEfficiency.C, false, 40, 80, "1960x1830", false, false));
}

    @Test
    public void testGetApplianceByEnergyClass() {


        Home expectedHome = new Home();
        expectedHome.addAppliance(new Conditioner("LG", "ZX-330", 200, EnergyEfficiency.A, true, 200, "external", true));
        expectedHome.addAppliance(new Termopot("Bosh", "Crater", 250, EnergyEfficiency.A, true, 2, 100));

        assertArrayEquals(expectedHome.getAvailableAppliances().toArray(),
                SortManager.getApplianceByEnergyClass(home, EnergyEfficiency.A).toArray());
    }

    @Test
    public void testSortAppliancesByPower() {

        expectedHome = new Home();
        expectedHome.addAppliance(new LcdTV("Samsung", "LX220", 150, EnergyEfficiency.C,
                false, 40, 80, "1960x1830", false, false));
        expectedHome.addAppliance(new Conditioner("LG", "ZX-330", 200, EnergyEfficiency.A, true, 200, "external", true));
        expectedHome.addAppliance(new Kettle("Bosh", "Crater", 250, EnergyEfficiency.B, true, 2));
        expectedHome.addAppliance(new Termopot("Bosh", "Crater", 250, EnergyEfficiency.A, true, 2, 100));

        SortManager.sortAppliancesByPower(home);
        assertArrayEquals(expectedHome.getAvailableAppliances().toArray(), home.getAvailableAppliances().toArray());
    }


}


