package gabriel.medpel.lolmasterfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import gabriel.medpel.lolmasterfinal.models.summoners.SummonerUser;
import gabriel.medpel.lolmasterfinal.ui.summoners.SummonerAdapter;

public class SummonerActivity extends AppCompatActivity {
    private TextView tvLoading;
    private  String region, summonerName;
    private String[] regions;
    private DatabaseReference myReff;
    private SummonerAdapter adapter;
    private ArrayList<SummonerUser> summonerUsers;
    private RecyclerView rvSummoner;
    private String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        rvSummoner = findViewById(R.id.rvSummoner);
        Button btnClean = findViewById(R.id.btnClean);
        Button btnAdd = findViewById(R.id.btnAdd);
        tvLoading = findViewById(R.id.tvLoading);
        regions = new String[]{"BR", "EUN", "EUW", "JP", "KR", "LA1", "LA2", "NA", "OC", "TR", "RU"};
        userName = FirebaseAuth.getInstance().getCurrentUser().getUid();
        myReff = FirebaseDatabase.getInstance().getReference().child("users").child(userName).child("summonerUsers");

        rvSummoner.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        summonerUsers = new ArrayList<>();

        adapter = new SummonerAdapter(summonerUsers);
        rvSummoner.setAdapter(adapter);


        myReff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                summonerUsers.clear();
                if (snapshot.hasChildren()){
                    for (DataSnapshot child : snapshot.getChildren()){
                        SummonerUser summonerUser = child.getValue(SummonerUser.class);

                        summonerUsers.add(summonerUser);
                    }
                }
                updateUI();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnAdd.setOnClickListener(v -> {
            EditText editText = new EditText(getApplicationContext());
            region = "";
            summonerName = "";

            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Choose the Region: ").setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
            });
            b.setItems(regions, (dialog, which) -> {

                switch (which) {
                    case 0:
                        region = "br1";
                        break;
                    case 1:
                        region = "eun1";
                        break;
                    case 2:
                        region = "euw1";
                        break;
                    case 3:
                        region = "jp1";
                        break;
                    case 4:
                        region = "kr";
                        break;
                    case 5:
                        region = "la1";
                        break;
                    case 6:
                        region = "la2";
                        break;
                    case 7:
                        region = "na1";
                        break;
                    case 8:
                        region = "oc1";
                        break;
                    case 9:
                        region = "tr1";
                        break;
                    case 10:
                        region = "ru";
                        break;
                }
                dialog.dismiss();
                AlertDialog.Builder b2 = new AlertDialog.Builder(this);
                b2.setTitle("Summoner Name: ").setView(editText).setNegativeButton("Cancel", (dialog2, which2) -> {
                    dialog2.dismiss();
                }).setPositiveButton("Save", ((dialog1, which1) -> {
                    summonerName = editText.getText().toString();
                    SummonerUser summonerUser = new SummonerUser(region, summonerName);

                    myReff.child(summonerName).setValue(summonerUser);

                    summonerUsers.add(summonerUser);
                    updateUI();

                    Toast.makeText(this, "SAVED !", Toast.LENGTH_SHORT).show();
                }));
                b2.show();

            });
            b.show();
        });
        btnClean.setOnClickListener(v -> {
            myReff.removeValue();
            summonerUsers.clear();

            System.out.println("Cleaned");
            updateUI();

        });
    }

    public void updateUI(){
        adapter.notifyDataSetChanged();
        if (summonerUsers.isEmpty()){
            tvLoading.setText("You need to add a Summoner");
        }else{
            tvLoading.setText("Choose a Summoner to see the info:");
        }
        System.out.println(summonerUsers.size());
    }

    public void deleteItem(int position){
        summonerUsers.remove(position);
        rvSummoner.removeViewAt(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, summonerUsers.size());
        adapter.notifyDataSetChanged();
    }
}