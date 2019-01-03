package com.example.vaibhav.ticketapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentTabOne extends Fragment {
    RecyclerView recView;
    TicketAdapter adapter;
    Context mContext;
    SendData SM;

    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_tab_one, container, false);

        recView = view.findViewById(R.id.recView);
        mContext = getActivity();

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        callWebAPI();

        return view;
    }

    private void callWebAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //creating the api interface
        ApiInterface api = retrofit.create(ApiInterface.class);

        //now making the call object
        //Here we are using the api method that we created inside the api interface
        Call<List<MoviePojo>> call = api.getHeroes();

        //then finallly we are making the call using enqueue()
        //it takes callback interface as an argument
        //and callback is having two methods onRespnose() and onFailure
        //if the request is successfull we will get the correct response and onResponse will be executed
        //if there is some error we will get inside the onFailure() method
        call.enqueue(new Callback<List<MoviePojo>>() {
            @Override
            public void onResponse(Call<List<MoviePojo>> call, Response<List<MoviePojo>> response) {
                if (response.code() == 200 && response.body() != null) {
                    final List<MoviePojo> heroList = response.body();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();

                    recView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TicketAdapter(getContext(), heroList, new TicketAdapter.Customclick() {
                        @Override
                        public void onClick(View view, int pos) {
                            MainFragment.setFragment(heroList.get(pos));

                            //SM.senddata(heroList.get(pos));
                            Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    recView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MoviePojo>> call, Throwable t) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public MainActivity getMyActivity() {

        return ((MainActivity) getActivity());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            SM = (SendData) getActivity();
//        } catch (ClassCastException e) {
//            throw new ClassCastException("Error in retrieving data. Please try again");
//        }
//    }


    public interface SendData {
        void senddata(MoviePojo pojo);
    }
}
