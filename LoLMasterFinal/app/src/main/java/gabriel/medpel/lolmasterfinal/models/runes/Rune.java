package gabriel.medpel.lolmasterfinal.models.runes;

public class Rune {
    String urlRunaIcon;
    String runaName;
    String description;

    public Rune(String urlRunaIcon, String runaName, String description) {
        this.urlRunaIcon = urlRunaIcon;
        this.runaName = runaName;
        this.description = description;
    }

    public String getUrlRunaIcon() {
        return "http://ddragon.leagueoflegends.com/cdn/img/" +urlRunaIcon;
    }

    public String getRunaName() {
        return runaName;
    }

    public String getDescription() {
        return description;
    }
}
