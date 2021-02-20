package gabriel.medpel.lolmasterfinal.models.spells;

import gabriel.medpel.lolmasterfinal.MainScreenActivity;

public class Spell {
    private String spellName;
    private String spellDescription;
    private String cooldown;
    private String spellUrlImg;

    public Spell(String spellName, String spellDescription, String cooldown, String spellUrlImg) {
        this.spellName = spellName;
        this.spellDescription = spellDescription;
        this.cooldown = cooldown;
        this.spellUrlImg = spellUrlImg;
    }

    public String getSpellName() {
        return spellName;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public String getCooldown() {
        return cooldown;
    }

    public String getSpellUrlImg() {
        return "http://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/img/spell/" + spellUrlImg;
    }
}
