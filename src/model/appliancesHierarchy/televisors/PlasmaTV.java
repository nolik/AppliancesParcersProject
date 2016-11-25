package model.appliancesHierarchy.televisors;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

/**
 * Created by nolik on 31.10.14.
 */
public class PlasmaTV extends TV {

    private String screenResolution;
    private int contrast;


    public PlasmaTV(String manufacturer, String model, int power, EnergyEfficiency energyEfficiency, boolean switched, int diagonal,
                    int screenRefreshRate, boolean have3D, boolean haveSmartTV, String screenResolution, int contrast) {
        super(manufacturer, model, power, energyEfficiency, switched, diagonal, screenRefreshRate, have3D, haveSmartTV);
        this.screenResolution = screenResolution;
        this.contrast = contrast;
    }



    public String getScreenResolution() {
        return screenResolution;
    }

    public int getContrast() {
        return contrast;
    }

    @Override
    public String toString() {
        return new StringBuffer(super.toString())
                .append(", ")
                .append(ProjectConstants.DISPLAY_TECHNOLOGY)
                .append(":")
                .append(ProjectConstants.PLASMA)
                .append(", ")
                .append(ProjectConstants.SCREEN_RESOLUTION)
                .append(":")
                .append(screenResolution)
                .append(", ")
                .append(ProjectConstants.CONTRAST)
                .append(":")
                .append(contrast).toString();
    }
}
