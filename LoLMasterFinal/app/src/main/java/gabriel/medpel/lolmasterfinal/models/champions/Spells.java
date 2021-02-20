package gabriel.medpel.lolmasterfinal.models.champions;

import gabriel.medpel.lolmasterfinal.MainScreenActivity;

public class Spells {
    private String qName;
    private String qDescription;
    private String qUrlImg;
    private String wName;
    private String wDescription;
    private String wUrlImg;
    private String eName;
    private String eDescription;
    private String eUrlImg;
    private String rName;
    private String rDescription;
    private String rUrlImg;
    private String passiveName;
    private String passiveDescription;
    private String passiveUrlImg;
    private String baseUrl = "https://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/img/spell/";

    public Spells(String qName, String qDescription, String qUrlImg, String wName, String wDescription, String wUrlImg, String eName, String eDescription, String eUrlImg, String rName, String rDescription, String rUrlImg, String passiveName, String passiveDescription, String passiveUrlImg) {
        this.qName = qName;
        this.qDescription = qDescription;
        this.qUrlImg = qUrlImg;
        this.wName = wName;
        this.wDescription = wDescription;
        this.wUrlImg = wUrlImg;
        this.eName = eName;
        this.eDescription = eDescription;
        this.eUrlImg = eUrlImg;
        this.rName = rName;
        this.rDescription = rDescription;
        this.rUrlImg = rUrlImg;
        this.passiveName = passiveName;
        this.passiveDescription = passiveDescription;
        this.passiveUrlImg = passiveUrlImg;
    }

    public String getqName() {
        return qName;
    }
    public String getqDescription() {
        return qDescription;
    }
    public String getqUrlImg() {
        return baseUrl + qUrlImg;
    }
    public String getwName() {
        return wName;
    }
    public String getwDescription() {
        return wDescription;
    }
    public String getwUrlImg() {
        return baseUrl + wUrlImg;
    }
    public String geteName() {
        return eName;
    }
    public String geteDescription() {
        return eDescription;
    }
    public String geteUrlImg() {
        return baseUrl + eUrlImg;
    }
    public String getrName() {
        return rName;
    }
    public String getrDescription() {
        return rDescription;
    }
    public String getrUrlImg() {
        return baseUrl + rUrlImg;
    }
    public String getPassiveName() {
        return passiveName;
    }
    public String getPassiveDescription() {
        return passiveDescription;
    }
    public String getPassiveUrlImg() {
        return "https://ddragon.leagueoflegends.com/cdn/10.23.1/img/passive/" + passiveUrlImg;
    }
}
