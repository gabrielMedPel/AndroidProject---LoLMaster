package gabriel.medpel.lolmasterfinal.ui.spells;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.spells.Spell;
import gabriel.medpel.lolmasterfinal.ui.runes.RuneAdapter;

public class SpellAdapter extends RecyclerView.Adapter<SpellAdapter.ViewHolder> {
    ArrayList<Spell> spells = new ArrayList<>();


    public SpellAdapter(ArrayList<Spell> spells) {
        this.spells = spells;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.spell_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spell spell = spells.get(position);

        holder.tvSpellName.setText(spell.getSpellName());
        holder.tvSpellDescription.setText(spell.getSpellDescription());
        System.out.println(spell.getSpellDescription());
        holder.tvCooldown.setText(spell.getCooldown());

        Picasso.get().load(spell.getSpellUrlImg()).into(holder.ivSpellImg);
    }

    @Override
    public int getItemCount() {
        return spells.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSpellImg;
        TextView tvSpellName, tvSpellDescription, tvCooldown;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSpellImg = itemView.findViewById(R.id.ivSpellImg);
            tvSpellName = itemView.findViewById(R.id.tvSpellName);
            tvSpellDescription = itemView.findViewById(R.id.tvSpellDescription);
            tvCooldown = itemView.findViewById(R.id.tvCooldown);


        }
    }
}
