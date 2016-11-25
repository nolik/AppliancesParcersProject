package model.parsers;

/**
 * Enum of All needs tag for parsing.
 */
public enum ApplianceEnum {
    APPLIANCES("appliances"),
    KETTLE("kettle"),
    TERMOPOT("termopot"),
    MICROWAVE("microwave"),
    DISHWASHER("dishwasher"),
    WASHING_MACHINE("washingMachine"),
    OVEN("oven"),
    CONDITIONER("conditioner"),
    ENERGY_EFFICIENCY_CLASS("energyEfficiencyClass"),
    MANUFACTURER("manufacturer"),
    MODEL("model"),
    POWER("power"),
    SWITCHED("switched"),
    VOLUME_OF_FURNACE("volumeOfFurnace"),
    MODS("mods"),
    HAVE_GRILL("haveGrill"),
    POWER_WAVES("powerWaves"),
    MAX_TEMPERATURE("maxTemperature"),
    WATER_CONSUMPTION("waterConsumption"),
    WASHING_CLASS("washingClass"),
    NUMBER_OF_PROGRAMS("numberOfPrograms"),
    MAX_LOAD_OF_DISHES("maxLoadOfDishes"),
    TYPE_OF_DRYING("typeOfDrying"),
    MAX_LOAD("maxLoad"),
    MAX_SPIN_SPEED("maxSpinSpeed"),
    VOLUME("volume"),
    MAX_HOLDING_TEMPERATURE("maxHoldingTemperature"),
    SERVICE_AREA("serviceArea"),
    TYPE("type"),
    HEATING("heating");




    private String value;

    private ApplianceEnum(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }


}
