package model;

import model.appliancesHierarchy.Appliance;

import java.util.List;

/**
 * Created by nolik on 3.11.14.
 */
public class SwitchManager {
    /**
     * Method switch off all available appliances.xml in Home.
     *
     *  @param home current model
     */
    public static void switchOffAll(Home home) {
        List<Appliance> availableAppliances = home.getAvailableAppliances();
        for (Appliance appliance : availableAppliances) {
            appliance.switchOff();
        }
    }

    /**
     * Method switch on random available appliances.xml in Home.
     *
     *  @param home current model
     */
    public static void switchOnRandomAppliances(Home home){
        List<Appliance> availableAppliances = home.getAvailableAppliances();
        for (Appliance appliance : availableAppliances) {
            if(Math.random()>=0.5 ) appliance.switchOn();
        }
    }
}
