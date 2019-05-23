package com.gonzalias.demo.user;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gonzalias.demo.R;
import com.gonzalias.demo.databinding.FragmentUserBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private UserViewModel viewModel;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvID;
    private Button btnSearch;

    public UserFragment() {
        // Required empty public constructor

    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        final Observer<UserResponse> nameObserver = new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                tvFirstName.setText(userResponse.data.first_name);
                tvLastName.setText(userResponse.data.last_name);
                tvID.setText(userResponse.data.id);
            }
        };
        //viewModel.getUser().observe(this, nameObserver);


        FragmentUserBinding binding = FragmentUserBinding.inflate(getLayoutInflater());
        binding.setViewModel(viewModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvID = view.findViewById(R.id.tvID);
        btnSearch = view.findViewById(R.id.btnSearch);

        return view;
    }



}
