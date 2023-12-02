package classes.enums;

public enum MinistryOfEducationSubjectRules {
    MATH("math",121, Priority.HIGH),
    ART("art",205, Priority.LOW),
    GEOGRAPHY("geography",255, Priority.MEDIUM),
    PHYSICAL_EDUCATION ("physical education",254, Priority.MEDIUM),
    BIOLOGY("biology",122, Priority.HIGH),
    LITERATURE("literature",123, Priority.HIGH),
    PHILOSOPHY("music",204, Priority.LOW),
    SOCIAL_STUDIES("social studies",253, Priority.MEDIUM),
    HISTORY("history",124, Priority.HIGH),
    MUSIC("music",203, Priority.LOW),
    ENGLISH("english",125, Priority.HIGH),
    SPANISH("spanish",201, Priority.LOW),
    CHEMISTRY("chemistry",251, Priority.MEDIUM),
    INFORMATION_TECHNOLOGY("information technology",252, Priority.MEDIUM),
    DRAMA("drama",202, Priority.LOW),
    ALGEBRA("algebra",252, Priority.MEDIUM);

    private final String subjectName;
    private final int subjectCode;
    private final int obligatoryHoursPerMonth;
    private final String priority;
    private final String lawStatement;



    MinistryOfEducationSubjectRules(String subjectName, int subjectCode, Priority priority){
        this.subjectCode= subjectCode;
        this.subjectName = subjectName;
        this.obligatoryHoursPerMonth = Priority.getHoursPerMonth(priority);
        this.priority = priority.getPriorityName();
        this.lawStatement = lawStatementSet(subjectName);
    }

    // Getters

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public int getObligatoryHoursPerMonth() {
        return obligatoryHoursPerMonth;
    }

    public String getPriority() {
        return priority;
    }

    public String getLawStatement() {
        return lawStatement;
    }

    // Methods

    private String lawStatementSet(String subject){
        String year = "1994";
        if(subject.equals("drama") || subject.equals("art") ||  subject.equals("philosophy") ){
            year = "2010";
        }
        return "This priority was set on "+ year +" education congress with the consent of all schools across the country";
    }
}
