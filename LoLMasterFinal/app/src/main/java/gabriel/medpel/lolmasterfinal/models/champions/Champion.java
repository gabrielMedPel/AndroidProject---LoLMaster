package gabriel.medpel.lolmasterfinal.models.champions;

public class Champion {
    private String name;
    private String id;
    private String urlImage;
    private String Title;
    private String lore;
    private String  attack;
    private String defense;
    private String magic;
    private String difficulty;
    private Spells spells;


    public Champion(String name, String id, String urlImage, String title, String lore, String attack, String defense, String magic, String difficulty, Spells spells) {
        this.name = name;
        this.id = id;
        this.urlImage = urlImage;
        Title = title;
        this.lore = lore;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.difficulty = difficulty;
        this.spells = spells;
    }

    public String getName() {
        return name;
    }
    public String getSquareImg() {
        return "https://ddragon.leagueoflegends.com/cdn/img/champion/tiles/"+ id+"_0.jpg";
    }
    public String getUrlImage() {
        return "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + urlImage + "_0.jpg";

    }
    public String getTitle() {
        return Title;
    }
    public String getLore() {
        return lore;
    }
    public String getAttack() {
        return "Attack:        " + attack;
    }
    public String getDefense() {
        return "Defense:     " + defense;
    }
    public String getMagic() {
        return "Magic:         " + magic;
    }
    public String getDifficulty() {
        return "Difficulty:     " + difficulty;
    }
    public Spells getSpells() {
        return spells;
    }
}
