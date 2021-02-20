package gabriel.medpel.lolmasterfinal.models.runes;

import java.util.ArrayList;

public class Slot {
    private ArrayList<Rune> runes;

    public Slot(ArrayList<Rune> runes) {
        this.runes = runes;
    }

    public ArrayList<Rune> getRunes() {
        return runes;
    }
}
