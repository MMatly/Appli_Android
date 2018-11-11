package com.example.mathi.appli_android;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.List;


public abstract class POIAdapter extends BaseAdapter implements ListAdapter {

        List<POI> biblio;
        LayoutInflater inflater;

        private class ViewHolder {
            TextView tvdisplay;
            ImageView tvmedia;
            TextView tvCountry;
        }
    public POIAdapter(Context context, List<POI> list_objects) {
            inflater = LayoutInflater.from(context);
            this.biblio = list_objects;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {Log.v("test", "convertView is null");
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.poi_item, null);
                holder.tvdisplay = (TextView) convertView.findViewById(R.id.txtDisplay);
                holder.tvCountry = (TextView) convertView
                        .findViewById(R.id.txtCountry);
                holder.tvmedia = (ImageView) convertView.findViewById(R.id.ImageMedia);
                convertView.setTag(holder);
            } else {
                Log.v("test", "convertView is not null");
                holder = (ViewHolder) convertView.getTag();}


            POI destination = biblio.get(position);
            holder.tvCountry.setText(destination.getCountry());
            holder.tvdisplay.setText(destination.getDisplay());
            return convertView;

        }



       @Override
        public int getCount() {
            return biblio.size();
        }

       @Override
       public Object getItem(int position) {
            return biblio.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }
