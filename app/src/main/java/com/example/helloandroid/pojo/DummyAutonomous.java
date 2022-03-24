package com.example.helloandroid.pojo;

public class DummyAutonomous {

    String conferedBy, autonomyTill;

    public DummyAutonomous(String conferedBy, String autonomyTill) {
        this.conferedBy = conferedBy;
        this.autonomyTill = autonomyTill;
    }

    public DummyAutonomous() {
    }

    public String getConferedBy() {
        return conferedBy;
    }

    public void setConferedBy(String conferedBy) {
        this.conferedBy = conferedBy;
    }

    public String getAutonomyTill() {
        return autonomyTill;
    }

    public void setAutonomyTill(String autonomyTill) {
        this.autonomyTill = autonomyTill;
    }
}
