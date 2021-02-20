package gabriel.medpel.lolmasterfinal.models.summoners;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.MainScreenActivity;
import gabriel.medpel.lolmasterfinal.models.runes.Rune;
import gabriel.medpel.lolmasterfinal.models.runes.RuneClass;
import gabriel.medpel.lolmasterfinal.models.runes.Slot;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SummonerDataSource {
    private String region, summonerName, summonerID, leagueID;
    private String urlQuery;

    public SummonerDataSource(String region, String summonerName) {
        this.region = region;
        this.summonerName = summonerName;
    }

    public void readDemo(MutableLiveData<SummonerFull> callBack) throws UnsupportedEncodingException {

        urlQuery = URLEncoder.encode(summonerName, "utf-8");

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://" + region + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + urlQuery)
                .addHeader("X-Riot-Token", MainScreenActivity.apiKey)
                .build();

        Call call = httpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String json = response.body().string();
                System.out.println(json);
                try {
                    JSONObject rootObject = new JSONObject(json);

                    String summonerName = rootObject.getString("name");

                    String sumID = rootObject.getString("id");
                    summonerID = sumID;

                    String puuid = rootObject.getString("puuid");

                    String summonerLevel = rootObject.getString("summonerLevel");

                    OkHttpClient httpClient2 = new OkHttpClient();
                    Request request2 = new Request.Builder()
                            .url("https://" + region + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerID)
                            .addHeader("X-Riot-Token", MainScreenActivity.apiKey)
                            .build();

                    Call call2 = httpClient2.newCall(request2);

                    call2.enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call2, @NotNull IOException e) {
                            e.printStackTrace();

                        }

                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onResponse(@NotNull Call call2, @NotNull Response response) throws IOException {
                            String json = response.body().string();
                            System.out.println(json);

                            try {
                                JSONArray rootObject = new JSONArray(json);
                                if (rootObject.length()==0){
                                    callBack.postValue(new SummonerFull());
                                }
                                for (int i = 0; i < rootObject.length(); i++) {
                                    JSONObject leagueJsonObject = rootObject.getJSONObject(i);

                                    String leaId = leagueJsonObject.getString("leagueId");
                                    leagueID = leaId;
                                    System.out.println(leagueID);

                                    String queueType = leagueJsonObject.getString("queueType");
                                    String tier = leagueJsonObject.getString("tier");
                                    String rank = leagueJsonObject.getString("rank");
                                    String leaguePoints = leagueJsonObject.getString("leaguePoints");
                                    String wins = leagueJsonObject.getString("wins");
                                    String losses = leagueJsonObject.getString("losses");

                                    OkHttpClient httpClient = new OkHttpClient();
                                    Request request = new Request.Builder()
                                            .url("https://" + region + ".api.riotgames.com/lol/league/v4/leagues/" + leagueID)
                                            .addHeader("X-Riot-Token", MainScreenActivity.apiKey)
                                            .build();

                                    Call call3 = httpClient.newCall(request);

                                    call3.enqueue(new Callback() {
                                        @Override
                                        public void onFailure(@NotNull Call call3, @NotNull IOException e) {
                                            e.printStackTrace();
                                        }

                                        @RequiresApi(api = Build.VERSION_CODES.N)
                                        @Override
                                        public void onResponse(@NotNull Call call3, @NotNull Response response) throws IOException {
                                            String json = response.body().string();
                                            System.out.println(json);

                                            try {
                                                JSONObject rootObject = new JSONObject(json);
                                                String leagueName = rootObject.getString("name");
                                                System.out.println(leagueName);

                                                SummonerFull summFull = new SummonerFull(summonerName, summonerID, puuid, summonerLevel, region, leagueName, leaId, queueType, tier, rank, leaguePoints, wins, losses);

                                                callBack.postValue(summFull);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                    callBack.postValue(new SummonerFull("","","","","","","","","","","","",""));
                }
            }
        });
    }
}
