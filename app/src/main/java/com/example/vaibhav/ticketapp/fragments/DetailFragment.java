package com.example.vaibhav.ticketapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vaibhav.ticketapp.models.MoviePojo;
import com.example.vaibhav.ticketapp.R;
import com.example.vaibhav.ticketapp.activities.MainActivity;

import java.util.List;

public class DetailFragment extends Fragment {
    public static TextView name;
    public static TextView rating;
    public static TextView release;
    public static TextView genres;
    public static LinearLayout ll_upper;
    ImageView poster;

   public static TextView label_1, label_2, label_3, label_4;

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
        label_1 = (TextView) view.findViewById(R.id.label_1);
        label_2 = (TextView) view.findViewById(R.id.label_2);
        label_3 = (TextView) view.findViewById(R.id.label_3);
        label_4 = (TextView) view.findViewById(R.id.label_4);
        ll_upper = (LinearLayout) view.findViewById(R.id.ll_upper);
        poster = (ImageView) view.findViewById(R.id.poster);
        mContext = getActivity();


    }

    public void displayReceivedData(MoviePojo pojo) {
        try {
            if (!ll_upper.isShown())
            ll_upper.setVisibility(View.VISIBLE);
            String str = "";
            label_1.setText("Movie Name :");
            label_2.setText("Rating :");
            label_3.setText("Release Year :");
            label_4.setText("Genres :");
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
