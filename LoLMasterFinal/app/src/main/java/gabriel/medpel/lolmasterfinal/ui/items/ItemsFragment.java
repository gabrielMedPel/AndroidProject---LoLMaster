package gabriel.medpel.lolmasterfinal.ui.items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gabriel.medpel.lolmasterfinal.R;

public class ItemsFragment extends Fragment {

    private ItemsViewModel itemsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        itemsViewModel =
                new ViewModelProvider(this).get(ItemsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_items, container, false);
        RecyclerView rvItems = root.findViewById(R.id.rvItems);
        itemsViewModel.getItem().observe(getViewLifecycleOwner(), items -> {
            rvItems.setLayoutManager(new GridLayoutManager(getContext(),5));
            ItemsAdapter adapter = new ItemsAdapter(items);
            rvItems.setAdapter(adapter);
        });

        return root;
    }
}