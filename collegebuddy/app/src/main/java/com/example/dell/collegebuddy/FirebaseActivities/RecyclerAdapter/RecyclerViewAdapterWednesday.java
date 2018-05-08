package com.example.dell.collegebuddy.FirebaseActivities.RecyclerAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.dell.collegebuddy.FirebaseActivities.Monday.Mondaydetails;
import com.example.dell.collegebuddy.R;
import java.util.List;

public class RecyclerViewAdapterWednesday extends RecyclerView.Adapter<RecyclerViewAdapterWednesday.ViewHolder> {

    Context context;
    List<Mondaydetails>FiredbList;

    public RecyclerViewAdapterWednesday(Context context, List<Mondaydetails> TempList) {

        this.FiredbList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firebase_recyclerview_monday_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Mondaydetails mondaydetails = FiredbList.get(position);
        holder.Subject_name_TextView.setText(mondaydetails.getSubject());
        holder.Starting_time_TextView.setText(mondaydetails.getStarting_time());
        holder.Ending_time_TextView.setText(mondaydetails.getEnding_time());
    }

    @Override
    public int getItemCount() {
        return FiredbList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Subject_name_TextView;
        public TextView Starting_time_TextView;
        public TextView Ending_time_TextView;
        public ViewHolder(View itemView) {
            super(itemView);
            Subject_name_TextView = (TextView) itemView.findViewById(R.id.tvSubjectFirebase);
            Starting_time_TextView = (TextView) itemView.findViewById(R.id.fullsubjectFirebase);
            Ending_time_TextView = (TextView) itemView.findViewById(R.id.endtimeFirebase);
        }
    }
}