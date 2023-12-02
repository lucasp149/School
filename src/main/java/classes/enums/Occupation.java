package classes.enums;

import org.apache.commons.lang3.StringUtils;

public enum Occupation {
    DRIVER("driver", 1),
    JANITOR("janitor", 2),
    ACCOUNTANT("accountant", 3),
    DIRECTOR("director", 4),
    CROSSING_GUARD("crossing guard", 5),
    GROUNDSKEEPER("groundskeeper", 6),
    MAINTENANCE_TECHNICIAN("maintenance technician", 7);

    private final String occupationName;
    private final int occupationCode;

    Occupation(String occupation, int code) {
        this.occupationCode = code;
        this.occupationName = occupation;
    }

    Occupation(String occupation) {
        this(StringUtils.lowerCase(occupation), assignCode(occupation));
    }

    Occupation(int code) {
        this(assignOccupationName(code), code);
    }

    // Getters

    public String getOccupationName() {
        return occupationName;
    }

    public int getOccupationCode() {
        return occupationCode;
    }


    // Methods

    static private int assignCode(String occupation) {
        return switch (occupation) {
            case "driver" -> 1;
            case "janitor" -> 2;
            case "accountant" -> 3;
            case "director" -> 4;
            case "crossing guard" -> 5;
            case "groundskeeper" -> 6;
            case "maintenance technician" -> 7;
            default -> 0;
        };
    }

    static private String assignOccupationName(int code) {
        return switch (code) {
            case 1 -> "driver";
            case 2 -> "janitor";
            case 3 -> "accountant";
            case 4 -> "director";
            case 5 -> "crossing guard";
            case 6 -> "groundskeeper";
            case 7 -> "maintenance technician";
            default -> "none";
        };
    }

}
