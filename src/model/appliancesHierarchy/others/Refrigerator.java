package model.appliancesHierarchy.others;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 2.11.14.
 */
public class Refrigerator extends Appliance {

    private int annualElectroConsumption; //Annual electricity consumption kW/h
    private String construction;
    private int usefulVolume;
    private int deepFreezeVolume = 0;


    protected Refrigerator(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, int AnnualElectroConsumption, String construction, int usefulVolume, int deepFreezeVolume) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.annualElectroConsumption = AnnualElectroConsumption;
        this.construction = construction;
        this.usefulVolume = usefulVolume;
        this.deepFreezeVolume = deepFreezeVolume;
    }

    //constructor for refrigerator without deepFreeze
    protected Refrigerator(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, int AnnualElectroConsumption, String construction, int usefulVolume) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.annualElectroConsumption = AnnualElectroConsumption;
        this.construction = construction;
        this.usefulVolume = usefulVolume;
    }

    public int getAnnualElectroConsumption() {
        return annualElectroConsumption;
    }

    public String getConstruction() {
        return construction;
    }

    public int getUsefulVolume() {
        return usefulVolume;
    }

    public int getDeepFreezeVolume() {
        return deepFreezeVolume;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.ANNUAL_EL_CONSUMPTION)
                .append(":")
                .append(annualElectroConsumption)
                .append(ProjectConstants.KW_PER_HOUR)
                .append(", ")
                .append(ProjectConstants.CONSTRUCTION)
                .append(":")
                .append(construction)
                .append(", ")
                .append(ProjectConstants.USEFUL_VOLUME)
                .append(":")
                .append(usefulVolume)
                .append(ProjectConstants.LITRE)
                .append((deepFreezeVolume != 0) ? ", " + ProjectConstants.DEEP_FREEZE_VOLUME + deepFreezeVolume : "").toString();
    }
}
