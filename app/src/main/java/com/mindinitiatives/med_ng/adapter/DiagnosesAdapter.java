package com.mindinitiatives.med_ng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mindinitiatives.med_ng.R;
import com.mindinitiatives.med_ng.data.model.States;
import com.mindinitiatives.med_ng.ui.diagnoses.DiagnosesFragment;

import java.util.List;

    public class DiagnosesAdapter extends RecyclerView.Adapter <DiagnosesAdapter.MyViewHolder>{

        private List<States> states;
        private DiagnosesFragment context;

        public DiagnosesAdapter(List<States> states, DiagnosesFragment context) {
            this.states = states;
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.states_item,parent,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.no_admitted.setText(Integer.toString(states.get(position).getNo_on_admission()));
            holder.no_confirmed.setText(Integer.toString(states.get(position).getNo_of_cases()));
            holder.name_of_state.setText(states.get(position).getStates());
            holder.progress.setProgress(Integer.parseInt(Integer.toString(states.get(position).getNo_on_admission())));
            holder.progress.setMax(Integer.parseInt(Integer.toString(states.get(position).getNo_of_cases())));

        }

        @Override
        public int getItemCount() {
            return states.size();
        }

        public static  class MyViewHolder extends RecyclerView.ViewHolder {

            TextView no_admitted,no_confirmed, name_of_state;
            ProgressBar progress;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                progress = (ProgressBar)itemView.findViewById(R.id.progress);
                no_admitted = (TextView)itemView.findViewById(R.id.admited);
                no_confirmed = (TextView)itemView.findViewById(R.id.total_confirmed);
                name_of_state = (TextView)itemView.findViewById(R.id.state_name);
            }
        }

    }


