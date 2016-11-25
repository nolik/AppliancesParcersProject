package model.parsers.SAX;

import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;
import model.appliancesHierarchy.climateАppliances.ClimateAppliances;
import model.appliancesHierarchy.climateАppliances.Conditioner;
import model.appliancesHierarchy.kettles.Kettle;
import model.appliancesHierarchy.kettles.Termopot;
import model.appliancesHierarchy.ovensAppliances.FurnaceAppliances;
import model.appliancesHierarchy.ovensAppliances.Microwave;
import model.appliancesHierarchy.ovensAppliances.Oven;
import model.appliancesHierarchy.washings.Dishwasher;
import model.appliancesHierarchy.washings.WashingAppliances;
import model.appliancesHierarchy.washings.WashingMachine;
import model.parsers.ApplianceEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;


/**
 * Class-handler for SAX-parser.
 */
public class ApplianceHandler extends DefaultHandler {
    private List<Appliance> appliances;
    private Appliance current;
    private ApplianceEnum currentEnum = null;
    private EnumSet<ApplianceEnum> parameters;
    private EnumSet<ApplianceEnum> classesEnums;


    public ApplianceHandler() {
        appliances = new LinkedList<>();
        classesEnums = EnumSet.range(ApplianceEnum.APPLIANCES, ApplianceEnum.CONDITIONER);
        parameters = EnumSet.range(ApplianceEnum.ENERGY_EFFICIENCY_CLASS, ApplianceEnum.HEATING);
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        ApplianceEnum applianceEnum = ApplianceEnum.valueOf(localName.toUpperCase());

        if (classesEnums.contains(applianceEnum)) {
            switch (applianceEnum) {
                case KETTLE:
                    current = new Kettle();
                    break;
                case TERMOPOT:
                    current = new Termopot();
                    break;
                case CONDITIONER:
                    current = new Conditioner();
                    break;
                case MICROWAVE:
                    current = new Microwave();
                    break;
                case OVEN:
                    current = new Oven();
                    break;
                case DISHWASHER:
                    current = new Dishwasher();
                    break;
                case WASHING_MACHINE:
                    current = new WashingMachine();
                    break;
            }
        } else {
            currentEnum = applianceEnum;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        ApplianceEnum applianceEnum = ApplianceEnum.valueOf(localName.toUpperCase());

        if (classesEnums.contains(applianceEnum)) {
            if (applianceEnum != ApplianceEnum.APPLIANCES) {
                appliances.add(current);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim(); //current text element for setting
        if (currentEnum != null) {
            switch (currentEnum) {
                case ENERGY_EFFICIENCY_CLASS:
                    current.setEnergyEfficiencyClass(EnergyEfficiency.valueOf(content));
                    break;
                case MANUFACTURER:
                    current.setManufacturer(content);
                    break;
                case MODEL:
                    current.setModel(content);
                    break;
                case POWER:
                    current.setPower(Integer.parseInt(content));
                    break;
                case SWITCHED:
                    current.setSwitched(Boolean.parseBoolean(content));
                    break;

                case VOLUME:
                    if (current instanceof Kettle) {
                        ((Kettle) current).setVolume(Integer.parseInt(content));
                    }
                    break;
                case MAX_HOLDING_TEMPERATURE:
                    if (current instanceof Termopot) {
                        ((Termopot) current).setMaxHoldingTemperature(Integer.parseInt(content));
                    }
                    break;
                case SERVICE_AREA:
                    if (current instanceof ClimateAppliances) {
                        ((ClimateAppliances) current).setServiceArea(Integer.parseInt(content));
                    }
                    break;
                case TYPE:
                    if (current instanceof Conditioner) {
                        ((Conditioner) current).setType(content);
                    }
                    break;
                case HEATING:
                    if (current instanceof Conditioner) {
                        ((Conditioner) current).setHeating(Boolean.parseBoolean(content));
                    }
                    break;
                //new Furnace
                case VOLUME_OF_FURNACE:
                    if (current instanceof FurnaceAppliances) {
                        ((FurnaceAppliances) current).setVolumeOfFurnace(Integer.parseInt(content));
                    }
                    break;
                case MODS:
                    if (current instanceof FurnaceAppliances) {
                        ((FurnaceAppliances) current).setMods(Integer.parseInt(content));
                    }
                    break;
                case HAVE_GRILL:
                    if (current instanceof FurnaceAppliances) {
                        ((FurnaceAppliances) current).setHaveGrill(Boolean.parseBoolean(content));
                    }
                    break;
                //FOR MICROWAVE
                case POWER_WAVES:
                    if (current instanceof Microwave) {
                        ((Microwave) current).setPowerWaves(Integer.parseInt(content));
                    }
                    break;
                //FOR OVEN
                case MAX_TEMPERATURE:
                    if (current instanceof Oven) {
                        ((Oven) current).setMaxTemperature(Integer.parseInt(content));
                    }
                    break;
                //FOR WASHING APPLIANCES
                case WATER_CONSUMPTION:
                    if (current instanceof WashingAppliances) {
                        ((WashingAppliances) current).setWaterConsumption(Integer.parseInt(content));
                    }
                    break;
                case WASHING_CLASS:
                    if (current instanceof WashingAppliances) {
                        ((WashingAppliances) current).setWashingClass(content);
                    }
                    break;
                case NUMBER_OF_PROGRAMS:
                    if (current instanceof WashingAppliances) {
                        ((WashingAppliances) current).setNumberOfPrograms(Integer.parseInt(content));
                    }
                    break;
                //FOR DISHWASHER
                case MAX_LOAD_OF_DISHES:
                    if (current instanceof Dishwasher) {
                        ((Dishwasher) current).setMaxLoadOfDishes(Integer.parseInt(content));
                    }
                    break;
                case TYPE_OF_DRYING:
                    if (current instanceof Dishwasher) {
                        ((Dishwasher) current).setTypeOfDrying(content);
                    }
                    break;
                //FOR WASHING_MACHINE
                case MAX_LOAD:
                    if (current instanceof WashingMachine) {
                        ((WashingMachine) current).setMaxLoad(Integer.parseInt(content));
                    }
                    break;
                case MAX_SPIN_SPEED:
                    if (current instanceof WashingMachine) {
                        ((WashingMachine) current).setMaxSpinSpeed(Integer.parseInt(content));
                    }
                    break;


                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
