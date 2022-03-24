package com.example.helloandroid.pojo;

public class DataPoint {

    long intake;
    long enrollment;
    long studentPassed;
    long placement;
    int year;

    public DataPoint(long intake, long enrollment, long studentPassed, long placement, int year) {
        this.intake = intake;
        this.enrollment = enrollment;
        this.studentPassed = studentPassed;
        this.placement = placement;
        this.year = year;
    }

    public DataPoint() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getIntake() {
        return intake;
    }

    public void setIntake(long intake) {
        this.intake = intake;
    }

    public long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(long enrollment) {
        this.enrollment = enrollment;
    }

    public long getStudentPassed() {
        return studentPassed;
    }

    public void setStudentPassed(long studentPassed) {
        this.studentPassed = studentPassed;
    }

    public long getPlacement() {
        return placement;
    }

    public void setPlacement(long placement) {
        this.placement = placement;
    }
}
