package model.parsers.DOM;

import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;
import model.appliancesHierarchy.climateАppliances.ClimateAppliances;
import model.appliancesHierarchy.climateАppliances.Conditioner;
import model.appliancesHierarchy.kettles.Kettle;
import model.appliancesHierarchy.kettles.Termopot;
import model.parsers.ApplianceEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for parsing xml with DOM.
 */
public class DOMParser {

    public static void main(String[] args) throws Exception {
        //Get the DOM Builder Factory
        List<Appliance> applianceList = new ArrayList<>();

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        new File("/home/nolik/IdeaProjects/forEpam/task1/Appliances/src/appliances.xml"));



        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            //We have encountered an <NameOFClass> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Appliance appliance = null;

                switch (ApplianceEnum.valueOf(node.getNodeName().toUpperCase())) {
                    case KETTLE:
                        appliance = new Kettle();
                        break;
                    case TERMOPOT:
                        appliance = new Termopot();
                        break;
                    case CONDITIONER:
                        appliance = new Conditioner();
                }

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().getTextContent().trim();
                        //initialize appliance
                        switch (ApplianceEnum.valueOf(cNode.getNodeName().toUpperCase())) {
                            case ENERGY_EFFICIENCY_CLASS:
                                appliance.setEnergyEfficiencyClass(EnergyEfficiency.valueOf(content));
                                break;
                            case MANUFACTURER:
                                appliance.setManufacturer(content);
                                break;
                            case MODEL:
                                appliance.setModel(content);
                                break;
                            case POWER:
                                appliance.setPower(Integer.parseInt(content));
                                break;
                            case SWITCHED:
                                appliance.setSwitched(Boolean.parseBoolean(content));
                                break;

                            case VOLUME:
                                if (appliance instanceof Kettle) {
                                    ((Kettle) appliance).setVolume(Integer.parseInt(content));
                                }
                                break;
                            case MAX_HOLDING_TEMPERATURE:
                                if (appliance instanceof Termopot) {
                                    ((Termopot) appliance).setMaxHoldingTemperature(Integer.parseInt(content));
                                }
                                break;
                            case SERVICE_AREA:
                                if (appliance instanceof ClimateAppliances) {
                                    ((ClimateAppliances) appliance).setServiceArea(Integer.parseInt(content));
                                }
                                break;
                            case TYPE:
                                if (appliance instanceof Conditioner) {
                                    ((Conditioner) appliance).setType(content);
                                }
                                break;
                            case HEATING:
                                if (appliance instanceof Conditioner) {
                                    ((Conditioner) appliance).setHeating(Boolean.parseBoolean(content));
                                }
                                break;
                        }


                    }

                }
                applianceList.add(appliance);
            }

        }


        //to console
        for (Appliance x : applianceList) {
            System.out.println(x.toString());
        }

    }

}
