package model.parsers.StAX;

import model.ProjectConstants;
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
import model.parsers.AbstractAppliancesBuilder;
import model.parsers.ApplianceEnum;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Class-builder for List of Appliances, which used StAX-parser.
 * Before you try to get List of Appliance(getAppliances()) you must be use buildListAppliances().
 */
public class AppliancesStAXBuilder extends AbstractAppliancesBuilder {

    static Logger logger = Logger.getLogger(AppliancesStAXBuilder.class);
    private List<Appliance> appliances;
    private XMLInputFactory inputFactory;

    private final EnumSet<ApplianceEnum> classesEnums;


    public AppliancesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        classesEnums = EnumSet.range(ApplianceEnum.KETTLE, ApplianceEnum.CONDITIONER); //all current class
        appliances = new LinkedList<>();
    }

    /**
     * Method returned List of Appliance.
     * @return List of Appliance.
     */
    public List<Appliance> getAppliances() {
        return appliances;
    }

 /**
     * Method initialise list of Appliance by Appliances from XML.
     * @param fileName XML path.
     * @throws IOException
     */
    public void buildListAppliances(String fileName) throws IOException {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    ApplianceEnum applianceEnum = ApplianceEnum.valueOf(name.toUpperCase());

                    //if ELEMENT => it's one of Appliances we bulid new Appliances
                    if (classesEnums.contains(applianceEnum)) {
                        //      System.out.println("Creating appliances with " + name + "ENUM="+ applianceEnum);
                        Appliance appliance = buildAppliance(reader, applianceEnum);
                        appliances.add(appliance);
                    }
                }

            }
        } catch (XMLStreamException e) {
            logger.error(ProjectConstants.XML_STREAM_PROBLEM, e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * Method build Appliance by node and initialise him.
     * @param reader XMLStreamReader
     * @param applianceEnum enum of available tags.
     * @return current Appliance.
     * @throws XMLStreamException
     */
    private Appliance buildAppliance(XMLStreamReader reader, ApplianceEnum applianceEnum) throws XMLStreamException {
        Appliance currentAppliance = null;
        switch (applianceEnum) {
            case KETTLE:
                currentAppliance = new Kettle();
                break;
            case TERMOPOT:
                currentAppliance = new Termopot();
                break;
            case CONDITIONER:
                currentAppliance = new Conditioner();
                break;
            case MICROWAVE:
                currentAppliance = new Microwave();
                break;
            case OVEN:
                currentAppliance = new Oven();
                break;
            case DISHWASHER:
                currentAppliance = new Dishwasher();
                break;
            case WASHING_MACHINE:
                currentAppliance = new WashingMachine();
                break;
        }

        String content;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:

                    content = reader.getLocalName();

                    switch (ApplianceEnum.valueOf(content.toUpperCase())) {
                        case ENERGY_EFFICIENCY_CLASS:
                            currentAppliance.setEnergyEfficiencyClass(EnergyEfficiency.valueOf(getXMLText(reader)));
                            break;
                        case MANUFACTURER:
                            currentAppliance.setManufacturer(getXMLText(reader));
                            break;
                        case MODEL:
                            currentAppliance.setModel(getXMLText(reader));
                            break;
                        case POWER:
                            currentAppliance.setPower(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SWITCHED:
                            currentAppliance.setSwitched(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case VOLUME:
                            if (currentAppliance instanceof Kettle) {
                                ((Kettle) currentAppliance).setVolume(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case MAX_HOLDING_TEMPERATURE:
                            if (currentAppliance instanceof Termopot) {
                                ((Termopot) currentAppliance).setMaxHoldingTemperature(Integer.parseInt(getXMLText(reader)));
                            }
                            break;

                        case SERVICE_AREA:
                            if (currentAppliance instanceof ClimateAppliances) {
                                ((ClimateAppliances) currentAppliance).setServiceArea(Integer.parseInt(getXMLText(reader)));
                            }
                            break;

                        case TYPE:
                            if (currentAppliance instanceof Conditioner) {
                                ((Conditioner) currentAppliance).setType(getXMLText(reader));
                            }
                            break;

                        case HEATING:
                            if (currentAppliance instanceof Conditioner) {
                                ((Conditioner) currentAppliance).setHeating(Boolean.parseBoolean(getXMLText(reader)));
                            }
                            break;
                        //new Furnace
                        case VOLUME_OF_FURNACE:
                            if(currentAppliance instanceof FurnaceAppliances){

                                ((FurnaceAppliances) currentAppliance).setVolumeOfFurnace(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case MODS:
                            if(currentAppliance instanceof FurnaceAppliances){
                                ((FurnaceAppliances) currentAppliance).setMods(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case HAVE_GRILL:
                            if(currentAppliance instanceof FurnaceAppliances){
                                ((FurnaceAppliances) currentAppliance).setHaveGrill(Boolean.parseBoolean(getXMLText(reader)));
                            }
                            break;
                        //FOR MICROWAVE
                        case POWER_WAVES:
                            if(currentAppliance instanceof Microwave){
                                ((Microwave) currentAppliance).setPowerWaves(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        //FOR OVEN
                        case MAX_TEMPERATURE:
                            if(currentAppliance instanceof Oven){
                                ((Oven) currentAppliance).setMaxTemperature(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        //FOR WASHING APPLIANCES
                        case WATER_CONSUMPTION:
                            if (currentAppliance instanceof WashingAppliances) {
                                ((WashingAppliances) currentAppliance).setWaterConsumption(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case WASHING_CLASS:
                            if (currentAppliance instanceof WashingAppliances) {
                                ((WashingAppliances) currentAppliance).setWashingClass(getXMLText(reader));
                            }
                            break;
                        case NUMBER_OF_PROGRAMS:
                            if (currentAppliance instanceof WashingAppliances) {
                                ((WashingAppliances) currentAppliance).setNumberOfPrograms(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        //FOR DISHWASHER
                        case MAX_LOAD_OF_DISHES:
                            if (currentAppliance instanceof Dishwasher) {
                                ((Dishwasher) currentAppliance).setMaxLoadOfDishes(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case TYPE_OF_DRYING:
                            if (currentAppliance instanceof Dishwasher) {
                                ((Dishwasher) currentAppliance).setTypeOfDrying(getXMLText(reader));
                            }
                            break;
                        //FOR WASHING_MACHINE
                        case MAX_LOAD:
                            if (currentAppliance instanceof WashingMachine) {
                                ((WashingMachine) currentAppliance).setMaxLoad(Integer.parseInt(getXMLText(reader)));
                            }
                            break;
                        case MAX_SPIN_SPEED:
                            if (currentAppliance instanceof WashingMachine) {
                                ((WashingMachine) currentAppliance).setMaxSpinSpeed(Integer.parseInt(getXMLText(reader)));
                            }
                            break;

                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    content = reader.getLocalName();
                    if (classesEnums.contains(ApplianceEnum.valueOf(content.toUpperCase()))) {
                        return currentAppliance;
                    }
                    break;
            }

        }

        throw new XMLStreamException(ProjectConstants.UNKNOW_ELEMENT);
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }


}

