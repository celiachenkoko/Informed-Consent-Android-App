package com.wangdeyang.icf;

public class Patient {
    // fields
    private int researchID; // Unique
    private String name;    // Patient name
    private String wrongs;  // Wrong answers
    private int decision;   // 0 as decline, 1 as accept

    // constructors
    public Patient() {}

    public Patient(int _researchID, String _name) {
        this.researchID = _researchID;
        this.name = _name;
        this.decision = 0;
    }

    // properities
    public void setID(int _researchID) {
        this.researchID = _researchID;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setWrongs(String _wrongs) {
        this.wrongs = _wrongs;
    }

    public void setDecision(int result) {
        this.decision = result;
    }

    public int getID() {
        return this.researchID;
    }

    public String getName() {
        return this.name;
    }

    public String getWrongs() {
        return this.wrongs;
    }

    public int getDecisoin() {
        return this.decision;
    }
}
