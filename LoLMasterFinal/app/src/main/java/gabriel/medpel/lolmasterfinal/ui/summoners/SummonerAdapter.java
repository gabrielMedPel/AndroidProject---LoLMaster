package gabriel.medpel.lolmasterfinal.ui.summoners;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gabriel.medpel.lolmasterfinal.R;
import gabriel.medpel.lolmasterfinal.SummonerActivity;
import gabriel.medpel.lolmasterfinal.models.summoners.ScrollingSummonerFragment;
import gabriel.medpel.lolmasterfinal.models.summoners.SummonerUser;


public class SummonerAdapter extends RecyclerView.Adapter<SummonerAdapter.ViewHolder> {
    List<SummonerUser> summonerUsers;


    public SummonerAdapter(List<SummonerUser> summonerUsers) {
        this.summonerUsers = summonerUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.summoner_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SummonerUser summonerUser = summonerUsers.get(position);
        holder.tvRegionItem.setText(summonerUser.getRegion());
        holder.tvSummonerNameItem.setText(summonerUser.getSummonerName());

        holder.itemView.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            ScrollingSummonerFragment myFragment = new ScrollingSummonerFragment(summonerUser);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .replace(R.id.summonerActivity, myFragment).addToBackStack(null)
                    .commit();
        });
        holder.btnDelete.setOnClickListener(v -> {

            FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("summonerUsers").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    SummonerUser user = snapshot.child(summonerUser.getSummonerName()).getValue(SummonerUser.class);

                    System.out.println(user.getSummonerName());
                    System.out.println(user.getRegion());
                    System.out.println(summonerUser.getSummonerName());
                    System.out.println(summonerUser.getRegion());

                    if (user.equals(summonerUser)){
                        snapshot.child(summonerUser.getSummonerName()).getRef().removeValue();
                    }
                    summonerUsers.remove(position);
                    notifyItemRemoved(position);
                    notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return summonerUsers.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView btnDelete;
        TextView tvSummonerNameItem, tvRegionItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSummonerNameItem = itemView.findViewById(R.id.tvSummonerNameItem);
            tvRegionItem = itemView.findViewById(R.id.tvRegionItem);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
