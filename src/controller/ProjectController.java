package controller;

import model.*;
import model.appliancesHierarchy.EnergyEfficiency;
import model.appliancesHierarchy.televisors.OledTV;
import org.xml.sax.SAXException;
import view.Printable;
import view.PrinterCreator;

import java.io.IOException;

/**
 * Class of the project where executed interaction MVC model and view of the project.
 * Include main method of the project.
 *
 * @author Novik Ihar
 */
public class ProjectController {


    public static void main(String[] args) throws IOException, SAXException {

      //  Home model = HomeCreator.getHome();
        Home model = HomeCreator.getHomeFromXML(ProjectConstants.XML_PATH,ProjectConstants.XSD_PATH);
        Printable printer = PrinterCreator.getTxtPrinter("/home/nolik/4");



        model.addAppliance(new OledTV("Toshiba", "PE2", 300, EnergyEfficiency.C, true,32,300,true,true,"4000x2000"));
        SortManager.sortAppliancesByEnergyClass(model);

        printer.printAllAppliancesInfo(model, HomeManager.calculateUsedPower(model));

     //   printer.printAllAppliancesInfo(model, HomeManager.iteratorCalculateUsedPower(model));

        printer.printSelectedAppliances(SortManager.getApplianceByEnergyClass(model, EnergyEfficiency.A));


     }


}
