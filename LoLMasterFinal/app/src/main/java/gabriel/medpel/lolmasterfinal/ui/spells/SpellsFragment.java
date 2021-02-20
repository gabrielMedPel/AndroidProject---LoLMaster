package gabriel.medpel.lolmasterfinal.ui.spells;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.ui.runes.RunesViewModel;

public class SpellsFragment extends Fragment {

    private SpellsViewModel spellsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        spellsViewModel =
                new ViewModelProvider(this).get(SpellsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_spells, container, false);
        RecyclerView rvSpells = root.findViewById(R.id.rvSpells);
        spellsViewModel.getSpell().observe(getViewLifecycleOwner(),  spells -> {
            rvSpells.setLayoutManager(new LinearLayoutManager(getContext()));
            SpellAdapter adapter = new SpellAdapter(spells);
            rvSpells.setAdapter(adapter);
        });
        return root;
    }

}