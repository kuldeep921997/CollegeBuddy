package com.example.dell.collegebuddy;


import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.collegebuddy.Utils.LetterImageView;
import com.example.dell.collegebuddy.scheduleDays.schedule_friday;
import com.example.dell.collegebuddy.scheduleDays.schedule_saturday;
import com.example.dell.collegebuddy.scheduleDays.schedule_sunday;
import com.example.dell.collegebuddy.scheduleDays.schedule_thursday;
import com.example.dell.collegebuddy.scheduleDays.schedule_wednesday;
import com.example.dell.collegebuddy.scheduleDays.schedule_tuesday;

import com.example.dell.collegebuddy.showDaySchedule.showFridaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showSaturdaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showSundaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showThursdaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showTuesdaySchedule;
import com.example.dell.collegebuddy.showDaySchedule.showWednesdaySchedule;


import java.util.List;

public class week_activity extends AppCompatActivity {

    private Toolbar toolbarWeek;
    private ListView listView;
    DataBaseHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_activity);
        List<DatabaseModel> dbList;
        RecyclerView mRecyclerView;
        mydb = new DataBaseHelper(this);

        setupUIViews();
        initToolbar();
        setUpListView();
    }

    private void setupUIViews()
    {
        toolbarWeek=(Toolbar)findViewById(R.id.ToolbarWeek);
        listView=(ListView) findViewById(R.id.lvWeek);

    }

    private void initToolbar(){
        setSupportActionBar(toolbarWeek);
        getSupportActionBar().setTitle("Week Days");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setUpListView()
    {
        String[] week= getResources().getStringArray(R.array.Week);

        weekAdapter adapter = new weekAdapter(this,R.layout.activity_week_single_item,week);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position)
                {
                    case 0: {


                            boolean checkflag;
                            checkflag=mydb.isEmptyMonday();

                            if (checkflag==false) {
                                Intent intent = new Intent(week_activity.this, schedule_monday.class);
                                startActivity(intent);
                            }
                            else {
                                Intent intent = new Intent(week_activity.this, showMondaySchedule.class);
                                startActivity(intent);
                            }
                        }     break ;

                    case 1:{
                        boolean checkflag;
                        checkflag=mydb.isEmptyTuesday();
                        if (checkflag==false)
                        {
                            Intent intent= new Intent(week_activity.this,schedule_tuesday.class);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(week_activity.this, showTuesdaySchedule.class);
                            startActivity(intent);
                        }
                    }
                        break ;
                    case 2: {


                        boolean checkflag;
                        checkflag=mydb.isEmptyWednesday();

                        if (checkflag==false)
                        {

                            Intent intent= new Intent(week_activity.this,schedule_wednesday.class);
                            startActivity(intent);
                        }

                        else{
                            Intent intent = new Intent(week_activity.this,showWednesdaySchedule.class);
                            startActivity(intent);
                        }
                    }
                    break ;

                    case 3: {


                        boolean checkflag;
                        checkflag=mydb.isEmptyThursday();

                        if (checkflag==false)
                        {
                            Intent intent= new Intent(week_activity.this,schedule_thursday.class);
                            startActivity(intent);
                        }

                        else{
                            Intent intent = new Intent(week_activity.this,showThursdaySchedule.class);
                            startActivity(intent);
                        }
                    }
                    break;
                    case 4: {


                        boolean checkflag;
                        checkflag=mydb.isEmptyFriday();

                        if (checkflag==false)
                        {
                            Intent intent= new Intent(week_activity.this,schedule_friday.class);
                            startActivity(intent);
                        }

                        else{
                            Intent intent = new Intent(week_activity.this,showFridaySchedule.class);
                            startActivity(intent);
                        }
                    }
                    break ;
                    case 5:{


                        boolean checkflag;
                        checkflag=mydb.isEmptySaturday();

                        if (checkflag==false)
                        {
                            Intent intent= new Intent(week_activity.this,schedule_saturday.class);
                            startActivity(intent);
                        }

                        else{
                            Intent intent = new Intent(week_activity.this,showSaturdaySchedule.class);
                            startActivity(intent);
                        }
                    }
                        break ;
                    case 6:{


                        boolean checkflag;
                        checkflag=mydb.isEmptySunday();

                        if (checkflag==false)
                        {
                            Intent intent= new Intent(week_activity.this,schedule_sunday.class);
                            startActivity(intent);
                        }

                        else{
                            Intent intent = new Intent(week_activity.this,showSundaySchedule.class);
                            startActivity(intent);
                        }
                    }
                        break ;

                    default:break;

                }
            }
        });
    }



    public class weekAdapter extends ArrayAdapter
    {
        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{} ;


        public weekAdapter(Context context, int resource , String[] objects) {
            super(context,resource,objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            viewHolder holder;
            if(convertView == null)
            {
                holder = new viewHolder();
                convertView = layoutInflater.inflate(resource,null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek =(TextView)convertView.findViewById(R.id.tvWeek);
                convertView.setTag(holder);
            }
            else{
                holder = (viewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.tvWeek.setText(week[position]);
            holder.ivLogo.setLetter(week[position].charAt(0));
            return convertView;
        }

        public class viewHolder{
            private LetterImageView ivLogo ;
            private TextView tvWeek;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home :{
                onBackPressed();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent;
        super.onBackPressed();
        intent= new Intent(week_activity.this,Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
