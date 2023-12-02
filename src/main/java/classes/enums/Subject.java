package classes.enums;

public enum Subject {
    MATH (MinistryOfEducationSubjectRules.MATH),
    ART(MinistryOfEducationSubjectRules.ART),
    GEOGRAPHY(MinistryOfEducationSubjectRules.GEOGRAPHY),
    PHYSICAL_EDUCATION (MinistryOfEducationSubjectRules.PHYSICAL_EDUCATION),
    BIOLOGY (MinistryOfEducationSubjectRules.BIOLOGY),
    LITERATURE (MinistryOfEducationSubjectRules.LITERATURE),
    PHILOSOPHY (MinistryOfEducationSubjectRules.PHILOSOPHY),
    SOCIAL_STUDIES (MinistryOfEducationSubjectRules.SOCIAL_STUDIES),
    HISTORY (MinistryOfEducationSubjectRules.HISTORY);

    private final String subjectName;
    private final int subjectCode;
    private final int subjectRequiredHours;

    Subject(MinistryOfEducationSubjectRules subject) {

        this.subjectName = subject.getSubjectName();
        this.subjectCode = subject.getSubjectCode();
        this.subjectRequiredHours = subject.getObligatoryHoursPerMonth();
    }

    // Getters


    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public int getSubjectRequiredHours() {
        return subjectRequiredHours;
    }
}
