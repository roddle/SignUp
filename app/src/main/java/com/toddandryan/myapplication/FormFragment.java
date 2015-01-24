package com.toddandryan.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.TextView;
import java.io.FileOutputStream;
import android.content.Context;
import android.widget.Toast;

public  class FormFragment extends android.app.Fragment {

    public FormFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.form_view, container, false);
    }


    /* add an entry to the internal storage file */
    public void addEntry(String filename, String string) {
        FileOutputStream outputStream;

        try {
            outputStream = getActivity().openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(string.getBytes());
            outputStream.close();
            Toast.makeText(getActivity().getBaseContext(), R.string.saved, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* Called when Submit is clicked */
    public void submitForm(View view) {
        TextView nameText = (TextView) getView().findViewById(R.id.name);

        // save the form data somewhere
        addEntry(String.valueOf(R.string.data_file), nameText.getText().toString() + '\n' );

    }
}
