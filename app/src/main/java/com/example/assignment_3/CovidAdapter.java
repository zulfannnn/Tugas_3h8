package com.example.assignment_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.ViewHolder> {

    private List<Covid> covidList;
    private Context mContext;

    public CovidAdapter(Context context, List<Covid> covids) {
        this.mContext = context;
        this.covidList = covids;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Covid covid = covidList.get(position);

        holder.totalcassesTV.setText(covid.getCasses());
        holder.totalrecoverdTV.setText(covid.getRecovered());
        holder.totaldeathTV.setText(covid.getDeaths());
    }


    @Override
    public int getItemCount() {

        return covidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView totalcassesTV;
        private TextView totalrecoverdTV;
        private TextView totaldeathTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            totalcassesTV = itemView.findViewById(R.id.total_casses);
            totalrecoverdTV = itemView.findViewById(R.id.total_recoverd);
            totaldeathTV = itemView.findViewById(R.id.total_death);
        }
    }
}
