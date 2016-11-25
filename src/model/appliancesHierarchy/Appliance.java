package model.appliancesHierarchy;

import model.ProjectConstants;

/**
 * Abstract head of appliance hierarchy. All appliances.xml should be the heir of this class.
 *
 * @author Novik Ihar
 */
public abstract class Appliance implements Switchable {

    private String manufacturer;
    private String model;
    private int power;
    private EnergyEfficiency energyEfficiencyClass;
    private boolean switched = false;

    protected Appliance(String company, String modelAppliance, int power, EnergyEfficiency efficiencyClass,
                        boolean switched) {
        manufacturer = company;
        model = modelAppliance;

        this.power = power;
        energyEfficiencyClass = efficiencyClass;
        this.switched = switched;
    }

    public Appliance() {

    }


    public void switchOn() {
        this.switched = true;
    }

    public void switchOff() {
        this.switched = false;
    }

    public boolean isSwitched() {
        return switched;
    }

    public int getPower() {
        return power;
    }

    public EnergyEfficiency getEnergyEfficiencyClass() {
        return energyEfficiencyClass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }


    @Override
    public String toString() {
        String switched = isSwitched() ? ProjectConstants.PLUG_IN : ProjectConstants.PLUG_OFF;

        return new StringBuffer(this.getClass().getSimpleName())
                .append(" ")
                .append(manufacturer)
                .append(" ")
                .append(model)
                .append(" - ")
                .append(ProjectConstants.EXPENDABLE_POWER)
                .append(":")
                .append(power)
                .append(ProjectConstants.WATT)
                .append(", ")
                .append(ProjectConstants.ENERGY_EFFICIENCY_CLASS)
                .append(":")
                .append(energyEfficiencyClass)
                .append(", ")
                .append(switched).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appliance)) return false;

        Appliance appliance = (Appliance) o;

        if (power != appliance.power) return false;
        if (switched != appliance.switched) return false;
        if (energyEfficiencyClass != appliance.energyEfficiencyClass) return false;
        if (!manufacturer.equals(appliance.manufacturer)) return false;
        if (!model.equals(appliance.model)) return false;

        return true;
    }


    //for serialization to xml

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setEnergyEfficiencyClass(EnergyEfficiency energyEfficiencyClass) {
        this.energyEfficiencyClass = energyEfficiencyClass;
    }

    public void setSwitched(boolean switched) {
        this.switched = switched;
    }
}

