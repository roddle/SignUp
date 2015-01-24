package com.toddandryan.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class DataFragment extends android.app.Fragment {

    private MyDataListener listener;
    private View mRootView;

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    public DataFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_view, container, false);
       TextView display;
        display = (TextView) rootView.findViewById(R.id.display);
        display.setTextColor(Color.BLACK);
        display.setText(listener.ReadData());

       /* Code to display data in a list instead

        String s = listener.ReadData();

        // Get ListView object from xml
        mainListView = (ListView) rootView.findViewById(R.id.dataList);

        // Create and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> planetList = new ArrayList<String>();
        //planetList.addAll( Arrays.asList(planets) );
        planetList.addAll( Arrays.asList(s.split("\\n")));

        // Create ArrayAdapter using the planet list.
        //listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);
        listAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.simplerow, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        listAdapter.add( "Ceres" );
        listAdapter.add( "Pluto" );
        listAdapter.add( "Haumea" );
        listAdapter.add( "Makemake" );
        listAdapter.add( "Eris" );

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
        */
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (MyDataListener) activity;
        } catch (ClassCastException castException) {
            /** The activity does not implement the listener. */
        }
    }

    public interface MyDataListener{
        public String ReadData();
    }


}