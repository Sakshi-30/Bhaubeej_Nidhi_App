package com.example.myapplication_nav.ui.schemes;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication_nav.R;

public class schemes extends Fragment {

    private SchemesViewModel mViewModel;

    public static schemes newInstance() {
        return new schemes();
    }

    private CardView Scheme1, Scheme2, Scheme3, Scheme4, Scheme5;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // inflater.inflate(R.layout.schemes_fragment, container, false);
        View v = inflater.inflate(R.layout.schemes_fragment, container, false);

        Scheme1 = (CardView) v.findViewById(R.id.EndowmentScheme);
        Scheme2 = (CardView) v.findViewById(R.id.Sankalp365);
        Scheme3 = (CardView) v.findViewById(R.id.FinancialGuardianShip);
        Scheme4 = (CardView) v.findViewById(R.id.BuildingFund);
        Scheme5 = (CardView) v.findViewById(R.id.DonationInKind);


        Scheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(1,v);
            }
        });
        Scheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(2,v);
            }
        });
        Scheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(3,v);
            }
        });
        Scheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(4,v);
            }
        });
        Scheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(5,v);
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SchemesViewModel.class);
        // TODO: Use the ViewModel
    }


    public void onButtonClicked(int scheme_no, View v){
        // Create the object of
        // AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

        switch (scheme_no){
            case 1:builder.setTitle("Endowment Scheme");
                builder.setMessage(getString(R.string.endowmentScheme));
                break;
            case 2:builder.setTitle("Sankalp 365");
                builder.setMessage(getString(R.string.sankalp365));
                break;
            case 3:builder.setTitle("Financial Guardianship");
                builder.setMessage(getString(R.string.financialGuardianShip));
                break;
            case 4:builder.setTitle("Building Fund");
                builder.setMessage(getString(R.string.buildingFund));
                break;
            case 5:builder.setTitle("Donation In A Kind");
                builder.setMessage(getString(R.string.donationInKind));
                break;
        }

        builder.setCancelable(true);
        builder.setPositiveButton("Donate",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent DonateLink = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://maharshikarve.ac.in/donation/form.php"));
                startActivity(DonateLink);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}