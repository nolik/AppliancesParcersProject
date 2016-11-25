package model;

import model.appliancesHierarchy.Appliance;

import java.util.Iterator;
import java.util.List;

/**
 * Class include all business logic operation with model.
 *
 * @author Novik Ihar
 */
public class HomeManager {



    /**
     * Method calculates total used power of all switched appliances.xml.
     *
     * @param home current model
     * @return total used power
     */
    public static int calculateUsedPower(Home home) {
        int totalUsedPower = 0;
        List<Appliance> availableAppliances = home.getAvailableAppliances();
        for (Appliance appliance : availableAppliances) {
            if (appliance.isSwitched()) totalUsedPower += appliance.getPower();
        }
        return totalUsedPower;
    }


    public static int iteratorCalculateUsedPower(Home home) {
        int totalUsedPower = 0;
      Iterator<Appliance> iterator = home.getIterator();
        while (iterator.hasNext()){
           Appliance appliance = iterator.next();
            totalUsedPower+=(appliance.isSwitched()) ? appliance.getPower() : 0;
        }
        return totalUsedPower;
    }

}
