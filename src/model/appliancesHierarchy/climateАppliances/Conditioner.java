package model.appliancesHierarchy.climateАppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Conditioner extends ClimateAppliances {

    private String type;
    private boolean heating;


    public Conditioner(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass,
                       boolean switched, int serviceArea, String type, boolean heating) {
        super(company, modelAppliance, power, efficiencyClass, switched, serviceArea);
        this.type = type;
        this.heating = heating;
    }

    public Conditioner() {
        super();
    }

    public String getType() {
        return type;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.TYPE)
                .append(":")
                .append(type)
                .append((heating) ? ", " + ProjectConstants.CAN_HEAT : "").toString();
    }
}
