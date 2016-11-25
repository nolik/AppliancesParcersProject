package model.appliancesHierarchy.televisors;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 31.10.14.
 */
public class LcdTV extends TV {

       private String screenResolution;

    public LcdTV(String manufacturer, String model, int power, EnergyEfficiency energyEfficiency, boolean switched, int diagonal,
                 int screenRefreshRate, String screenResolution, boolean have3D, boolean haveSmartTV) {
        super(manufacturer, model, power, energyEfficiency, switched, diagonal, screenRefreshRate, have3D, haveSmartTV);
        this.screenResolution = screenResolution;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    @Override
    public String toString() {
        return new StringBuffer(super.toString())
                .append(", ")
                .append(ProjectConstants.DISPLAY_TECHNOLOGY)
                .append(":")
                .append(ProjectConstants.LCD)
                .append(", ")
                .append(ProjectConstants.SCREEN_RESOLUTION)
                .append(":")
                .append(screenResolution).toString();
    }
}
