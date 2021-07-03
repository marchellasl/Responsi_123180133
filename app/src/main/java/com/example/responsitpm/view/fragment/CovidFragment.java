package com.example.responsitpm.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsitpm.R;
import com.example.responsitpm.adapter.CovidAdapter;
import com.example.responsitpm.model.covid.CovidDataItem;
import com.example.responsitpm.view.viewmodel.CovidViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CovidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CovidFragment extends Fragment {

    private CovidAdapter covidAdapter;
    private RecyclerView rvCovid;
    private CovidViewModel covidViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CovidFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CovidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CovidFragment newInstance(String param1, String param2) {
        CovidFragment fragment = new CovidFragment();
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
        return inflater.inflate(R.layout.fragment_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidAdapter = new CovidAdapter(getContext());
        covidAdapter.notifyDataSetChanged();

        rvCovid = view.findViewById(R.id.rv_covid);
        rvCovid.setLayoutManager(new LinearLayoutManager(getContext()));

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setCovid();
        covidViewModel.getCovid().observe(getViewLifecycleOwner(), getCovid);

        rvCovid.setAdapter(covidAdapter);
    }

    private Observer<ArrayList<CovidDataItem>> getCovid = new Observer<ArrayList<CovidDataItem>>() {
        @Override
        public void onChanged(ArrayList<CovidDataItem> covidDataItems) {
            if (covidDataItems != null) {
                covidAdapter.setData(covidDataItems);
            }
        }
    };
}