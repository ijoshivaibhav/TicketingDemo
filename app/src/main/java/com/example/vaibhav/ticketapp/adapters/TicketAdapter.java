package com.example.vaibhav.ticketapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vaibhav.ticketapp.models.MoviePojo;
import com.example.vaibhav.ticketapp.R;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    Context context;
    List<MoviePojo> list;
    Customclick customclick;

    public TicketAdapter(Context context, List<MoviePojo> list, Customclick customclick) {
        this.context = context;
        this.list = list;
        this.customclick = customclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final MoviePojo pos = list.get(i);

        viewHolder.tv_name.setText(pos.getTitle());

        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customclick.onClick(v, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface Customclick {
        void onClick(View view, int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        Button btnShow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            btnShow = itemView.findViewById(R.id.btnShow);

        }
    }
}
