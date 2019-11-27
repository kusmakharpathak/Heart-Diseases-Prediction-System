package com.HeartDPS;

public class Patients {
    private String id;
    private String fName;
    private String mName;
    private String lName;
    private String DateOfBirth;
    private int age;
    private String gender;
    private String contact;
    private String address;
    private int cp;
    private int trestbps;
    private int chol;
    private int fbs;
    private int restecg;
    private int thalach;
    private int exang;
    private Double oldpeak;
    private int slop;
    private int ca;
    private int thal;

    public Patients() {
        this.id = "";
        this.fName = "";
        this.mName = "";
        this.lName = "";
        DateOfBirth = "";
        this.age = 0;
        this.gender = "";
        this.contact = "";
        this.address = "";
        this.cp = 0;
        this.trestbps = 0;
        this.chol = 0;
        this.fbs = 0;
        this.restecg = 0;
        this.thalach = 0;
        this.exang = 0;
        this.oldpeak = 0.0;
        this.slop = 0;
        this.ca = 0;
        this.thal = 0;
    }

    public Patients(String id, String fName, String mName, String lName, String dateOfBirth, int age, String gender, String contact, String address, int cp, int trestbps, int chol, int fbs, int restecg, int thalach, int exang, Double oldpeak, int slop, int ca, int thal) {
        this.id = id;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        DateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
        this.cp = cp;
        this.trestbps = trestbps;
        this.chol = chol;
        this.fbs = fbs;
        this.restecg = restecg;
        this.thalach = thalach;
        this.exang = exang;
        this.oldpeak = oldpeak;
        this.slop = slop;
        this.ca = ca;
        this.thal = thal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTrestbps() {
        return trestbps;
    }

    public void setTrestbps(int trestbps) {
        this.trestbps = trestbps;
    }

    public int getChol() {
        return chol;
    }

    public void setChol(int chol) {
        this.chol = chol;
    }

    public int getFbs() {
        return fbs;
    }

    public void setFbs(int fbs) {
        this.fbs = fbs;
    }

    public int getRestecg() {
        return restecg;
    }

    public void setRestecg(int restecg) {
        this.restecg = restecg;
    }

    public int getThalach() {
        return thalach;
    }

    public void setThalach(int thalach) {
        this.thalach = thalach;
    }

    public int getExang() {
        return exang;
    }

    public void setExang(int exang) {
        this.exang = exang;
    }

    public Double getOldpeak() {
        return oldpeak;
    }

    public void setOldpeak(Double oldpeak) {
        this.oldpeak = oldpeak;
    }

    public int getSlop() {
        return slop;
    }

    public void setSlop(int slop) {
        this.slop = slop;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getThal() {
        return thal;
    }

    public void setThal(int thal) {
        this.thal = thal;
    }
}