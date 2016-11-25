package model.appliancesHierarchy.others;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 2.11.14.
 */
public class VacuumCleaner extends Appliance {

    private String typeOfCleaning;
    private int suctionPower;
    private int rangeOfAction;


    protected VacuumCleaner(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, String typeOfCleaning, int suctionPower, int rangeOfAction) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.typeOfCleaning = typeOfCleaning;
        this.suctionPower = suctionPower;
        this.rangeOfAction = rangeOfAction;
    }

    public String getTypeOfCleaning() {
        return typeOfCleaning;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public int getRangeOfAction() {
        return rangeOfAction;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(ProjectConstants.TYPE_CLEANING)
                .append(":")
                .append(typeOfCleaning)
                .append(", ")
                .append(ProjectConstants.SUCTION_POWER)
                .append(":")
                .append(suctionPower)
                .append(ProjectConstants.WATT)
                .append(", ")
                .append(ProjectConstants.RANGE_ACTION)
                .append(":")
                .append(rangeOfAction).toString();
    }
}
