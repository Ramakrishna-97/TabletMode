package com.example.tabletmode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {
    String fname,mob,mail1,lname,desg,doj;




    public FragmentB() {
        // Required empty public constructor
    }

    public FragmentB(String fname, String lname, String mail, String mobile, String desg, String doj) {
        this.fname=fname;
        this.mob=mobile;
        this.mail1=mail;
        this.lname=lname;
        this.desg=desg;
        this.doj=doj;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_b, container, false);
        TextView firstname=root.findViewById(R.id.fnamedispid);
        TextView lasttname=root.findViewById(R.id.lnamedispid);
        TextView maill=root.findViewById(R.id.maildispid);
        TextView mobi=root.findViewById(R.id.mobiledispid);
        TextView disg=root.findViewById(R.id.desgdispid);
        TextView dojoin=root.findViewById(R.id.dojdispid);

        firstname.setText(fname);
        maill.setText(mail1);
        mobi.setText(mob);
        lasttname.setText(lname);
        disg.setText(doj);
        dojoin.setText(desg);

        return root;
    }
}