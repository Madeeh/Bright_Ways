package com.example.brightways.UI.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.brightways.Prevalent.Prevalent;
import com.example.brightways.R;
import com.example.brightways.UI.Setting;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {

    }

    Button updateBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        updateBtn = view.findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Setting.class);
            startActivity(intent);
        });

        TextView userNameTextView = view.findViewById(R.id.user_profile_name);
        TextView userEmailSecondTextView = view.findViewById(R.id.email_second);
        TextInputLayout userNameUserTextView = view.findViewById(R.id.etUserNameLayout);
        TextInputLayout userEmailTextView = view.findViewById(R.id.etEmailLayout);
        TextInputLayout userPhoneNoTextView = view.findViewById(R.id.etPhoneLayout);
        TextInputLayout userPasswordTextView = view.findViewById(R.id.passwordLayout);
        CircleImageView profileImageView = view.findViewById(R.id.user_profile_image);

        userNameTextView.setText(Prevalent.currentOnlineUser.getName());
        userEmailSecondTextView.setText(Prevalent.currentOnlineUser.getEmail());
        userNameUserTextView.getEditText().setText(Prevalent.currentOnlineUser.getName());
        userEmailTextView.getEditText().setText(Prevalent.currentOnlineUser.getEmail());
        userPhoneNoTextView.getEditText().setText(Prevalent.currentOnlineUser.getPhone());
        userPasswordTextView.getEditText().setText(Prevalent.currentOnlineUser.getPassword());

        Picasso.get().load(Prevalent.currentOnlineUser.getImage()).placeholder(R.drawable.profile).into(profileImageView);
        return view;
    }
}