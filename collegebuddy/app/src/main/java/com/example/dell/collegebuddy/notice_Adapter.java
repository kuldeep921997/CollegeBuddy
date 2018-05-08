package com.example.dell.collegebuddy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class notice_Adapter extends RecyclerView.Adapter<notice_Adapter.ViewHolder> {

    Context context;
    List<noticeModel>FiredbList;

    public notice_Adapter(Context context, List<noticeModel> TempList) {

        this.FiredbList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_single_notice, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        noticeModel noticeModel = FiredbList.get(position);
        holder.Subject_name_TextView.setText(noticeModel.getSubject());
        holder.Starting_time_TextView.setText(noticeModel.getStarting_time());
        holder.Starting_date_TextView.setText(noticeModel.getStarting_date());
    }

    @Override
    public int getItemCount() {
        return FiredbList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Subject_name_TextView;
        public TextView Starting_time_TextView;
        public TextView Starting_date_TextView;

        public ViewHolder(View itemView) {
            super(itemView);
            Subject_name_TextView = (TextView) itemView.findViewById(R.id.tvSubjectFirebase);
            Starting_time_TextView = (TextView) itemView.findViewById(R.id.StartingTimeFirebase);
            Starting_date_TextView = (TextView) itemView.findViewById(R.id.StartingDateFirebase);
        }
    }
}