package com.example.recyclerViewJsonParsing;

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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private ArrayList<cardView> cardViewArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    RecyclerViewAdapter(Context context, ArrayList<cardView> cardViewArrayList) {
        this.context = context;
        this.cardViewArrayList = cardViewArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        cardView currentItem = cardViewArrayList.get(position);
        StringBuilder stringBuilder = new StringBuilder();

        String imageUrl = currentItem.getUrl();
        String CreatorName = currentItem.getCreatorName();
        int Likes = currentItem.getLikes();

        holder.textViewCreatorName.setText(CreatorName);
        holder.textViewLikes.setText(stringBuilder.append("Likes: ").append(" ").append(Likes));
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return cardViewArrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textViewCreatorName;
        private TextView textViewLikes;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ImageViewId);
            textViewCreatorName = itemView.findViewById(R.id.CreatorId);
            textViewLikes = itemView.findViewById(R.id.LikeId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
