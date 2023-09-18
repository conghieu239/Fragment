package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.MenuFrag, new MenuFrag());
        transaction.replace(R.id.ContentFrag, new ContentFrag());


        transaction.commit();
    }

    @Override
    public void onMenuItemClick(int position) {
        ContentFrag content =
                (ContentFrag)getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        if(content!=null)
            content.updateContent(position);
    }

}
