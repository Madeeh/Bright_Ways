package com.example.brightways.UI.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brightways.Chat.HomeChatActivity;
import com.example.brightways.Chat.LoginChatActivity;
import com.example.brightways.Chat.RegistrationChatActivity;
import com.example.brightways.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class PhoneFragment extends Fragment {
    TextView txt_signup;
    EditText login_email, login_password;
    TextView signIn_btn;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    public PhoneFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        auth = FirebaseAuth.getInstance();
        txt_signup = view.findViewById(R.id.txt_signup);
        signIn_btn = view.findViewById(R.id.signin_btn);
        login_email = view.findViewById(R.id.login_email);
        login_password = view.findViewById(R.id.login_password);

        signIn_btn.setOnClickListener(v -> {
            progressDialog.show();
            String email = login_email.getText().toString();
            String password = login_password.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Enter Valid Data", Toast.LENGTH_SHORT).show();
            } else if (!email.matches(emailPattern)) {
                progressDialog.dismiss();
                login_email.setError("Envalid Email");
                Toast.makeText(getContext(), "Envalid Email", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                progressDialog.dismiss();
                login_password.setError("Envalid Password");
                Toast.makeText(getContext(), "Please enter valid password", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            startActivity(new Intent(getContext(), HomeChatActivity.class));
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Error in login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        txt_signup.setOnClickListener(v -> startActivity(new Intent(getContext(), RegistrationChatActivity.class)));
        return view;
    }
}