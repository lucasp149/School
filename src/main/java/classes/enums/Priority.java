package classes.enums;

public enum Priority {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String priorityName;
    Priority(String priority) {
        this.priorityName = priority;
    }

    // getters

    public String getPriorityName() {
        return priorityName;
    }

    // Methods

    public static int getHoursPerMonth(Priority priority) {
        return switch (priority) {
            case LOW -> 4;
            case MEDIUM -> 8;
            case HIGH -> 16;
        };
    }
}
