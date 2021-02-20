package gabriel.medpel.lolmasterfinal.ui.runes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.runes.Slot;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ViewHolder> {
    RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    ArrayList<Slot> slots;


    public SlotAdapter(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View slotItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.slot_item, parent,false);

        return new ViewHolder(slotItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Slot slot = slots.get(position);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                holder.rvRunes.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);



        linearLayoutManager.setInitialPrefetchItemCount(slot.getRunes().size());

        RuneAdapter runeAdapter = new RuneAdapter(slot.getRunes());

        holder.rvRunes.setLayoutManager(linearLayoutManager);
        holder.rvRunes.setAdapter(runeAdapter);
        holder.rvRunes.setRecycledViewPool(recycledViewPool);



    }

    @Override
    public int getItemCount() {
        return slots.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvRunes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvRunes = itemView.findViewById(R.id.rvRunes);
        }
    }
}
