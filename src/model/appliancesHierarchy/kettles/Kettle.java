package model.appliancesHierarchy.kettles;

import model.ProjectConstants;
import model.appliancesHierarchy.Appliance;
import model.appliancesHierarchy.EnergyEfficiency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 * Created by nolik on 24.10.14.
 */


public class Kettle extends Appliance {

    private int volume;

    public Kettle(String name, String manufacturer, int power, EnergyEfficiency energyEfficiency,
                  boolean switched, int volume) {
        super(name, manufacturer, power, energyEfficiency, switched);
        this.volume = volume;
    }

    public Kettle() {
        super();
    }


    public int getVolume() {
        return volume;
    }

 //   @XmlValue
    public void setVolume(int volume) {
        this.volume = volume;
    }

   @Override
    public String toString() {
        return new StringBuffer(super.toString())
                .append(", ").append(ProjectConstants.VOLUME)
                .append(":")
                .append(volume)
                .append(ProjectConstants.LITRE).toString();
    }


    //получить из объекта XML
    public static void main(String[] args) throws JAXBException {
// Создаем экземпляр JAXBContext, в качестве параметра, передаем класс с которым мы будем работать используя OXM
// Более подробную информацию об использвании JAXBContext можно посмотреть тут: http://docs.oracle.com/javaee/6/api/javax/xml/bind/JAXBContext.html
        JAXBContext context = JAXBContext.newInstance(Kettle.class);

// Получаем ссылку на объект, который будет выполнять преобразование Object -> XML
        Marshaller marshaller = context.createMarshaller();
// Указываем в настройке, что XML должен быть отоформатирован
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

// Создаем экземпляр объекта, который мы будем преобразовывать в XML
        Kettle kettle = new Kettle("Bosh", "Crater", 250, EnergyEfficiency.B, true,2);

        // Поскольку, наш объект не содержит аннотаций, мы должны работать с ним использую JAXBElement, в нем
        // указываем название рутового элемента в создаваемом XML
        JAXBElement<Kettle> jaxbElement = new JAXBElement<>(new QName("kettle"), Kettle.class,kettle);

        // Выводим XML на экран, обращаем внимание, что строка отформатирована
        marshaller.marshal(jaxbElement, System.out);
    }

}
