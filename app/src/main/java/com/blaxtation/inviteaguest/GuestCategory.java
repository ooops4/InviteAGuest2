package com.blaxtation.inviteaguest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GuestCategory extends AppCompatActivity {
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=findViewById(R.id.category_ListView);

        final ArrayAdapter<String> mAdapter=new ArrayAdapter<>(GuestCategory.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.categories));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(GuestCategory.this,guestListafterCategory.class);


                //intent.putExtra("category", listView.getItemIdAtPosition(i));
                String categorry =(adapterView.getItemAtPosition(i).toString());
                intent.putExtra("category",categorry);

                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);



    }
}
