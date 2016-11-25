package model.parsers;

import model.parsers.DOM.AppliancesDOMBuilder;
import model.parsers.SAX.AppliancesSAXBuilder;
import model.parsers.StAX.AppliancesStAXBuilder;

/**
 * Class factory for ApplianceBuilder's.
 */
public class ApplianceBuilderFactory {
    /**
     * Type of parser.
     */
    public enum TypeParser {
        SAX, STAX, DOM
    }

    /**
     * Method for creating Builder.
     * @param typeParser - type of parser which be used for parsing.
     * @return AppliancesBuilder
     */
    public AbstractAppliancesBuilder createAppAppliancesBuilder(TypeParser typeParser) {
               switch (typeParser) {
            case DOM:
                return new AppliancesDOMBuilder();
            case STAX:
                return new AppliancesStAXBuilder();
            case SAX:
                return new AppliancesSAXBuilder();

                default: throw new EnumConstantNotPresentException(TypeParser.class,"wrong type");
        }
    }


}
