package com.example.dell.collegebuddy.FirebaseActivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.dell.collegebuddy.Main2Activity;
import com.example.dell.collegebuddy.R;

public class normalUsers extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMain);
        listView = (ListView) findViewById(R.id.lvMain);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("College Buddy");
    }


    private void setupListView() {

        String[] title = getResources().getStringArray(R.array.Week);
        normalUsers.SimpleAdapter simpleAdapter = new normalUsers.SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(normalUsers.this, ShowMondayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(normalUsers.this, ShowTuesdayDetailsActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 2: {
                        Intent intent = new Intent(normalUsers.this, ShowWednesdayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(normalUsers.this, ShowThursdayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: {
                        Intent intent = new Intent(normalUsers.this, ShowFridayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 5: {
                        Intent intent = new Intent(normalUsers.this, ShowSaturdayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case 6: {
                        Intent intent = new Intent(normalUsers.this, ShowSundayDetailsActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
            }

        });
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title;
        private String[] titleArray;

        public SimpleAdapter(Context context, String[] title) {
            mContext = context;
            titleArray = title;
            layoutInflater = LayoutInflater.from(mContext);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.activity_week_single_item, null);
            }

            title = (TextView) convertView.findViewById(R.id.tvWeek);
            title.setText(titleArray[position]);
            return convertView;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
        public void onBackPressed() {
            Intent intent;
            super.onBackPressed();
            intent = new Intent(normalUsers.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);

        }

}
