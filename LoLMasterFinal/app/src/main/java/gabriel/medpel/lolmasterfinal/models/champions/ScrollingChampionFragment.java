package gabriel.medpel.lolmasterfinal.models.champions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.squareup.picasso.Picasso;

import gabriel.medpel.lolmasterfinal.R;

public class ScrollingChampionFragment extends Fragment {
    ImageView ivChampImgInfo;
    TextView tvChampionNameInfo;
    TextView tvChampionTitle;
    TextView tvLore;
    TextView tvAttack;
    TextView tvDefense;
    TextView tvMagic;
    TextView tvDifficulty;
    Button btnBack;
    TextView tvQName;
    TextView tvQDescription;
    ImageView ivQImg;
    TextView tvWName;
    TextView tvWDescription;
    ImageView ivWImg;
    TextView tvEName;
    TextView tvEDescription;
    ImageView ivEImg;
    TextView tvRName;
    TextView tvRDescription;
    ImageView ivRImg;
    TextView tvPassiveName;
    TextView tvPassiveDescription;
    ImageView ivPassiveImg;


    private String name;
    private String urlImage;
    private String title;
    private String lore;
    private String  attack;
    private String defense;
    private String magic;
    private String difficulty;
    private String qName;
    private String qDescription;
    private String qUrlImg;
    private String wName;
    private String wDescription;
    private String wUrlImg;
    private String eName;
    private String eDescription;
    private String eUrlImg;
    private String rName;
    private String rDescription;
    private String rUrlImg;
    private String passiveName;
    private String passiveDescription;
    private String passiveUrlImg;

    public ScrollingChampionFragment(String name, String urlImage, String title, String lore, String attack, String defense, String magic, String difficulty, String qName, String qDescription, String qUrlImg, String wName, String wDescription, String wUrlImg, String eName, String eDescription, String eUrlImg, String rName, String rDescription, String rUrlImg, String passiveName, String passiveDescription, String passiveUrlImg) {
        this.name = name;
        this.urlImage = urlImage;
        this.title = title;
        this.lore = lore;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
        this.difficulty = difficulty;
        this.qName = qName;
        this.qDescription = qDescription;
        this.qUrlImg = qUrlImg;
        this.wName = wName;
        this.wDescription = wDescription;
        this.wUrlImg = wUrlImg;
        this.eName = eName;
        this.eDescription = eDescription;
        this.eUrlImg = eUrlImg;
        this.rName = rName;
        this.rDescription = rDescription;
        this.rUrlImg = rUrlImg;
        this.passiveName = passiveName;
        this.passiveDescription = passiveDescription;
        this.passiveUrlImg = passiveUrlImg;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrolling_champion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivChampImgInfo = view.findViewById(R.id.ivRankImg);
        tvChampionNameInfo = view.findViewById(R.id.tvSummonerName);
        tvChampionTitle = view.findViewById(R.id.tvSummonerLevel);
        tvLore = view.findViewById(R.id.tvRuneDescription);
        tvAttack = view.findViewById(R.id.tvAttack);
        tvDefense = view.findViewById(R.id.tvGoldBuy);
        tvMagic = view.findViewById(R.id.tvMagic);
        tvDifficulty = view.findViewById(R.id.tvGoldSell);
        btnBack = view.findViewById(R.id.btnBack);
        tvQName = view.findViewById(R.id.tvQName);
        tvQDescription = view.findViewById(R.id.tvQDescription);
        ivQImg = view.findViewById(R.id.ivQImg);
        tvWName = view.findViewById(R.id.tvWName);
        tvWDescription = view.findViewById(R.id.tvWDescription);
        ivWImg = view.findViewById(R.id.ivWImg);
        tvEName = view.findViewById(R.id.tvEName);
        tvEDescription = view.findViewById(R.id.tvEDescription);
        ivEImg = view.findViewById(R.id.ivEImg);
        tvRName = view.findViewById(R.id.tvRName);
        tvRDescription = view.findViewById(R.id.tvRDescription);
        ivRImg = view.findViewById(R.id.ivRImg);
        tvPassiveName = view.findViewById(R.id.tvPassiveName);
        tvPassiveDescription = view.findViewById(R.id.tvPassiveDescription);
        ivPassiveImg = view.findViewById(R.id.ivPassiveImg);

        Picasso.get().load(urlImage).into(ivChampImgInfo);
        Picasso.get().load(qUrlImg).into(ivQImg);

        Picasso.get().load(wUrlImg).into(ivWImg);
        Picasso.get().load(eUrlImg).into(ivEImg);
        Picasso.get().load(rUrlImg).into(ivRImg);
        Picasso.get().load(passiveUrlImg).into(ivPassiveImg);

        tvChampionNameInfo.setText(name);
        tvChampionTitle.setText(title);
        tvLore.setText(lore);
        tvAttack.setText(attack);
        tvDefense.setText(defense);
        tvMagic.setText(magic);
        tvDifficulty.setText(difficulty);
        tvQName.setText(qName);
        tvQDescription.setText(qDescription);
        tvWName.setText(wName);
        tvWDescription.setText(wDescription);
        tvEName.setText(eName);
        tvEDescription.setText(eDescription);
        tvRName.setText(rName);
        tvRDescription.setText(rDescription);
        tvPassiveName.setText(passiveName);
        tvPassiveDescription.setText(passiveDescription);



        btnBack.setOnClickListener(v -> {

            AppCompatActivity activity = (AppCompatActivity) getContext();
            activity.getSupportFragmentManager().beginTransaction().remove(this).commit();
        });
    }
}