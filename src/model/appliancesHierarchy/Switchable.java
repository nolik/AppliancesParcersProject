package model.appliancesHierarchy;

/**
 * This interface provides methods for enable or disable devices from the energy network.
 *
 * @author Ihar Novik
 */
public interface Switchable {

    /**
     * This method connects device to energy network, and change flag (to true) responsible for the condition of the network device.
     */
    public void switchOn();

    /**
     * This method disconnects device from energy network, and change flag (to false) responsible for the condition of the network device.
     */
    public void switchOff();

    /**
     * Method return the state of device in energy network.
     * True - the power switched on, false - switched off.
     */
    public boolean isSwitched();

}
