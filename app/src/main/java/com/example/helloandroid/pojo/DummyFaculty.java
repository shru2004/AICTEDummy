package com.example.helloandroid.pojo;

public class DummyFaculty {

    String facultyId, facultyName, gender, designation, dateOfJoining, areaOfSpecification, appointmentType;

    public DummyFaculty(String facultyId, String facultyName, String gender, String designation, String dateOfJoining, String areaOfSpecification, String appointmentType) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.gender = gender;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.areaOfSpecification = areaOfSpecification;
        this.appointmentType = appointmentType;
    }

    public DummyFaculty() {
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getAreaOfSpecification() {
        return areaOfSpecification;
    }

    public void setAreaOfSpecification(String areaOfSpecification) {
        this.areaOfSpecification = areaOfSpecification;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
