package model.appliancesHierarchy;

/**
 * Enum of energy class efficiency supported by all Appliance {A, B, C, D, E, F, G}.
 * A - the most energy efficient, G - the worst energy efficient.
 *
 * @author Ihar Novik
 */

//Why doesn't this class in Appliance? - !because it use in other package, and it must be PUBLIC.
public enum EnergyEfficiency {
    A, B, C, D, E, F, G
}
