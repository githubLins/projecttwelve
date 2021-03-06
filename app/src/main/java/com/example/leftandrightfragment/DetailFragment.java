package com.example.leftandrightfragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textViewWord=(TextView)view.findViewById(R.id.word);
        TextView textViewMeaning=(TextView)view.findViewById(R.id.wordmeaning);
        TextView textViewSample=(TextView)view.findViewById(R.id.wordsample);
        switch (mParam1){
            case "1":
                textViewWord.setText("apple");
                textViewMeaning.setText("苹果");
                textViewSample.setText("This apple is very nice.");
                break;
            case "2":
                textViewWord.setText("Orange");
                textViewMeaning.setText("橘子");
                textViewSample.setText("Orange juice dribbled down his chin.");
                break;
            case "3":
                textViewWord.setText("Banana");
                textViewMeaning.setText("香蕉");
                textViewSample.setText("Eating bananas is good for digesting.");
                break;
            case "4":
                textViewWord.setText("Lemon");
                textViewMeaning.setText("柠檬");
                textViewSample.setText("A lemon is an acid fruit.");
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
