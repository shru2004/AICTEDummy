package com.example.helloandroid.pojo;

public class DummyCourse {

    String courseId;
    String courseName, shift;
    long intake, enrollment, placement;
    String levelOfCourse, fullOrPratTime;
    boolean closed;

    public DummyCourse(String courseId, String courseName, String shift, long intake, long enrollment, long placement, String levelOfCourse, String fullOrPratTime, boolean closed) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.shift = shift;
        this.intake = intake;
        this.enrollment = enrollment;
        this.placement = placement;
        this.levelOfCourse = levelOfCourse;
        this.fullOrPratTime = fullOrPratTime;
        this.closed = closed;
    }

    public DummyCourse() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
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

    public long getPlacement() {
        return placement;
    }

    public void setPlacement(long placement) {
        this.placement = placement;
    }

    public String getLevelOfCourse() {
        return levelOfCourse;
    }

    public void setLevelOfCourse(String levelOfCourse) {
        this.levelOfCourse = levelOfCourse;
    }

    public String getFullOrPratTime() {
        return fullOrPratTime;
    }

    public void setFullOrPratTime(String fullOrPratTime) {
        this.fullOrPratTime = fullOrPratTime;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
