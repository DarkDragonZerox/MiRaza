package cl.evilcorp.miraza.fragmentsAndAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.evilcorp.miraza.databinding.ItemListImageBinding;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterVH> {
    private List<String> imageList;
    private ItemListImageBinding binding;
    private OnItemLongClickListener listener;

    public List<String> getImageList() {
        return imageList;
    }

    public ImageAdapter(List<String> imageList, OnItemLongClickListener listener) {
        this.imageList = imageList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ImageAdapter.ImageAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListImageBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        View view =binding.getRoot();
        return new ImageAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterVH holder, int position) {
        String image = imageList.get(position);
        holder.bind(image);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void updateImages(List<String> image){
        imageList.clear();
        imageList.addAll(image);
        notifyDataSetChanged();
    }

    public class ImageAdapterVH extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private ImageView imageV;
        private Context context;

        public ImageAdapterVH(@NonNull View itemView) {
            super(itemView);
            imageV = binding.imgBreed;
            context = itemView.getContext();
            itemView.setOnLongClickListener(this);
        }

        public void bind(String image) {
            Glide.with(context).
                    load(image).
                    override(500, 500).
                    into(imageV);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            listener.onLongClick(position);
            return true;
        }
    }
}
