package com.example.dell.collegebuddy.FirebaseActivities ;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.fridayschedule;
import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.saturdayschedule;
import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.sundayschedule;
import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.thursdayschedule;
import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.tuesdayschedule;
import com.example.dell.collegebuddy.FirebaseActivities.setdayschedule.wednesdayschedule;
import com.example.dell.collegebuddy.R;
import com.example.dell.collegebuddy.Utils.LetterImageView;

public class OneFragment extends Fragment{

    public ListView listView;
    public OneFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.firebase_scheduler, container, false);
        listView = (ListView) v.findViewById(R.id.lvMain);
        setupListView();

        return v;
    }

    private void setupListView() {

        String[] title = getResources().getStringArray(R.array.Week);
        OneFragment.SimpleAdapter simpleAdapter = new OneFragment.SimpleAdapter(getActivity(), title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Intent intent = new Intent(getActivity(),online.class);
                        startActivity(intent);
                        break;
                    }

                    case 1: {
                        Intent intent = new Intent(getActivity(), tuesdayschedule.class);
                        startActivity(intent);
                        break;

                    }
                    case 2: {
                        Intent intent = new Intent(getActivity(), wednesdayschedule.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(getActivity(), thursdayschedule.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: {
                        Intent intent = new Intent(getActivity(), fridayschedule.class);
                        startActivity(intent);
                        break;
                    }

                    case 5: {
                        Intent intent = new Intent(getActivity(), saturdayschedule.class);
                        startActivity(intent);
                        break;
                    }

                    case 6: {
                        Intent intent = new Intent(getActivity(), sundayschedule.class);
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
        private LetterImageView ivLogo ;
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
            ivLogo = (LetterImageView) convertView.findViewById(R.id.ivLetter);

            title.setText(titleArray[position]);
            ivLogo.setOval(true);
            ivLogo.setLetter(titleArray[position].charAt(0));
            return convertView;

        }
    }

}