package view;

import model.Home;

import java.util.List;

/**
 * This interface provides methods for print all information in project to all output ways(console,xml,file...).
 *
 * @author Ihar Novik
 */
public interface Printable {
    /**
     * Method prints all information about appliances.xml and
     * about total power consumption used by home appliances.xml.
     *
     * @param allAppliances current available appliances.xml
     * @param usedPower  total used power
     */
    public void printAllAppliancesInfo(Home allAppliances,int usedPower);



    /**
     * Method print selected list of appliances.xml.
     *
     * @param selectedAppliances
     */
    public void printSelectedAppliances(List selectedAppliances);
}
