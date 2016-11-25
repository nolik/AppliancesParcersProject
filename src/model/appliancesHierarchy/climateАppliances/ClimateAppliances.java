package model.appliancesHierarchy.climateАppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public abstract class ClimateAppliances extends Appliance {

    private int serviceArea;

    public ClimateAppliances(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass,
                             boolean switched, int serviceArea) {
        super(company, modelAppliance, power, efficiencyClass, switched);
        this.serviceArea = serviceArea;
    }

    public ClimateAppliances() {

    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.SERVICE_AREA)
                .append(":")
                .append(serviceArea).toString();
    }
}
