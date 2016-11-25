package model.appliancesHierarchy.kettles;

import model.ProjectConstants;
import model.appliancesHierarchy.EnergyEfficiency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 * Created by nolik on 29.10.14.
 */
public class Termopot extends Kettle {


    private int maxHoldingTemperature;

    public Termopot(String name, String manufacturer, int power, EnergyEfficiency energyEfficiency,
                    boolean switched, int volume, int maxHoldTemperature) {
        super(name, manufacturer, power, energyEfficiency, switched, volume);
        maxHoldingTemperature = maxHoldTemperature;
    }

    public Termopot() {

    }

    public int getMaxHoldingTemperature() {
        return maxHoldingTemperature;
    }

    public void setMaxHoldingTemperature(int maxHoldingTemperature) {
        this.maxHoldingTemperature = maxHoldingTemperature;
    }

    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append(", ")
                .append(ProjectConstants.MAX_HOLD_TEMPERATURE)
                .append(":")
                .append(maxHoldingTemperature).toString();
    }


    public static void main(String[] args) throws JAXBException {


    // Создаем экземпляр JAXBContext, в качестве параметра, передаем класс с которым мы будем работать используя OXM
// Более подробную информацию об использвании JAXBContext можно посмотреть тут: http://docs.oracle.com/javaee/6/api/javax/xml/bind/JAXBContext.html
    JAXBContext context = JAXBContext.newInstance(Termopot.class);

    // Получаем ссылку на объект, который будет выполнять преобразование Object -> XML
    Marshaller marshaller = context.createMarshaller();
// Указываем в настройке, что XML должен быть отоформатирован
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Создаем экземпляр объекта, который мы будем преобразовывать в XML
    Termopot termopot = new Termopot("Maxwell", "Well", 300, EnergyEfficiency.B, true,2,100);

    // Поскольку, наш объект не содержит аннотаций, мы должны работать с ним использую JAXBElement, в нем
    // указываем название рутового элемента в создаваемом XML
    JAXBElement<Termopot> jaxbElement = new JAXBElement<>(new QName("termopot"), Termopot.class,termopot);

    // Выводим XML на экран, обращаем внимание, что строка отформатирована
    marshaller.marshal(jaxbElement, System.out);
}
}
