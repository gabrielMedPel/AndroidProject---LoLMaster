package gabriel.medpel.lolmasterfinal.models.summoners;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

public class SummonerUser {
    private String region,summonerName;




    public SummonerUser() {
    }

    public SummonerUser(String region, String summonerName) {
        this.region = region;
        this.summonerName = summonerName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummonerUser that = (SummonerUser) o;
        return Objects.equals(region, that.region) &&
                Objects.equals(summonerName, that.summonerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, summonerName);
    }
}
