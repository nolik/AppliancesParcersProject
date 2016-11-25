package model.appliancesHierarchy.ovensAppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public abstract class FurnaceAppliances extends Appliance {

    private int volumeOfFurnace;
    private int mods;
    private boolean haveGrill;

    public FurnaceAppliances(String company, String modelAppliance, int power,
                             EnergyEfficiency efficiencyClass, boolean switched,
                             int volumeOfFurnace, int mods, boolean haveGrill) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.volumeOfFurnace = volumeOfFurnace;
        this.mods = mods;
        this.haveGrill = haveGrill;
    }

    public FurnaceAppliances() {

    }

    public int getVolumeOfFurnace() {
        return volumeOfFurnace;
    }

    public int getMods() {
        return mods;
    }

    public boolean isHaveGrill() {
        return haveGrill;
    }

    public void setVolumeOfFurnace(int volumeOfFurnace) {
        this.volumeOfFurnace = volumeOfFurnace;
    }

    public void setMods(int mods) {
        this.mods = mods;
    }

    public void setHaveGrill(boolean haveGrill) {
        this.haveGrill = haveGrill;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.NUMBER_OF_MODES)
                .append(":")
                .append(mods)
                .append(", ")
                .append(ProjectConstants.VOLUME)
                .append(":")
                .append(volumeOfFurnace)
                .append(ProjectConstants.LITRE)
                .append((haveGrill) ? ", " + ProjectConstants.HAVE_GRILL : "").toString();
    }


}
