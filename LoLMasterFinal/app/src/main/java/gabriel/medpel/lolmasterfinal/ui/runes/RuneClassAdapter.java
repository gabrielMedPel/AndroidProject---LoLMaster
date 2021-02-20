package gabriel.medpel.lolmasterfinal.ui.runes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.runes.RuneClass;

public class RuneClassAdapter extends RecyclerView.Adapter<RuneClassAdapter.ViewHolder> {
    RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    ArrayList<RuneClass> runeClasses;

    public RuneClassAdapter(ArrayList<RuneClass> runeClasses) {
        this.runeClasses = runeClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View runaClassItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.runasclasses_item, parent,false);
        return new ViewHolder(runaClassItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RuneClass runeClass = runeClasses.get(position);

        holder.tvRuneClassName.setText(runeClass.getRunaClassName());

        Picasso.get().load(runeClass.getUrlRunaClassIcon()).into(holder.ivRuneClassIcon);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                holder.rvSlots.getContext(),
                LinearLayoutManager.VERTICAL,
                false);



        linearLayoutManager.setInitialPrefetchItemCount(runeClass.getSlots().size());

        SlotAdapter slotAdapter = new SlotAdapter(runeClass.getSlots());

        holder.rvSlots.setLayoutManager(linearLayoutManager);
        holder.rvSlots.setAdapter(slotAdapter);
        holder.rvSlots.setRecycledViewPool(recycledViewPool);

    }

    @Override
    public int getItemCount() {
        return runeClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRuneClassName;
        ImageView ivRuneClassIcon;
        RecyclerView rvSlots;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRuneClassName = itemView.findViewById(R.id.tvRunaClassName);
            ivRuneClassIcon = itemView.findViewById(R.id.ivRuneClassIcon);
            rvSlots = itemView.findViewById(R.id.rvSlots);

        }
    }
}
