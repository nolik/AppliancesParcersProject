package model.appliancesHierarchy.televisors;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 24.10.14.
 */
public abstract class TV extends Appliance {

    private int diagonal;
    private int screenRefreshRate;
    private boolean have3D;
    private boolean haveSmartTV;


    public TV(String manufacturer, String model, int power, EnergyEfficiency energyEfficiency, boolean switched,
              int diagonal, int screenRefreshRate, boolean have3D, boolean haveSmartTV) {
        super(manufacturer, model, power, energyEfficiency, switched);
        this.diagonal = diagonal;
        this.screenRefreshRate = screenRefreshRate;
        this.have3D = have3D;
        this.haveSmartTV = haveSmartTV;
    }


    public int getDiagonal() {
        return diagonal;
    }

    public int getScreenRefreshRate() {
        return screenRefreshRate;
    }


    public boolean isHave3D() {
        return have3D;
    }

    public boolean isHaveSmartTV() {
        return haveSmartTV;
    }

    @Override
    public String toString() {

        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.DIAGONAL)
                .append(":")
                .append(diagonal)
                .append("\"").toString();
    }


}
