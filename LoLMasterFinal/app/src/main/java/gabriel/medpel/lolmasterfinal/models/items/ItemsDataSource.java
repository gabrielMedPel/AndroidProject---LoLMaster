package gabriel.medpel.lolmasterfinal.models.items;

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

public class ItemsDataSource {
    private String address = "https://ddragon.leagueoflegends.com/cdn/" + MainScreenActivity.version + "/data/en_US/item.json";

    public void readDemo(MutableLiveData<ArrayList<Item>> callback){
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
                ArrayList<Item> items = new ArrayList<>();

                String json = response.body().string();


                try {
                    JSONObject rootObject = new JSONObject(json);


                    JSONObject itemsJsonObject = rootObject.getJSONObject("data");

                    itemsJsonObject.keys().forEachRemaining(k->{
                        try {
                            String name = itemsJsonObject.getJSONObject(k).getString("name");
                            String description = itemsJsonObject.getJSONObject(k).getString("description");
                            String plainText = itemsJsonObject.getJSONObject(k).getString("plaintext");


                            JSONObject itemsUrlImgObject = itemsJsonObject.getJSONObject(k).getJSONObject("image");
                            String itemUrlImg = itemsUrlImgObject.getString("full");

                            JSONObject goldJasonObject = itemsJsonObject.getJSONObject(k).getJSONObject("gold");
                            String goldBuy = goldJasonObject.getString("total");
                            String goldSell = goldJasonObject.getString("sell");

                            ArrayList<String> tags = new ArrayList<>();
                            JSONArray tagsJsonArray = itemsJsonObject.getJSONObject(k).getJSONArray("tags");
                            for (int i = 0; i < tagsJsonArray.length(); i++) {
                                tags.add(tagsJsonArray.getString(i));
                            }
                            items.add(new Item(name,itemUrlImg,description,plainText,goldBuy,goldSell,tags));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    });
                    callback.postValue(items);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
