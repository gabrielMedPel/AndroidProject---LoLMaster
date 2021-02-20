package gabriel.medpel.lolmasterfinal.models.items;

import android.os.Bundle;
import android.text.Html;
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

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;

public class ScrollingItemFragment extends Fragment {
    private ImageView ivItemImgInfo;
    private TextView tvItemNameInfo,tvItemPlainText,tvItemDescription,tvGoldBuy,tvGoldSell,tvTags;
    private ArrayList<String> tags;
    Button btnBack;

    private String itemName;
    private String itmUrlImg;
    private String description;
    private String plainText;
    private String goldBuy;
    private String goldSell;

    public ScrollingItemFragment(ArrayList<String> tags, String itemName, String itmUrlImg, String description, String plainText, String goldBuy, String goldSell) {
        this.tags = tags;
        this.itemName = itemName;
        this.itmUrlImg = itmUrlImg;
        this.description = description;
        this.plainText = plainText;
        this.goldBuy = goldBuy;
        this.goldSell = goldSell;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrolling_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivItemImgInfo = view.findViewById(R.id.ivRankImg);
        tvItemNameInfo = view.findViewById(R.id.tvSummonerName);
        tvItemPlainText = view.findViewById(R.id.tvSummonerLevel);
        tvItemDescription = view.findViewById(R.id.tvRuneDescription);
        tvGoldBuy = view.findViewById(R.id.tvGoldBuy);
        tvGoldSell = view.findViewById(R.id.tvGoldSell);
        tvTags = view.findViewById(R.id.tvTags);
        btnBack = view.findViewById(R.id.btnBack);

        tvItemNameInfo.setText(itemName);
        tvItemPlainText.setText(plainText);
        tvItemDescription.setText(Html.fromHtml(description));
        tvGoldBuy.setText("Buy: " + goldBuy);
        tvGoldSell.setText("Sell: " + goldSell);

        tvTags.setText(tags.toString());

        Picasso.get().load(itmUrlImg).into(ivItemImgInfo);

        btnBack.setOnClickListener(v -> {

            AppCompatActivity activity = (AppCompatActivity) getContext();
            activity.getSupportFragmentManager().beginTransaction().remove(this).commit();
        });
    }
}