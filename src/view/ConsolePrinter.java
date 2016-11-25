package view;

import model.Home;
import model.ProjectConstants;

import java.util.List;

/**
 * Class for printing result to console.
 *
 * @author Novik Ihar
 */
public class ConsolePrinter implements Printable {


    @Override
    public void printAllAppliancesInfo(Home allAppliances, int usedPower) {

            System.out.println(allAppliances.toString());
        System.out.println(ProjectConstants.TOTAL_POWER_CONSUMPTION+" - " + usedPower + " " + ProjectConstants.WATT);

    }



    @Override
    public void printSelectedAppliances(List selectedAppliances) {
        System.out.println("\n"+ProjectConstants.SELECTED_RANGE+":");
        for (Object a : selectedAppliances) {
            System.out.println(a.toString());
        }
    }
}
