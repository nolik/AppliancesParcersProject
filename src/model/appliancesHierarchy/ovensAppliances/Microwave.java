package model.appliancesHierarchy.ovensAppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Microwave extends FurnaceAppliances {

    private int powerWaves;

    public Microwave(String company, String modelAppliance, int power,
                     EnergyEfficiency efficiencyClass, boolean switched, int volume,
                     int mods, boolean haveGrill, int powerWaves) {
        super(company, modelAppliance, power, efficiencyClass, switched, volume, mods, haveGrill);
        this.powerWaves = powerWaves;
    }

    public Microwave() {

    }

    public int getPowerWaves() {
        return powerWaves;
    }

    public void setPowerWaves(int powerWaves) {
        this.powerWaves = powerWaves;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.POWER_OF_WAVES)
                .append(":")
                .append(powerWaves)
                .append(ProjectConstants.WATT)
                .toString();
    }
}
