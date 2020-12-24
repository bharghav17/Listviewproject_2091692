package com.example.Listviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Listviewadapter extends RecyclerView.Adapter<Listviewadapter.ViewHolder> {

    private ArrayList<Listview> listview = new ArrayList<>();
    private Context context;


    public Listviewadapter(Context context, ArrayList<Listview> listview) {
        this.listview = listview;
        this.context = context;
    }

    @NonNull
    @Override
    public Listviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new Listviewadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Listviewadapter.ViewHolder viewHolder, int i) {
        viewHolder.repository_name.setText(listview.get(i).getName());
        viewHolder.owner_name.setText(listview.get(i).getOwner().getLogin());
    }

    @Override
    public int getItemCount() {
        return listview.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView repository_name, owner_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            owner_name = (TextView) itemView.findViewById(R.id.ownerName);
            repository_name = (TextView) itemView.findViewById(R.id.repositoryName);
        }
    }
}
