package gabriel.medpel.lolmasterfinal.ui.runes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gabriel.medpel.lolmasterfinal.R;

public class RunesFragment extends Fragment {

    private RunesViewModel runesViewModelViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        runesViewModelViewModel =
                new ViewModelProvider(this).get(RunesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_runes, container, false);
        RecyclerView rvRuneClasses = root.findViewById(R.id.rvRuneClasses);
        runesViewModelViewModel.getRuneClasses().observe(getViewLifecycleOwner(), runeClasses -> {
            rvRuneClasses.setLayoutManager(new LinearLayoutManager(getContext()));
            RuneClassAdapter runeClassAdapter = new RuneClassAdapter(runeClasses);
            rvRuneClasses.setAdapter(runeClassAdapter);
        });
        return root;
    }
}