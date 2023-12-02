package classes.enums;

public enum WorkingDay {
    MONDAY(1, "monday") {
        @Override
        Occupation[] checkWhoWorks(){
             return Occupation.values();
        }
    },
    TUESDAY(2, "tuesday") {
        @Override
        Occupation[] checkWhoWorks(){
            return Occupation.values();
        }
    },
    WEDNESDAY(3, "wednesday") {
        @Override
        Occupation[] checkWhoWorks(){
            return Occupation.values();
        }
    },
    THURSDAY(4, "thursday") {
        @Override
        Occupation[] checkWhoWorks(){
            return Occupation.values();
        }
    },
    FRIDAY(5, "friday") {
        @Override
        Occupation[] checkWhoWorks(){
            return Occupation.values();
        }
    },
    SATURDAY(6, "saturday") {
        @Override
        Occupation[] checkWhoWorks(){
            return new Occupation[]{Occupation.ACCOUNTANT, Occupation.DIRECTOR, Occupation.GROUNDSKEEPER};
        }
    },
    SUNDAY(7, "Sunday") {
        @Override
        Occupation[] checkWhoWorks(){
            return new Occupation[]{};
        }
    };

    private int dayByNumber;
    private String dayByName;

    // Methods

    abstract Occupation[] checkWhoWorks();

    // Getters

    public int getDayByNumber() {
        return dayByNumber;
    }

    public String getDayByName() {
        return dayByName;
    }


    // Setters


    public void setDayByNumber(int dayByNumber) {
        this.dayByNumber = dayByNumber;
    }

    public void setDayByName(String dayByName) {
        this.dayByName = dayByName;
    }

    WorkingDay(int dayByNumber, String dayByName) {
        this.dayByNumber = dayByNumber;
        this.dayByName = dayByName;
    }

}
