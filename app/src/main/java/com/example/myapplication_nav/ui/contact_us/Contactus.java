package com.example.myapplication_nav.ui.contact_us;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication_nav.R;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Contactus extends Fragment {

    public static Contactus newInstance() {
        return new Contactus();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contactus_fragment, container, false);

        Button btn = (Button)v.findViewById(R.id.btnOK);
        EditText e_to = ((EditText)v.findViewById(R.id.txtTo));
        EditText  e_sub = ((EditText)v.findViewById(R.id.txtSubject));
        EditText  e_mess = ((EditText)v.findViewById(R.id.txtMessage));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = e_to.getText().toString();
                String sub = e_sub.getText().toString();
                String mess = e_mess.getText().toString();
                if (!sub.isEmpty() && !mess.isEmpty()) {
                    Intent mail = new Intent(Intent.ACTION_SEND);
                    mail.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                    mail.putExtra(Intent.EXTRA_TEXT, mess);
                    mail.setType("message/rfc822");
                    startActivity(Intent.createChooser(mail, "Send email via:"));
                }
                else{
                    Toast.makeText(getActivity(), "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, "Mail Sent Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ContactusViewModel mViewModel = new ViewModelProvider(this).get(ContactusViewModel.class);
        // TODO: Use the ViewModel
    }

}

