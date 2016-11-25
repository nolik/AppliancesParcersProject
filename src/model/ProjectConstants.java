package model;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by nolik on 5.11.14.
 */
public class ProjectConstants {
    private static Locale locale = new Locale("ru");
    private static ResourceBundle bundle = ResourceBundle.getBundle("text", locale);

    public static final String AVAILABLE_APPLIANCES = bundle.getString("AVAILABLE_APPLIANCES");
    public static final String EXPENDABLE_POWER = bundle.getString("EXPENDABLE_POWER");
    public static final String ENERGY_EFFICIENCY_CLASS =bundle.getString("ENERGY_EFFICIENCY_CLASS");
    public static final String WATT = bundle.getString("WATT");
    public static final String VOLUME =bundle.getString("VOLUME");
    public static final String LITRE = bundle.getString("LITRE");
    public static final String TYPE = bundle.getString("TYPE");
    public static final String PLUG_IN = bundle.getString("PLUG_IN");
    public static final String PLUG_OFF = bundle.getString("PLUG_OFF");
    public static final String MAXIMUM_LOAD_OF_DISHES =  bundle.getString("MAXIMUM_LOAD_OF_DISHES");
    public static final String SETS = bundle.getString("SETS");
    public static final String TYPE_OF_DRYING = bundle.getString("TYPE_OF_DRYING");
    public static final String WATER_CONSUMPTION = bundle.getString("WATER_CONSUMPTION");
    public static final String WASHING_CLASS = bundle.getString("WASHING_CLASS");
    public static final String NUMBER_OF_PROGRAMS = bundle.getString("NUMBER_OF_PROGRAMS");
    public static final String L_PER_CYCLE = bundle.getString("L_PER_CYCLE");
    public static final String MAXIMUM_LOAD = bundle.getString("MAXIMUM_LOAD");
    public static final String KG = bundle.getString("KG");
    public static final String MAXIMUM_SPIN_SPEED = bundle.getString("MAXIMUM_SPIN_SPEED");
    public static final String RPM = bundle.getString("RPM");
    public static final String DIAGONAL = bundle.getString("DIAGONAL");
    public static final String DISPLAY_TECHNOLOGY = bundle.getString("DISPLAY_TECHNOLOGY");
    public static final String SCREEN_RESOLUTION = bundle.getString("SCREEN_RESOLUTION");
    public static final String PLASMA = bundle.getString("PLASMA");
    public static final String CONTRAST = bundle.getString("CONTRAST");
    public static final String OLED=bundle.getString("OLED");
    public static final String LCD = bundle.getString("LCD");
    public static final String KINESCOPE = bundle.getString("KINESCOPE");
    public static final String KINESCOPE_LIFETIME = bundle.getString("KINESCOPE_LIFETIME");
    public static final String NUMBER_OF_MODES = bundle.getString("NUMBER_OF_MODES");
    public static final String HAVE_GRILL = bundle.getString("HAVE_GRILL");
    public static final String POWER_OF_WAVES = bundle.getString("POWER_OF_WAVES");
    public static final String MAX_TEMPERATURE =bundle.getString("MAX_TEMPERATURE");
    public static final String TYPE_CLEANING = bundle.getString("TYPE_CLEANING");
    public static final String SUCTION_POWER = bundle.getString("SUCTION_POWER");
    public static final String RANGE_ACTION = bundle.getString("RANGE_ACTION");
    public static final String ANNUAL_EL_CONSUMPTION = bundle.getString("ANNUAL_EL_CONSUMPTION");
    public static final String KW_PER_HOUR = bundle.getString("KW_PER_HOUR");
    public static final String CONSTRUCTION = bundle.getString("CONSTRUCTION");
    public static final String USEFUL_VOLUME = bundle.getString("USEFUL_VOLUME");
    public static final String DEEP_FREEZE_VOLUME = bundle.getString("DEEP_FREEZE_VOLUME");
    public static final String MAX_HOLD_TEMPERATURE = bundle.getString("MAX_HOLD_TEMPERATURE");
    public static final String SERVICE_AREA =bundle.getString("SERVICE_AREA");
    public static final String CAN_HEAT = bundle.getString("CAN_HEAT");
    public static final String METHOD_OF_HUMIDIFICATION = bundle.getString("METHOD_OF_HUMIDIFICATION");
    public static final String GENERATED_MOISTURE = bundle.getString("GENERATED_MOISTURE");
    public static final String MILLILITRE_PER_HOUR =bundle.getString("MILLILITRE_PER_HOUR");
    public static final String TOTAL_POWER_CONSUMPTION = bundle.getString("TOTAL_POWER_CONSUMPTION");
    public static final String SELECTED_RANGE = bundle.getString("SELECTED_RANGE");
//XML
    public static final String XML_PATH = bundle.getString("XML_PATH");
    public static final String XSD_PATH = bundle.getString("XSD_PATH");
    public static final String XML_STREAM_PROBLEM=bundle.getString("AppliancesStAXBuilder.XML_STREAM_PROBLEM");
    public static final String UNKNOW_ELEMENT=bundle.getString("AppliancesStAXBuilder.UNKNOW_ELEMENT");
    public static final String PARSER_CONFIG_EXCEPTION=bundle.getString("AppliancesDOMBuilder.PARSER_CONFIG_EXCEPTION");
    public static final String SAX_EXP=bundle.getString("AppliancesDOMBuilder.SAX_EXP");


}
