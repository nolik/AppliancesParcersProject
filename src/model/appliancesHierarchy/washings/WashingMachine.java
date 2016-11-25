package model.appliancesHierarchy.washings;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class WashingMachine extends WashingAppliances {



    private int maxLoad;
    private int maxSpinSpeed;

    public WashingMachine(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched,
                          int waterConsumption, String washingClass, int numberOfPrograms, int maxLoad, int maxSpinSpeed) {
        super(company, modelAppliance, power, efficiencyClass, switched, waterConsumption, washingClass, numberOfPrograms);
        this.maxLoad = maxLoad;
        this.maxSpinSpeed = maxSpinSpeed;
    }

    public WashingMachine() {

    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public int getMaxSpinSpeed() {
        return maxSpinSpeed;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public void setMaxSpinSpeed(int maxSpinSpeed) {
        this.maxSpinSpeed = maxSpinSpeed;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(ProjectConstants.MAXIMUM_LOAD + ":")
                .append(maxLoad)
                .append(ProjectConstants.KG)
                .append(", ")
                .append(ProjectConstants.MAXIMUM_SPIN_SPEED)
                .append(":")
                .append(maxSpinSpeed)
                .append(ProjectConstants.RPM).toString();
    }

}
