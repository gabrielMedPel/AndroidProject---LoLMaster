package gabriel.medpel.lolmasterfinal.ui.champions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.models.champions.Champion;
import gabriel.medpel.lolmasterfinal.models.champions.ScrollingChampionFragment;

public class ChampionsAdapter extends RecyclerView.Adapter<ChampionsAdapter.ViewHolder> {
    ArrayList<Champion> champions = new ArrayList<>();
    Context ctx;

    public ChampionsAdapter(ArrayList<Champion> champions, Context ctx) {
        this.champions = champions;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View championItem = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.champion_item,
                parent,
                false
        );
        return new ViewHolder(championItem);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Champion champion = champions.get(position);

        holder.tvChampName.setText(champion.getName());



        Picasso.get().load(champion.getSquareImg()).into(holder.ivChampImg);

        holder.itemView.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            ScrollingChampionFragment myFragment = new ScrollingChampionFragment(champion.getName(),champion.getUrlImage(),champion.getTitle(),champion.getLore(),champion.getAttack(),champion.getDefense(),champion.getMagic(),champion.getDifficulty(),champion.getSpells().getqName(),champion.getSpells().getqDescription(),champion.getSpells().getqUrlImg(),champion.getSpells().getwName(),champion.getSpells().getwDescription(),champion.getSpells().getwUrlImg(),champion.getSpells().geteName(),champion.getSpells().geteDescription(),champion.getSpells().geteUrlImg(),champion.getSpells().getrName(),champion.getSpells().getrDescription(),champion.getSpells().getrUrlImg(),champion.getSpells().getPassiveName(),champion.getSpells().getPassiveDescription(),champion.getSpells().getPassiveUrlImg());
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .add(R.id.championCard, myFragment).addToBackStack(null)
                    .commit();

        });
    }

    @Override
    public int getItemCount() {
        return champions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivChampImg;
        TextView tvChampName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChampImg = itemView.findViewById(R.id.ivRankImg);
            tvChampName = itemView.findViewById(R.id.tvSummonerName);
        }
    }
}
