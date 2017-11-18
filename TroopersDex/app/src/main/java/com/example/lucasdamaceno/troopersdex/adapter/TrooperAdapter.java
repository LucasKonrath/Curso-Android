package com.example.lucasdamaceno.troopersdex.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucasdamaceno.troopersdex.R;
import com.example.lucasdamaceno.troopersdex.model.Trooper;
import com.example.lucasdamaceno.troopersdex.utils.ResourceUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public class TrooperAdapter extends RecyclerView.Adapter<TrooperAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Trooper> troopers;

    private OnItemClickListener onItemClickListener;

    private View.OnLongClickListener onLongClickListener;

    public TrooperAdapter(ArrayList<Trooper> troopers, OnItemClickListener listener,
                          View.OnLongClickListener onLongClickListener) {
        this.troopers = troopers;
        this.onItemClickListener = listener;
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_trooper, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trooper trooper = troopers.get(position);

        holder.tvTrooperName.setText(trooper.getName());
        holder.imvTrooperAffiliation.setImageResource(ResourceUtils.getResourceBasedOnAffiliation(trooper.getAffiliation()));
        holder.separator.setVisibility(position == troopers.size() - 1 ? View.INVISIBLE : View.VISIBLE);
        holder.itemView.setTag(trooper);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(onLongClickListener);
    }

    @Override
    public int getItemCount() {
        return troopers.size();
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick((Trooper) v.getTag());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTrooperName;

        ImageView imvTrooperAffiliation;

        View separator;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTrooperName = itemView.findViewById(R.id.trooper_name_tv);
            imvTrooperAffiliation = itemView.findViewById(R.id.trooper_affiliation_imv);
            separator = itemView.findViewById(R.id.separator);
        }
    }

    public interface OnItemClickListener {

        public void onItemClick(Trooper trooper);
    }
}
