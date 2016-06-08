package com.android.guille.tp10.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.android.guille.tp10.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsersAdapter extends BaseAdapter {

    private Context mContext;
    private JSONArray usrs = new JSONArray();
    private String id;
    private Log logger;


    private static UsersAdapter instance;

    private UsersAdapter(){}

    public static UsersAdapter getInstance(){
        if(instance == null)
            instance = new UsersAdapter();

        return instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(JSONArray usrs){
        this.usrs = usrs;
        notifyDataSetChanged();
    }

    public JSONArray getUsrs(){
        return this.usrs;
    }

    @Override
    public int getCount() {
        return usrs.length();
    }

    @Override
    public JSONObject getItem(int position) {
        JSONObject result = null;

        try{
            result = usrs.getJSONObject(position);
        }catch (JSONException e){
            logger.i("UsersAdapter", e.getMessage());
        }
        return result;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            JSONObject usr = (JSONObject) getItem(position);
            id = usr.getString("_id");

            if (convertView == null) {
                LayoutInflater li = LayoutInflater.from(mContext);
                convertView = li.inflate(R.layout.item_usr, null);
            }

            try {
                TextView nombres = (TextView) convertView.findViewById(R.id.txtNomCompleto);
                nombres.setText(usr.getString("nombre") + " " + usr.getString("apellido"));

                TextView email = (TextView) convertView.findViewById(R.id.txtEmailV);
                email.setText(usr.getString("mail"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }catch (JSONException e){
            Toast.makeText(mContext,e.getMessage(), Toast.LENGTH_SHORT);
        }

        return convertView;
    }
}
