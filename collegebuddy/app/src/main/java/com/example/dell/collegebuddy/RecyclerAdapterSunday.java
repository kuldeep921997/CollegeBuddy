package com.example.dell.collegebuddy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.example.dell.collegebuddy.Utils.LetterImageView;
import com.example.dell.collegebuddy.showDaySchedule.showSundaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showWednesdaySchedule;
import com.example.dell.collegebuddy.updateSchedules.update_Sunday;

public class RecyclerAdapterSunday extends RecyclerView.Adapter<RecyclerAdapterSunday.ViewHolder> {

    public static RecyclerView.Adapter mAdapter;
    static   List<DatabaseModelSunday> dbList;
    static  Context context;
    static int selectedPos;
    showSundaySchedule showsunday = new showSundaySchedule();
    public RecyclerAdapter.OnItemClickListner mListner;


    public RecyclerAdapterSunday() {
    }

    public interface OnItemClickListner {
        void OnItemClick(int position);
    }


    public RecyclerAdapterSunday(showSundaySchedule showSundaySchedule , List<DatabaseModelSunday> dbList){
        this.dbList = new ArrayList<DatabaseModelSunday>();
        this.dbList = dbList;
    }

    @Override
    public RecyclerAdapterSunday.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_day_sub_desc, null);
        ViewHolder viewHolderSunday = new ViewHolder(itemLayoutView,mListner);
        return viewHolderSunday;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapterSunday.ViewHolder holder, int position) {

        holder.tvSubject.setText(dbList.get(position).getSubject_name());
        holder.ivLetter.setLetter((dbList.get(position).getSubject_name()).charAt(0));
        holder.sttime.setText(dbList.get(position).getStarting_time());
        holder.endtime.setText(dbList.get(position).getEnd_time());

        holder.ivLetter.setOval(true);
        holder.setLongClickListner(new LongClickListner() {
            @Override
            public void onItemLongClick(int position) {
                System.out.println("kool");
                selectedPos = position;
                notifyItemChanged(holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnCreateContextMenuListener, View.OnLongClickListener {

        public TextView tvSubject,endtime,sttime ;
        LongClickListner longClickListner;
        public LetterImageView ivLetter;

        public ViewHolder(View itemLayoutView, final RecyclerAdapter.OnItemClickListner listner) {
            super(itemLayoutView);

            tvSubject = (TextView) itemLayoutView.findViewById(R.id.tvSubject);
            sttime = (TextView)itemLayoutView.findViewById(R.id.sttime);
            endtime = (TextView) itemLayoutView.findViewById(R.id.endtime);
            ivLetter=(LetterImageView)itemLayoutView.findViewById(R.id.ivLetter);


            itemLayoutView.setOnCreateContextMenuListener(this);
            itemLayoutView.setOnLongClickListener(this);

            itemLayoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listner.OnItemClick(position);
                        }
                    }
                }
            });
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Choose an Action");
            menu.add(0, 0, 0, "Delete");
            menu.add(0, 1, 0, "Update");
        }

        public void setLongClickListner(LongClickListner lc) {
            this.longClickListner = lc;
        }

        @Override
        public boolean onLongClick(View v) {
            this.longClickListner.onItemLongClick(getLayoutPosition());
            return false;
        }
    }

    public void getItemSelected(MenuItem item, Context context) {
        DatabaseModelSunday p = dbList.get(selectedPos);
        String idhere = p.getId();
        Log.d("kool", "this is id no " + item + idhere);


        switch (item.getItemId()) {

            case 0: {
                dbList.remove(selectedPos);
                notifyDataSetChanged();
                showsunday.deletefunction(idhere);


            }
            break;

            case 1: {

                Intent intent = new Intent(context,update_Sunday.class);
                intent.putExtra("id",idhere);
                context.startActivity(intent);
                notifyItemChanged(selectedPos);
                notifyDataSetChanged();
            }
            break;
        }
    }
}
