package gabriel.medpel.lolmasterfinal.models.runes;

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

import gabriel.medpel.lolmasterfinal.R;

public class ScrollingRuneFragment extends Fragment {
    ImageView ivRuneIcon;
    TextView tvRuneName,tvRuneDescription;
    Button btnBack;

    private String runeName;
    private String runeDescription;
    private String runeIconUrl;

    public ScrollingRuneFragment(String runeName, String runeDescription, String runeIconUrl) {
        this.runeName = runeName;
        this.runeDescription = runeDescription;
        this.runeIconUrl = runeIconUrl;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrolling_runa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivRuneIcon = view.findViewById(R.id.ivRankImg);
        tvRuneName = view.findViewById(R.id.tvSummonerName);
        tvRuneDescription = view.findViewById(R.id.tvRuneDescription);
        btnBack = view.findViewById(R.id.btnBack);

        tvRuneName.setText(runeName);
        tvRuneDescription.setText(Html.fromHtml(runeDescription));

        Picasso.get().load(runeIconUrl).into(ivRuneIcon);

        btnBack.setOnClickListener(v -> {

            AppCompatActivity activity = (AppCompatActivity) getContext();
            activity.getSupportFragmentManager().beginTransaction().remove(this).commit();
        });
    }
}