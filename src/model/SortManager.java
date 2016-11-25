package model;

import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class included all sort operation with home.
 */
public class SortManager {
    /**
     * Method for sorting all available appliances.xml in home by expendable power (min power -> max power).
     */
    public static void sortAppliancesByPower(Home home) {
        Collections.sort(home.getCollectionForSort(), new Comparator<Appliance>() {
            @Override
            public int compare(Appliance o1, Appliance o2) {
                return Integer.compare(o1.getPower(), o2.getPower());
            }
        });
    }

    /**
     * Method for sorting all available appliances.xml in home by energy efficiency class (from A ->  G).
     */
    public static void sortAppliancesByEnergyClass(Home home){
        Collections.sort(home.getCollectionForSort(), new Comparator<Appliance>() {
            @Override
            public int compare(Appliance o1, Appliance o2) {
                return Integer.compare(o1.getEnergyEfficiencyClass().ordinal(), o2.getEnergyEfficiencyClass().ordinal());
            }
        });
    }

    /**
     * Method return list of needed appliance from available appliances.xml by power.
     *
     *  @param home current model
     * @param power exact value of power
     * @return list of Appliance satisfying your condition
     */
    public static List<Appliance> getApplianceByPower(Home home, int power) {
        return getApplianceByPower(home,power - 1, power + 1);
    }

    /**
     * Method return list of needed Appliance from available appliances.xml by range of power (not including border) .
     *
     *  @param home current model
     * @param minPower minimum border of power (not including)
     * @param maxPower maximum border of power (not including)
     * @return list of Appliance satisfying your condition
     */
    public static List<Appliance> getApplianceByPower(Home home,int minPower, int maxPower) {
        List<Appliance> availableAppliances = home.getAvailableAppliances();
        List<Appliance> resultAppliances = new ArrayList<>();
        for (Appliance appliance : availableAppliances) {
            if ((appliance.getPower() > minPower) && (appliance.getPower() < maxPower)) {
                resultAppliances.add(appliance);
            }
        }
        return resultAppliances;
    }


    /**
     * Method return list of needed Appliance from available appliances.xml by energy efficiency class (A,B,C...G) .
     *
     *  @param home current model
     * @param energyClass needed energy class
     * @return list of Appliance satisfying your condition
     */
    public static List<Appliance> getApplianceByEnergyClass(Home home,EnergyEfficiency energyClass) {
        List<Appliance> availableAppliances = home.getAvailableAppliances();
        List<Appliance> resultAppliances = new ArrayList<Appliance>();
        for (Appliance appliance : availableAppliances) {
            if (appliance.getEnergyEfficiencyClass().equals(energyClass)){
                resultAppliances.add(appliance);
            }
        }
        return resultAppliances;
    }
}
