package model.appliancesHierarchy.washings;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public abstract class WashingAppliances extends Appliance {

    private int waterConsumption; //Water consumption per cycle
    private String washingClass;
    private int numberOfPrograms;


    public WashingAppliances(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, int waterConsumption, String washingClass, int numberOfPrograms) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.waterConsumption = waterConsumption;
        this.washingClass = washingClass;
        this.numberOfPrograms = numberOfPrograms;
    }

    public WashingAppliances() {

    }

    public int getWaterConsumption() {
        return waterConsumption;
    }

    public String getWashingClass() {
        return washingClass;
    }

    public int getNumberOfPrograms() {
        return numberOfPrograms;
    }

    public void setWaterConsumption(int waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public void setWashingClass(String washingClass) {
        this.washingClass = washingClass;
    }

    public void setNumberOfPrograms(int numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(ProjectConstants.WATER_CONSUMPTION)
                .append(":")
                .append(waterConsumption)
                .append(ProjectConstants.L_PER_CYCLE)
                .append(", ")
                .append(ProjectConstants.WASHING_CLASS)
                .append(":")
                .append(washingClass)
                .append(", ")
                .append(ProjectConstants.NUMBER_OF_PROGRAMS)
                .append(":")
                .append(numberOfPrograms).toString();
    }
}
