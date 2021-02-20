package gabriel.medpel.lolmasterfinal.models.summoners;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;

import java.io.UnsupportedEncodingException;

import gabriel.medpel.lolmasterfinal.R;

public class ScrollingSummonerFragment extends Fragment {
    private SummonerUser summonerUser;

    TextView tvSummonerName,tvSummonerLevel, tvRegion, tvLeagueName,tvTier,tvRank,tvWins,tvLosses,tvLeaguePoints;
    ImageView ivRankImg;
    Button btnBack;

    public ScrollingSummonerFragment() {
    }

    public void toast(){
    Toast.makeText(this.getContext(), "User Not found or not Ranked!!", Toast.LENGTH_SHORT).show();
}
    public ScrollingSummonerFragment(SummonerUser summonerUser) {
        this.summonerUser = summonerUser;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrolling_summoner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        tvSummonerName = view.findViewById(R.id.tvSummonerName);
        tvSummonerLevel = view.findViewById(R.id.tvSummonerLevel);
        tvRegion = view.findViewById(R.id.tvRegion);
        ivRankImg = view.findViewById(R.id.ivRankImg);
        tvLeagueName = view.findViewById(R.id.tvLeagueName);
        tvTier = view.findViewById(R.id.tvTier);
        tvRank = view.findViewById(R.id.tvRank);
        tvWins = view.findViewById(R.id.tvWins);
        tvLosses = view.findViewById(R.id.tvLosses);
        tvLeaguePoints = view.findViewById(R.id.tvLeaguePoints);
        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            back();
        });





        SummonerDataSource ds = new SummonerDataSource(summonerUser.getRegion(),summonerUser.getSummonerName());
        MutableLiveData<SummonerFull> summonerFullMutableLiveData = new MutableLiveData<>();

        try {
            ds.readDemo(summonerFullMutableLiveData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




        summonerFullMutableLiveData.observe(getViewLifecycleOwner(), summonerFull -> {

            if (!summonerFull.getSummonerName().equals("")){
                tvSummonerName.setText(summonerFull.getSummonerName());
                tvRegion.setText(summonerFull.getRegion());
                tvSummonerLevel.setText(summonerFull.getSummonerLevel());
                tvLeagueName.setText(summonerFull.getLeagueName());
                tvTier.setText(summonerFull.getTier());
                tvRank.setText(summonerFull.getRank());
                tvWins.setText(summonerFull.getWins());
                tvLosses.setText(summonerFull.getLosses());
                tvLeaguePoints.setText(summonerFull.getLeaguePoints());

                switch (summonerFull.getTier()){
                    case "IRON":
                        ivRankImg.setImageResource(R.drawable.iron);
                        break;
                    case "BRONZE":
                        ivRankImg.setImageResource(R.drawable.bronze);
                        break;
                    case "SILVER":
                        ivRankImg.setImageResource(R.drawable.silver);
                        break;
                    case "GOLD":
                        ivRankImg.setImageResource(R.drawable.gold);
                        break;
                    case "PLATINUM":
                        ivRankImg.setImageResource(R.drawable.platinum);
                        break;
                    case "DIAMOND":
                        ivRankImg.setImageResource(R.drawable.diamond);
                        break;
                    case "MASTER":
                        ivRankImg.setImageResource(R.drawable.master);
                        break;
                    case "GRANDMASTER":
                        ivRankImg.setImageResource(R.drawable.grandmaster);
                        break;
                    case "CHALLENGER":
                        ivRankImg.setImageResource(R.drawable.challenger);
                        break;
                }
            }else{
                tvSummonerName.setText("Summoner Not Found or Not Ranked");
                tvSummonerName.postDelayed(() -> {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.popBackStack();
                },3000);
            }

        });
    }
    public void back(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
    }
}