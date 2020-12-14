package cl.evilcorp.miraza.fragmentsAndAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cl.evilcorp.miraza.databinding.ItemListBreedBinding;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.BreedAdapterVH>{
    private List<String> breedList;
    private OnItemClickListener listener;
    private ItemListBreedBinding binding;

    public BreedAdapter(List<String> breedList, OnItemClickListener plistener) {
        this.breedList = breedList;
        this.listener = plistener;

    }

    public List<String> getBreedList() {
        return breedList;
    }

     @NonNull
    @Override
    public BreedAdapter.BreedAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=ItemListBreedBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        View view=binding.getRoot();
        return new BreedAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedAdapter.BreedAdapterVH holder, int position) {
        String breed= breedList.get(position);
        holder.bind(breed);
    }

    @Override
    public int getItemCount() {
        return breedList.size();
    }

    public void UpdateBreed(List<String> breeds) {
        breedList.clear();
        breedList.addAll(breeds);
        notifyDataSetChanged();
    }

    public class BreedAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private TextView tvBreed;

        public BreedAdapterVH(@NonNull View itemView){
            super(itemView);
            tvBreed=binding.imgBreed;
            itemView.setOnClickListener(this);
        }
        public void bind (String breed){
            tvBreed.setText(breed.toUpperCase());
        }
        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listener.onClick(position);

        }
    }
}
