package com.example.dell.collegebuddy.FirebaseActivities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.Utils.LetterImageView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    Context context;
    List<subjects>FiredbList;

    public SubjectAdapter(Context context, List<subjects> TempList) {

        this.FiredbList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_subject_single, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        subjects subject1 = FiredbList.get(position);
        holder.Subject_name_TextView.setText(subject1.getSubject());
        holder.Full_Subject_TextView.setText(subject1.getFullsubject());
        holder.Full_Subject_Type.setText(subject1.getSubjetType());
        holder.ivLetter.setLetter((subject1.getSubject()).charAt(0));
        holder.ivLetter.setOval(true);
    }

    @Override
    public int getItemCount() {
        return FiredbList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Subject_name_TextView;
        public LetterImageView ivLetter;
        public TextView Full_Subject_TextView,Full_Subject_Type;
        public ViewHolder(View itemView) {
            super(itemView);
            Subject_name_TextView = (TextView) itemView.findViewById(R.id.SubjectFirebase);
            Full_Subject_TextView = (TextView) itemView.findViewById(R.id.fullsubjectFirebase);
            Full_Subject_Type = (TextView) itemView.findViewById(R.id.subjectTypeFirebase);
            ivLetter = (LetterImageView)itemView.findViewById(R.id.ivLetterFirebase);

        }
    }
}