package com.fatfat.homepage2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuser on 2016/4/15.
 */
public class StoreFragment extends Fragment {
    private List<Store> storeList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        storeList = getStoreList();

    }

    private List<Store> getStoreList() {
        List<Store> storeList = new ArrayList<>();
        storeList.add(new Store(R.drawable.store1,"store1"));
        storeList.add(new Store(R.drawable.store2,"store2"));
        storeList.add(new Store(R.drawable.store3,"store3"));
        storeList.add(new Store(R.drawable.store4,"store4"));
        storeList.add(new Store(R.drawable.store5,"store5"));
        storeList.add(new Store(R.drawable.store6,"store6"));
        storeList.add(new Store(R.drawable.store7,"store7"));
        storeList.add(new Store(R.drawable.store8,"store8"));
        return storeList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.store_fragment,container,false);
        ListView lvNews = (ListView)view.findViewById(R.id.lvNews);
        lvNews.setAdapter(new StoreAdapter(inflater.getContext(),storeList));
        return view;
    }



    private class StoreAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater layoutInflater;
        private  List<Store> storeList;
        public StoreAdapter(Context context, List<Store> storeList) {
            this.context=context;
            this.layoutInflater=LayoutInflater.from(context);
            this.storeList=storeList;
        }

        @Override
        public int getCount() {
            return storeList.size();
        }

        @Override
        public Object getItem(int position) {
            return storeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return  storeList.get(position).getPhoto();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Store store = storeList.get(position);
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.store,parent,false);
            }
            ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhoto);
            ivPhoto.setImageResource(store.getPhoto());

            TextView tvStore = (TextView) convertView.findViewById(R.id.tvStore);
            tvStore.setText(store.getName());
            return convertView;
        }
    }
}
