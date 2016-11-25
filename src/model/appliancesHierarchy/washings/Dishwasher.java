package model.appliancesHierarchy.washings;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class Dishwasher extends WashingAppliances {

    private int maxLoadOfDishes; //sets of dishes
    private String typeOfDrying;

    public Dishwasher(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass,
                      boolean switched, int waterConsumption, String washingClass, int numberOfPrograms,
                      int maxLoadOfDishes, String typeOfDrying) {
        super(company, modelAppliance, power, efficiencyClass, switched, waterConsumption, washingClass,
                numberOfPrograms);
        this.maxLoadOfDishes = maxLoadOfDishes;
        this.typeOfDrying = typeOfDrying;
    }

    public Dishwasher() {
        super();
    }

    public int getMaxLoadOfDishes() {
        return maxLoadOfDishes;
    }

    public String getTypeOfDrying() {
        return typeOfDrying;
    }

    public void setMaxLoadOfDishes(int maxLoadOfDishes) {
        this.maxLoadOfDishes = maxLoadOfDishes;
    }

    public void setTypeOfDrying(String typeOfDrying) {
        this.typeOfDrying = typeOfDrying;
    }

    @Override
    public String toString() {
        return new StringBuffer(super.toString())
                .append(ProjectConstants.MAXIMUM_LOAD_OF_DISHES)
                .append(":")
                .append(maxLoadOfDishes)
                .append(ProjectConstants.SETS)
                .append(", ")
                .append(ProjectConstants.TYPE_OF_DRYING)
                .append(":")
                .append(typeOfDrying).toString();
    }
}
