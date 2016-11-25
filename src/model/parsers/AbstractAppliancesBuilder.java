package model.parsers;

import model.appliancesHierarchy.Appliance;

import java.io.IOException;
import java.util.List;

/**
 * Abstract class for factory.
 */
public abstract class AbstractAppliancesBuilder {

    public abstract void buildListAppliances(String fileName) throws IOException;
    public abstract List<Appliance> getAppliances();

}
