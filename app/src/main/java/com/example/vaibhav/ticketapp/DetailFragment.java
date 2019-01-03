package com.example.vaibhav.ticketapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DetailFragment extends Fragment {
    static TextView name;
    static TextView rating;
    static TextView release;
    static TextView genres;
    static ImageView poster;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = getActivity();

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = (TextView) view.findViewById(R.id.name);
        rating = (TextView) view.findViewById(R.id.rating);
        release = (TextView) view.findViewById(R.id.release);
        genres = (TextView) view.findViewById(R.id.genres);
        poster = (ImageView) view.findViewById(R.id.poster);
        mContext = getActivity();


    }

    public void displayReceivedData(MoviePojo pojo) {
        try {


            String str = "";
            name.setText(pojo.getTitle());
            rating.setText(pojo.getRating());
            release.setText(pojo.getReleaseYear());
            List<String> list = pojo.getGenre();
            for (int i = 0; i < list.size(); i++) {
                str = str + list.get(i) + ",";
            }
//            Glide.with(getMyActivity())
//                    .load(pojo.getImage())
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .error(R.drawable.ic_launcher_background)
//                    .into(poster);
            if (str != null)
                genres.setText(str.substring(0, str.length() - 1));

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public MainActivity getMyActivity() {

        return ((MainActivity) getActivity());
    }

}
