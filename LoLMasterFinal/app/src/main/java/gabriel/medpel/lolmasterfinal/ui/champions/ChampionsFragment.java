package gabriel.medpel.lolmasterfinal.ui.champions;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gabriel.medpel.lolmasterfinal.LoLPediaActivity;
import gabriel.medpel.lolmasterfinal.MainScreenActivity;
import gabriel.medpel.lolmasterfinal.R;

public class ChampionsFragment extends Fragment {

    private ChampionsViewModel championsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        championsViewModel =
                new ViewModelProvider(this).get(ChampionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_champions, container, false);

        root.setFocusableInTouchMode(true);
        root.requestFocus();
        root.setOnKeyListener((v, keyCode, event) -> {

            if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                startActivity(new Intent(getContext(), MainScreenActivity.class));
                return true;
            }
            return false;
        });

        RecyclerView rvChampions = root.findViewById(R.id.rvChampions);

        championsViewModel.getChamp().observe(getViewLifecycleOwner(), champions -> {
            rvChampions.setLayoutManager(new GridLayoutManager( getContext(),4));
            ChampionsAdapter adapter = new ChampionsAdapter(champions,getContext());
            rvChampions.setAdapter(adapter);
        });
        return root;
    }

}