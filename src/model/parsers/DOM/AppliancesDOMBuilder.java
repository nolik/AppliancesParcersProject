package model.parsers.DOM;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class-builder for List of Appliances, which used DOM-parser.
 * Before you try to get List of Appliance(getAppliances()) you must be use buildListAppliances().
 */
public class AppliancesDOMBuilder extends AbstractAppliancesBuilder {
    static Logger logger = Logger.getLogger(AppliancesDOMBuilder.class);
    private DocumentBuilder docBuilder;
    private List<Appliance> appliances;

    public AppliancesDOMBuilder() {
        try {
            appliances = new LinkedList<>();
            //Get the DOM Builder Factory
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            //settings of validating


            //Get the DOM Builder
            docBuilder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            logger.error(ProjectConstants.PARSER_CONFIG_EXCEPTION, e);
        }
    }

    /**
     * Method returned List of Appliance.
     *
     * @return List of Appliance.
     */
    public List<Appliance> getAppliances() {
        return appliances;
    }

    /**
     * Method initialise list of Appliance by Appliances from XML.
     *
     * @param fileName XML path.
     * @throws IOException
     */
    public void buildListAppliances(String fileName) throws IOException {
        Document doc = null;

        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            //Iterating through the nodes and extracting the data.
            NodeList nodeList = root.getChildNodes();


            for (int i = 0; i < nodeList.getLength(); i++) {
                //We have encountered an <NameOFClass> tag.
                Node node = nodeList.item(i);

                if (node instanceof Element) {
                    Appliance appliance = buildAppliance(node);
                    appliances.add(appliance);
                }
            }


        } catch (SAXException e) {
            logger.error(ProjectConstants.SAX_EXP, e);
        }

    }

    /**
     * Method build Appliance by node and initialise him.
     *
     * @param node current Node.
     * @return Appliance.
     */
    private Appliance buildAppliance(Node node) {
        Appliance currentAppliance;
        switch (ApplianceEnum.valueOf(node.getNodeName().toUpperCase())) {
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

            default:
                return null;
        }

        NodeList childNodes = node.getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            Node cNode = childNodes.item(j);

            //Identifying the child tag of parameters encountered.
            if (cNode instanceof Element) {
                String content = cNode.getLastChild().getTextContent().trim();
                //initialize currentAppliance
                switch (ApplianceEnum.valueOf(cNode.getNodeName().toUpperCase())) {
                    case ENERGY_EFFICIENCY_CLASS:
                        currentAppliance.setEnergyEfficiencyClass(EnergyEfficiency.valueOf(content));
                        break;
                    case MANUFACTURER:
                        currentAppliance.setManufacturer(content);
                        break;
                    case MODEL:
                        currentAppliance.setModel(content);
                        break;
                    case POWER:
                        currentAppliance.setPower(Integer.parseInt(content));
                        break;
                    case SWITCHED:
                        currentAppliance.setSwitched(Boolean.parseBoolean(content));
                        break;

                    case VOLUME:
                        if (currentAppliance instanceof Kettle) {
                            ((Kettle) currentAppliance).setVolume(Integer.parseInt(content));
                        }
                        break;
                    case MAX_HOLDING_TEMPERATURE:
                        if (currentAppliance instanceof Termopot) {
                            ((Termopot) currentAppliance).setMaxHoldingTemperature(Integer.parseInt(content));
                        }
                        break;
                    case SERVICE_AREA:
                        if (currentAppliance instanceof ClimateAppliances) {
                            ((ClimateAppliances) currentAppliance).setServiceArea(Integer.parseInt(content));
                        }
                        break;
                    case TYPE:
                        if (currentAppliance instanceof Conditioner) {
                            ((Conditioner) currentAppliance).setType(content);
                        }
                        break;
                    case HEATING:
                        if (currentAppliance instanceof Conditioner) {
                            ((Conditioner) currentAppliance).setHeating(Boolean.parseBoolean(content));
                        }
                        break;

                    //new Furnace
                    case VOLUME_OF_FURNACE:
                        if (currentAppliance instanceof FurnaceAppliances) {
                            ((FurnaceAppliances) currentAppliance).setVolumeOfFurnace(Integer.parseInt(content));
                        }
                        break;
                    case MODS:
                        if (currentAppliance instanceof FurnaceAppliances) {
                            ((FurnaceAppliances) currentAppliance).setMods(Integer.parseInt(content));
                        }
                        break;
                    case HAVE_GRILL:
                        if (currentAppliance instanceof FurnaceAppliances) {
                            ((FurnaceAppliances) currentAppliance).setHaveGrill(Boolean.parseBoolean(content));
                        }
                        break;
                    //FOR MICROWAVE
                    case POWER_WAVES:
                        if (currentAppliance instanceof Microwave) {
                            ((Microwave) currentAppliance).setPowerWaves(Integer.parseInt(content));
                        }
                        break;
                    //FOR OVEN
                    case MAX_TEMPERATURE:
                        if (currentAppliance instanceof Oven) {
                            ((Oven) currentAppliance).setMaxTemperature(Integer.parseInt(content));
                        }
                        break;
                    //FOR WASHING APPLIANCES
                    case WATER_CONSUMPTION:
                        if (currentAppliance instanceof WashingAppliances) {
                            ((WashingAppliances) currentAppliance).setWaterConsumption(Integer.parseInt(content));
                        }
                        break;
                    case WASHING_CLASS:
                        if (currentAppliance instanceof WashingAppliances) {
                            ((WashingAppliances) currentAppliance).setWashingClass(content);
                        }
                        break;
                    case NUMBER_OF_PROGRAMS:
                        if (currentAppliance instanceof WashingAppliances) {
                            ((WashingAppliances) currentAppliance).setNumberOfPrograms(Integer.parseInt(content));
                        }
                        break;
                    //FOR DISHWASHER
                    case MAX_LOAD_OF_DISHES:
                        if (currentAppliance instanceof Dishwasher) {
                            ((Dishwasher) currentAppliance).setMaxLoadOfDishes(Integer.parseInt(content));
                        }
                        break;
                    case TYPE_OF_DRYING:
                        if (currentAppliance instanceof Dishwasher) {
                            ((Dishwasher) currentAppliance).setTypeOfDrying(content);
                        }
                        break;
                    //FOR WASHING_MACHINE
                    case MAX_LOAD:
                        if (currentAppliance instanceof WashingMachine) {
                            ((WashingMachine) currentAppliance).setMaxLoad(Integer.parseInt(content));
                        }
                        break;
                    case MAX_SPIN_SPEED:
                        if (currentAppliance instanceof WashingMachine) {
                            ((WashingMachine) currentAppliance).setMaxSpinSpeed(Integer.parseInt(content));
                        }
                        break;


                }


            }

        }
        return currentAppliance;
    }
}
