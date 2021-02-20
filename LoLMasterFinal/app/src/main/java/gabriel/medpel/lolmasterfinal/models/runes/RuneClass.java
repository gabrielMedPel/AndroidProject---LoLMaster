package gabriel.medpel.lolmasterfinal.models.runes;

import java.util.ArrayList;

public class RuneClass {
    private String runaClassName;
    private String urlRunaClassIcon;
    private ArrayList<Slot> slots;


    public RuneClass(String runaClassName, String urlRunaClassIcon, ArrayList<Slot> slots) {
        this.runaClassName = runaClassName;
        this.urlRunaClassIcon = urlRunaClassIcon;
        this.slots = slots;
    }

    public String getRunaClassName() {
        return runaClassName;
    }

    public String getUrlRunaClassIcon() {
        return "http://ddragon.leagueoflegends.com/cdn/img/" +urlRunaClassIcon;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }
}
