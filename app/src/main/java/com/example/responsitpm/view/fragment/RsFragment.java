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
import com.example.responsitpm.adapter.RujukanAdapter;
import com.example.responsitpm.model.rujukan.RujukanDataItem;
import com.example.responsitpm.view.viewmodel.RujukanViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RsFragment extends Fragment {

    private RujukanAdapter rujukanAdapter;
    private RecyclerView rvRujukan;
    private RujukanViewModel rujukanViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RsFragment newInstance(String param1, String param2) {
        RsFragment fragment = new RsFragment();
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
        return inflater.inflate(R.layout.fragment_rs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rujukanAdapter = new RujukanAdapter(getContext());
        rujukanAdapter.notifyDataSetChanged();

        rvRujukan = view.findViewById(R.id.rv_rs);
        rvRujukan.setLayoutManager(new LinearLayoutManager(getContext()));

        rujukanViewModel = new ViewModelProvider(this).get(RujukanViewModel.class);
        rujukanViewModel.setRujukan();
        rujukanViewModel.getRujukan().observe(getViewLifecycleOwner(), getRujukan);

        rvRujukan.setAdapter(rujukanAdapter);
    }

    private Observer<ArrayList<RujukanDataItem>> getRujukan = new Observer<ArrayList<RujukanDataItem>>() {
        @Override
        public void onChanged(ArrayList<RujukanDataItem> rujukanDataItems) {
            if (rujukanDataItems != null) {
                rujukanAdapter.setData(rujukanDataItems);
            }
        }
    };
}