package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

import model.Pet;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int selection;

    private View.OnClickListener switchListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(selection == 1){
                selection = 2;
            }else{
                selection = 1;
            }
            populateListView();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        Button switchButton = findViewById(R.id.button);
        switchButton.setOnClickListener(switchListener);
        selection = 2;
        populateListView();
    }

    private void populateListView() {
        switch (selection) {
            case 1:
                useStringResource();
                break;
            case 2:
                usingDataArray();
                break;

        }
    }

    /**
     * This method populates the list view using a string resource containing
     * the content of a strings array resource
     */
    private void useStringResource() {
        String[] breeds = getResources().getStringArray(R.array.breeds);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, breeds);
        listView.setAdapter(adapter);
    }

    /**
     * This method populates the list view using a string resource containing the list of a data array
     */
    private void usingDataArray() {

        LinkedList<Pet> pets = new LinkedList<>();
        pets.add(new Pet("Kenny", "Husky", 14));
        pets.add(new Pet("Roger", "Golder Retriever", 13));
        pets.add(new Pet("Bond", "Samoyed", 4));
        pets.add(new Pet("Mango", "Whimpet", 2));
        pets.add(new Pet("Boy", "Mutt", 6));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);

        listView.setAdapter(adapter);

    }
}