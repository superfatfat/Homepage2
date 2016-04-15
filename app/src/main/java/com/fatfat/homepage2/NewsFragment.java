package com.fatfat.homepage2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuser on 2016/4/15.
 */
public class NewsFragment extends Fragment {
    private List<News> newsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newsList = getNewsList();

    }

    private List<News> getNewsList(){
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("The Best of Omaha Steaks Now Only $59.99", 1));
        newsList.add(new News("Medium Session Special, All Meal 30% off", 2));
        newsList.add(new News("Celebrate Mother Day, three courses from $39.99", 3));
        newsList.add(new News("50% for all take away drinks", 4));
        newsList.add(new News("Birthday Party Reservation, Enjoy 25% discount", 5));
        return newsList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.listview,container,false);
        ListView lvNews = (ListView)view.findViewById(R.id.lvNews);
        lvNews.setAdapter(new NewsAdapter(inflater.getContext(),newsList));
        return view;
    }



    private class NewsAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater layoutInflater;
        private  List<News> newsList;
        public NewsAdapter(Context context, List<News> newsList) {
            this.context=context;
            this.layoutInflater=LayoutInflater.from(context);
            this.newsList=newsList;
        }

        @Override
        public int getCount() {
            return newsList.size();
        }

        @Override
        public Object getItem(int position) {
            return newsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return newsList.get(position).getStoreId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            News news = newsList.get(position);
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.news,parent,false);
            }

            TextView tvNews = (TextView) convertView.findViewById(R.id.tvNews);
            tvNews.setText(news.getTitle());
            return convertView;
        }
    }
}
