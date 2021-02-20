package gabriel.medpel.lolmasterfinal.models.summoners;

public class Summoner {
    private String summonerName, summonerID, puuid, summonerLevel,region;

    public Summoner(String summonerName, String summonerID, String puuid, String summonerLevel,String region) {
        this.summonerName = summonerName;
        this.summonerID = summonerID;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
        this.region = region;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getSummonerID() {
        return summonerID;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getSummonerLevel() {
        return summonerLevel;
    }

    public String getRegion() {
        return region;
    }
}
