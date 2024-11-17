package com.example.smallapp.main.basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallapp.R;

import java.util.ArrayList;
import java.util.List;

public class KillNoteRecylerAdapter extends RecyclerView.Adapter<KillNoteRecylerAdapter.CustomViewHolder> {

    Context context;
    List<KillNoteModel> list = new ArrayList<>();
    KillNoteRecylerAdapter(Context context,List<KillNoteModel> list){
               this.context = context;
               this.list = list;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(context).inflate(R.layout.kill_note_recycler_layout, parent, false);
        return new CustomViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        KillNoteModel item = list.get(position);

        holder.name.setText(item.getName());
        holder.reason.setText(item.getReason());
      //  holder.image.setImageResource(item.getImageResourceId());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class  CustomViewHolder extends RecyclerView.ViewHolder{
         TextView name,reason;
         ImageView image;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.titleText);
            reason = itemView.findViewById(R.id.subtitleText);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
