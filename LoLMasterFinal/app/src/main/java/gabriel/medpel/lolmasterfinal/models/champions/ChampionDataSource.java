package gabriel.medpel.lolmasterfinal.models.champions;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.MainScreenActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChampionDataSource {
    private String address = "https://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/data/en_US/championFull.json";

    public void readDemo(MutableLiveData<ArrayList<Champion>> callback){
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
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
                ArrayList<Champion> champions = new ArrayList<>();
                String json = response.body().string();


                try {
                    JSONObject rootObject = new JSONObject(json);


                    JSONObject championsJsonObject = rootObject.getJSONObject("data");

                   championsJsonObject.keys().forEachRemaining(k->{
                       try {
                           String name = championsJsonObject.getJSONObject(k).getString("name");
                           String id = championsJsonObject.getJSONObject(k).getString("id");
                           String title = championsJsonObject.getJSONObject(k).getString("title");
                           String lore = championsJsonObject.getJSONObject(k).getString("lore");


                           String urlImage = championsJsonObject.getJSONObject(k).getString("id");

                           JSONObject infoJsonObject = championsJsonObject.getJSONObject(k).getJSONObject("info");

                           String attack = infoJsonObject.getString("attack");
                           String defense = infoJsonObject.getString("defense");
                           String magic = infoJsonObject.getString("magic");
                           String difficulty = infoJsonObject.getString("difficulty");

//                           Spells:
                           JSONArray spellsJsonArray = championsJsonObject.getJSONObject(k).getJSONArray("spells");

                           JSONObject spellQJsonObject = spellsJsonArray.getJSONObject(0);
                           JSONObject spellWJsonObject = spellsJsonArray.getJSONObject(1);
                           JSONObject spellEJsonObject = spellsJsonArray.getJSONObject(2);
                           JSONObject spellRJsonObject = spellsJsonArray.getJSONObject(3);

                           JSONObject passiveJsonObject = championsJsonObject.getJSONObject(k).getJSONObject("passive");



                           String qName = spellQJsonObject.getString("name");
                           String qDescription = spellQJsonObject.getString("description");
                           String qUrlImg = spellQJsonObject.getJSONObject("image").getString("full");
                           String wName = spellWJsonObject.getString("name");
                           String wDescription = spellWJsonObject.getString("description");
                           String wUrlImg = spellWJsonObject.getJSONObject("image").getString("full");
                           String eName = spellEJsonObject.getString("name");
                           String eDescription = spellEJsonObject.getString("description");
                           String eUrlImg = spellEJsonObject.getJSONObject("image").getString("full");
                           String rName = spellRJsonObject.getString("name");
                           String rDescription = spellRJsonObject.getString("description");
                           String rUrlImg = spellRJsonObject.getJSONObject("image").getString("full");
                           String passiveName = passiveJsonObject.getString("name");
                           String passiveDescription = passiveJsonObject.getString("description");
                           String passiveUrlImg = passiveJsonObject.getJSONObject("image").getString("full");




                            Spells spells = new Spells(qName,qDescription,qUrlImg,wName,wDescription,wUrlImg,eName,eDescription,eUrlImg,rName,rDescription,rUrlImg,passiveName,passiveDescription,passiveUrlImg);
                           champions.add(new Champion(name,id,urlImage,title,lore,attack,defense,magic,difficulty,spells));

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
                   });
                    callback.postValue(champions);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
