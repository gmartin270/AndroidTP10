package com.android.guille.tp10.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.guille.tp10.R;
import com.android.guille.tp10.activity.MainActivity;
import com.android.guille.tp10.adapter.UsersAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsersFragment extends Fragment {

    private ListView list;
    private static UsersAdapter adapter = null;
    View root;

    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(adapter==null) {
            adapter = UsersAdapter.getInstance();
            adapter.setmContext((MainActivity)getActivity());
        }
        root = inflater.inflate(R.layout.fragment_users, container, false);

        list = (ListView) root.findViewById(R.id.listUsers);
        list.setAdapter(adapter);

        /* TODO:  Eliminar hardcode test */
        try {
            JSONObject test = new JSONObject();
            test.put("nombre", "Guillermo");
            test.put("apellido", "Martín");
            test.put("mail", "xguillemartinx@gmail.com");
            test.put("_id", "1");

            JSONArray testArray = new JSONArray();
            testArray.put(test);

            adapter.setList(testArray);
            UsersAdapter.getInstance().notifyDataSetChanged();
        }catch (JSONException e){
            e.printStackTrace();
        }


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    //TODO: Implementar acciones al producirse el evento.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }

}
