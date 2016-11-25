package model;

import model.appliancesHierarchy.EnergyEfficiency;
import model.appliancesHierarchy.climateАppliances.Conditioner;
import model.appliancesHierarchy.kettles.Kettle;
import model.appliancesHierarchy.kettles.Termopot;
import model.appliancesHierarchy.televisors.LcdTV;
import model.parsers.AbstractAppliancesBuilder;
import model.parsers.ApplianceBuilderFactory;
import model.parsers.Validator;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Class provides method for creating and initializing Home.
 *
 * @author Novik Ihar
 */
public class HomeCreator {

    //later change this class for import from FIle or DB ! make different class including interface Retrievable -> (retrieve elements());

    /**
     * Method for creating Home.
     *
     * @return Home
     */
    public static Home getHome() {

        Home home = new Home();
        home.addAppliance(new Conditioner("LG", "ZX-330", 200, EnergyEfficiency.A, true, 200, "external", true));
        home.addAppliance(new Kettle("Bosh", "Crater", 250, EnergyEfficiency.B, true, 2));
        home.addAppliance(new Termopot("Bosh", "Crater", 250, EnergyEfficiency.A, true, 2, 100));
        home.addAppliance(new LcdTV("Samsung", "LX220", 150, EnergyEfficiency.C, false, 40, 80, "1960x1830", false, false));
        return home;
    }

    /**
     * Method for creating home with Appliances from XML file. Method validate XML with offer XSD.
     * @param xmlPath - path to XML file
     * @param xsdPath - path to XML Scheme
     * @return Home with Appliances from XML
     * @throws IOException
     * @throws SAXException
     */
    public static Home getHomeFromXML(String xmlPath, String xsdPath) throws IOException, SAXException {
        Validator validator = new Validator();
        validator.validate(xmlPath,xsdPath);

        ApplianceBuilderFactory factory = new ApplianceBuilderFactory();
        AbstractAppliancesBuilder builder = factory.createAppAppliancesBuilder(ApplianceBuilderFactory.TypeParser.SAX);
        builder.buildListAppliances(xmlPath);
        Home home = new Home(builder.getAppliances());
        return home;
    }

}
