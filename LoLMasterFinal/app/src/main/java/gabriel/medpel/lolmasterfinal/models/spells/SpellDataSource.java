package gabriel.medpel.lolmasterfinal.models.spells;

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
import gabriel.medpel.lolmasterfinal.models.runes.Rune;
import gabriel.medpel.lolmasterfinal.models.runes.RuneClass;
import gabriel.medpel.lolmasterfinal.models.runes.Slot;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SpellDataSource {
    private String address = "http://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/data/en_US/summoner.json";

    public void readDemo(MutableLiveData<ArrayList<Spell>> callback){
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

                ArrayList<Spell> spells = new ArrayList<>();

                String json = response.body().string();


                try {
                    JSONObject rootObject = new JSONObject(json).getJSONObject("data");

                    rootObject.keys().forEachRemaining(k->{
                        try {
                            String spellName = rootObject.getJSONObject(k).getString("name");
                            String spellDescription = rootObject.getJSONObject(k).getString("description");
                            String cooldown = rootObject.getJSONObject(k).getString("cooldownBurn");
                            String spellUrlImg = rootObject.getJSONObject(k).getJSONObject("image").getString("full");

                            spells.add(new Spell(spellName,spellDescription,cooldown,spellUrlImg));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    });
                    callback.postValue(spells);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
