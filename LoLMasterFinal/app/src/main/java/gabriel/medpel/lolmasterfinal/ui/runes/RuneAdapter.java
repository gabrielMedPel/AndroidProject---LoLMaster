package gabriel.medpel.lolmasterfinal.ui.runes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.items.ScrollingItemFragment;
import gabriel.medpel.lolmasterfinal.models.runes.Rune;
import gabriel.medpel.lolmasterfinal.models.runes.ScrollingRuneFragment;

public class RuneAdapter extends RecyclerView.Adapter<RuneAdapter.ViewHolder> {
    ArrayList<Rune> runes;

    public RuneAdapter(ArrayList<Rune> runes) {
        this.runes = runes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View runaItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.runa_item, parent,false);
        return new ViewHolder(runaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rune rune = runes.get(position);

        Picasso.get().load(rune.getUrlRunaIcon()).into(holder.ivRuneIconFinal);
        System.out.println(holder.ivRuneIconFinal.getDrawable());


        holder.itemView.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            ScrollingRuneFragment myFragment = new ScrollingRuneFragment(rune.getRunaName(),rune.getDescription(),rune.getUrlRunaIcon());
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .add(R.id.runes, myFragment).addToBackStack(null)
                    .commit();
        });
    }
    @Override
    public int getItemCount() {
        return runes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRuneIconFinal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivRuneIconFinal = itemView.findViewById(R.id.ivRuneIconFinal);
        }
    }
}
