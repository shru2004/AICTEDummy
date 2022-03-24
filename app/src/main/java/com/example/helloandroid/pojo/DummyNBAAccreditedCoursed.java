package com.example.helloandroid.pojo;

public class DummyNBAAccreditedCoursed {

    String affiliatingUni, level, courseId, acredTill;
    long intake;

    public DummyNBAAccreditedCoursed(String affiliatingUni, String level, String courseId, String acredTill, long intake) {
        this.affiliatingUni = affiliatingUni;
        this.level = level;
        this.courseId = courseId;
        this.acredTill = acredTill;
        this.intake = intake;
    }

    public DummyNBAAccreditedCoursed() {
    }

    public String getAffiliatingUni() {
        return affiliatingUni;
    }

    public void setAffiliatingUni(String affiliatingUni) {
        this.affiliatingUni = affiliatingUni;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getAcredTill() {
        return acredTill;
    }

    public void setAcredTill(String acredTill) {
        this.acredTill = acredTill;
    }

    public long getIntake() {
        return intake;
    }

    public void setIntake(long intake) {
        this.intake = intake;
    }
}
