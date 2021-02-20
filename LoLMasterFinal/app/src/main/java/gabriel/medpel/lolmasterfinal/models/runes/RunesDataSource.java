package gabriel.medpel.lolmasterfinal.models.runes;

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

public class RunesDataSource {
    private String address = "https://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/data/en_US/runesReforged.json";

    public void readDemo(MutableLiveData<ArrayList<RuneClass>> callback){
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

                ArrayList<RuneClass> runeClasses = new ArrayList<>();

                String json = response.body().string();


                try {
                    JSONArray rootObject = new JSONArray(json);

                    for (int i = 0; i <rootObject.length() ; i++) {
                        ArrayList<Slot> slots = new ArrayList<>();
                        JSONObject runasClassesJsonObject = rootObject.getJSONObject(i);

                        String runaClassName = runasClassesJsonObject.getString("name");
                        String runaClassIcon = runasClassesJsonObject.getString("icon");

                        JSONArray slotsJsonArray = runasClassesJsonObject.getJSONArray("slots");

                        for (int j = 0; j <slotsJsonArray.length() ; j++) {
                            ArrayList<Rune> runes = new ArrayList<>();
                            JSONArray runasJsonArray = slotsJsonArray.getJSONObject(j).getJSONArray("runes");
                            for (int k = 0; k < runasJsonArray.length(); k++) {
                                JSONObject runaJsonObject = runasJsonArray.getJSONObject(k);
                                String runaName = runaJsonObject.getString("name");
                                String urlRunaIcon = runaJsonObject.getString("icon");
                                String description = runaJsonObject.getString("longDesc");
                                runes.add(new Rune(urlRunaIcon,runaName,description));
                            }
                            slots.add(new Slot(runes));
                        }
                        runeClasses.add(new RuneClass(runaClassName,runaClassIcon,slots));

                    }
                    callback.postValue(runeClasses);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
