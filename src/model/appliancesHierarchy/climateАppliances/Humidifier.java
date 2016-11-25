package model.appliancesHierarchy.climateАppliances;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Humidifier extends ClimateAppliances {

    private String method; //method of Humidification
    private int maxMoisture;// Max of generated moisture per hour

    public Humidifier(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass, boolean switched, int serviceArea, String method, int maxMoisture) {
        super(company, modelAppliance, power, efficiencyClass, switched, serviceArea);
        this.method = method;
        this.maxMoisture = maxMoisture;
    }

    public String getMethod() {
        return method;
    }

    public int getMaxMoisture() {
        return maxMoisture;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(ProjectConstants.METHOD_OF_HUMIDIFICATION)
                .append(":")
                .append(method)
                .append(", ")
                .append(ProjectConstants.GENERATED_MOISTURE)
                .append(":")
                .append(maxMoisture)
                .append(ProjectConstants.MILLILITRE_PER_HOUR).toString();
    }
}
