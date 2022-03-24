package com.example.helloandroid.pojo;

public class DummyData {

    String uniId, id;
    String aicteId;
    String name;
    String address;
    String district, state, program, level, institutionType;
    boolean women, minority;
    String universityBoard;
    boolean closed;

    public DummyData(String uniId, String id, String aicteId, String name, String address, String district, String state, String program, String level, String institutionType, boolean women, boolean minority, String universityBoard, boolean closed) {
        this.uniId = uniId;
        this.id= id;
        this.aicteId = aicteId;
        this.name = name;
        this.address = address;
        this.district = district;
        this.state = state;
        this.program = program;
        this.level = level;
        this.institutionType = institutionType;
        this.women = women;
        this.minority = minority;
        this.universityBoard = universityBoard;
        this.closed = closed;
    }

    public DummyData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniId() {
        return uniId;
    }

    public void setUniId(String uniId) {
        this.uniId = uniId;
    }

    public String getAicteId() {
        return aicteId;
    }

    public void setAicteId(String aicteId) {
        this.aicteId = aicteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType;
    }

    public boolean isWomen() {
        return women;
    }

    public void setWomen(boolean women) {
        this.women = women;
    }

    public boolean isMinority() {
        return minority;
    }

    public void setMinority(boolean minority) {
        this.minority = minority;
    }

    public String getUniversityBoard() {
        return universityBoard;
    }

    public void setUniversityBoard(String universityBoard) {
        this.universityBoard = universityBoard;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
