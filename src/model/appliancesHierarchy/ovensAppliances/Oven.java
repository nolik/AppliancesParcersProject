package model.appliancesHierarchy.ovensAppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Oven extends FurnaceAppliances {

    private int maxTemperature;

    public Oven(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass,
                boolean switched, int volume, int mods, int maxTemperature) {
        super(company, modelAppliance, power, efficiencyClass, switched, volume, mods, false);
        this.maxTemperature = maxTemperature;
    }

    public Oven() {
        super();
    }


    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(" ,")
                .append(ProjectConstants.MAX_TEMPERATURE)
                .append(":")
                .append(maxTemperature).toString();
    }
}
