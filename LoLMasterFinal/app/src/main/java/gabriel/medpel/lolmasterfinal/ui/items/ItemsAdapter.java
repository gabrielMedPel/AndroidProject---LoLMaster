package gabriel.medpel.lolmasterfinal.ui.items;

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
import gabriel.medpel.lolmasterfinal.models.items.Item;
import gabriel.medpel.lolmasterfinal.models.items.ScrollingItemFragment;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    ArrayList<Item> items = new ArrayList<>();

    public ItemsAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent,false);
        return new ViewHolder(itemItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);

        holder.tvItemName.setText(item.getItemName());

        Picasso.get().load(item.getItmUrlImg()).into(holder.ivItemImg);


        holder.itemView.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            ScrollingItemFragment myFragment = new ScrollingItemFragment(item.getTags(),item.getItemName(),item.getItmUrlImg(),item.getDescription(),item.getPlainText(),item.getGoldBuy(),item.getGoldSell());
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .add(R.id.itemCard, myFragment).addToBackStack(null)
                    .commit();

        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemImg;
        TextView tvItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItemImg = itemView.findViewById(R.id.ivItemImg);
            tvItemName = itemView.findViewById(R.id.tvItemName);
        }
    }
}
