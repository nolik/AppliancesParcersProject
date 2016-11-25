package model.parsers;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class validator for XML.
 */
public class Validator {
    static Logger logger = Logger.getLogger(Validator.class);

    /**
     * Method validating XML by dint of XSD.
     * @param fileName - file with XML.
     * @param schemaName - file with XSD.
     * @throws SAXException
     * @throws IOException
     */
    public  void validate(String fileName,String schemaName) throws SAXException, IOException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);

        try {
            // creating scheme
            Schema schema = factory.newSchema(schemaLocation);
            // creating validator based on the scheme
            javax.xml.validation.Validator validator = schema.newValidator();
            // validating document
            Source source = new StreamSource(fileName);
            validator.validate(source);
            logger.info(fileName + " is valid.");

        } catch (SAXException e) {
            logger.error("validation "+ fileName + " is not valid because "
                    + e.getMessage());
            throw e;
        } catch (IOException e) {

            logger.error(fileName + " is not valid because "
                    + e.getMessage());
            throw e;
        }
    }
}
