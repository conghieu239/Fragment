package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFrag extends Fragment {

    String[] menus = {"Flowers", "Animals", "Foods"};
    public interface IFragmentClickListener{
        public void onMenuItemClick(int position);
    }

    IFragmentClickListener itemfragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            itemfragment = (IFragmentClickListener) context;
        }
        catch(ClassCastException e){
            e.printStackTrace();
        }
    }

    ListView list;
    private ContentFrag contentFrag;

    private AdapterView.OnItemClickListener onclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (contentFrag!= null)
                contentFrag.updateContent(position);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        list= view.findViewById(R.id.listview);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, menus);
        list.setAdapter(listAdapter);
        if (contentFrag == null)
            contentFrag = (ContentFrag) requireActivity().getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        list.setOnItemClickListener(onclick);
        return view;
    }
}