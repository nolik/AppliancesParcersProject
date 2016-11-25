package model.appliancesHierarchy.televisors;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 1.11.14.
 */
public class CrtTV extends TV {

    private int tubeLifeTime;

    public CrtTV(String manufacturer, String model, int power, EnergyEfficiency energyEfficiency, boolean switched, int diagonal,
                 int screenRefreshRate, int tubeLifeTime) {
        super(manufacturer, model, power, energyEfficiency, switched, diagonal, screenRefreshRate, false, false);
        this.tubeLifeTime = tubeLifeTime;

    }

    public int getTubeLifeTime() {
        return tubeLifeTime;
    }

    @Override
    public String toString() {
        return new StringBuffer(super.toString())
                .append(", ")
                .append(ProjectConstants.DISPLAY_TECHNOLOGY)
                .append(":")
                .append(ProjectConstants.KINESCOPE)
                .append(", ")
                .append(ProjectConstants.KINESCOPE_LIFETIME)
                .append(":")
                .append(tubeLifeTime).toString();
    }
}
