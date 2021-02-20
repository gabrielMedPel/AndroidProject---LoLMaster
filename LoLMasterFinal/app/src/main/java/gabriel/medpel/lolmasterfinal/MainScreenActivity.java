package gabriel.medpel.lolmasterfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



public class MainScreenActivity extends AppCompatActivity {
    Button btnSummoner,btnLoLPedia;

    public static String apiKey = "RGAPI-95c72bc7-321e-4dfe-a2ec-b6c2882f90f1";
    public static String version = "11.3.1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnLoLPedia = findViewById(R.id.btnLoLPedia);
        btnSummoner = findViewById(R.id.btnSummoner);

        btnLoLPedia.setOnClickListener(v -> {
            startActivity(new Intent(this, LoLPediaActivity.class));
        });
        btnSummoner.setOnClickListener(v -> {
            startActivity(new Intent(this, SummonerActivity.class));
        });


    }
}