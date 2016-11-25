package model.appliancesHierarchy.climateАppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Heater extends ClimateAppliances{

    private String typeOfHeat;
    private int numberOfModes;


    public Heater(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, int serviceArea, String typeOfHeat, int numberOfModes) {
        super(company, modelAppliance, power, efficiencyClass, switched, serviceArea);
        this.typeOfHeat = typeOfHeat;
        this.numberOfModes = numberOfModes;
    }

    public String getTypeOfHeat() {
        return typeOfHeat;
    }

    public int getNumberOfModes() {
        return numberOfModes;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(ProjectConstants.TYPE)
                .append(":")
                .append(typeOfHeat)
                .append(ProjectConstants.NUMBER_OF_MODES)
                .append(" :")
                .append(numberOfModes).toString();
    }
}
