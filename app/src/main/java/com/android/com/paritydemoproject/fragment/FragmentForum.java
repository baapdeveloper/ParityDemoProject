package com.android.com.paritydemoproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.com.paritydemoproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentForum extends Fragment {


    public FragmentForum() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_forum, container, false);
    }

}
