package com.example.fragmentdemo;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContentFrag extends Fragment {
    GridView gridview;
    private List<String> imageUrls;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        GridView gridView = view.findViewById(R.id.gridview);

        // Khởi tạo danh sách các URL hình ảnh
        imageUrls = new ArrayList<>();
        imageUrls.add("https://kenh14cdn.com/thumb_w/620/2017/h8-1511154587426.jpg");
        imageUrls.add("https://bidiusta.binhdinh.gov.vn/uploads/news/2022_01/nho-rung-700.jpg");
        imageUrls.add("https://ik.imagekit.io/tvlk/blog/2017/06/truy-lung-dia-chi-cua-30-mon-an-ngon-sai-gon-phan-1-1.jpg?tr=dpr-2,w-675");

        // Tạo adapter và gán danh sách URL hình ảnh vào GridView
        ImageAdapter adapter = new ImageAdapter(getActivity(), imageUrls);
        gridView.setAdapter(adapter);

        return view;
    }
    public void updateContent(int position) {
        ArrayList<String> imageUrlsToShow = new ArrayList<>();

        if (position == 0) {
            imageUrlsToShow.add("https://kenh14cdn.com/thumb_w/620/2017/h8-1511154587426.jpg");
        } else if (position == 1) {
            imageUrlsToShow.add("https://bidiusta.binhdinh.gov.vn/uploads/news/2022_01/nho-rung-700.jpg");
        } else if (position == 2) {
            imageUrlsToShow.add("https://ik.imagekit.io/tvlk/blog/2017/06/truy-lung-dia-chi-cua-30-mon-an-ngon-sai-gon-phan-1-1.jpg?tr=dpr-2,w-675");
        }
        Intent intent = new Intent(requireContext(), Image.class);
        intent.putStringArrayListExtra("myArrayKey", imageUrlsToShow);
        startActivity(intent);
    }

}