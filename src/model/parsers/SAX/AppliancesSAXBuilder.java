package model.parsers.SAX;

import model.appliancesHierarchy.Appliance;
import model.parsers.AbstractAppliancesBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Class-builder for List of Appliances, which used SAX-parser.
 * Before you try to get List of Appliance(getAppliances()) you must be use buildListAppliances().
 */
public class AppliancesSAXBuilder extends AbstractAppliancesBuilder {
    private List<Appliance> appliances;
    private ApplianceHandler ah;
    private XMLReader reader;

    public AppliancesSAXBuilder() {

        try {
            ah = new ApplianceHandler();
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ah);
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    /**
     * Method for building list of Appliances. Method parse XML file and return all Appliances from it.
     * @param fileName XML path.
     * @throws IOException
     */
    public void buildListAppliances(String fileName) throws IOException {
        try {
            reader.parse(fileName);
            appliances = ah.getAppliances();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
