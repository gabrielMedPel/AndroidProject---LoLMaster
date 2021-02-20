package gabriel.medpel.lolmasterfinal.models.summoners;



import java.util.ArrayList;


public class SummonerFull {
    private String summonerName, summonerID, puuid, summonerLevel,region,leagueName ,leagueId, queueType, tier, rank, leaguePoints, wins, losses;

    public SummonerFull(String summonerName, String summonerID, String puuid, String summonerLevel, String region, String leagueName, String leagueId, String queueType, String tier, String rank, String leaguePoints, String wins, String losses) {
        this.summonerName = summonerName;
        this.summonerID = summonerID;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
        this.region = region;
        this.leagueName = leagueName;
        this.leagueId = leagueId;
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
    }

    public SummonerFull() {
        summonerName = "";
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
        return "Summoner Level : " + summonerLevel;
    }

    public String getRegion() {
        return region;
    }

    public String getLeagueName() {
        return "League Name: " + leagueName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getTier() {
        return tier;
    }

    public String getRank() {
        return rank;
    }

    public String getLeaguePoints() {
        return "League Points: "+leaguePoints;
    }

    public String getWins() {
        return "Wins: " +wins;
    }

    public String getLosses() {
        return "Losses: "+losses;
    }
}
