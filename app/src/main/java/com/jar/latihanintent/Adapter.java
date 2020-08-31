package com.jar.latihanintent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Item> data;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickListener) {
        this.onItemClickCallback = onItemClickListener;
    }


    Adapter(Context context, List<Item> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        //Bind View with Data

        Item item = data.get(position);
        Glide.with(holder.itemView.getContext())
                .load(item.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imageView);

        holder.textTitle.setText(item.getTitle());
        holder.textDesc.setText(item.getDesc());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle, textDesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //onclick listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //start new intent
                    Intent moveWithDataIntent = new Intent(view.getContext(), DetailsActivity.class);
                    moveWithDataIntent.putExtra(DetailsActivity.EXTRA_TITLE, data.get(getAdapterPosition()).getTitle());
                    moveWithDataIntent.putExtra(DetailsActivity.EXTRA_DESC, data.get(getAdapterPosition()).getDesc());
                    moveWithDataIntent.putExtra(DetailsActivity.EXTRA_IMAGE, data.get(getAdapterPosition()).getImage());
                    view.getContext().startActivity(moveWithDataIntent);
                }
            });
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }
    public interface OnItemClickCallback{
        void onItemClicked(Item item);
    }
}
