package com.blaxtation.inviteaguest;


import android.content.Intent;

import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;




import androidx.annotation.NonNull;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import com.google.api.Distribution;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeScreenNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // TextView name;
    List<guest> guestList=new ArrayList<>();


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;

        FirebaseFirestore db;
        RecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_nav_drawer);

       // TextView name = (TextView)findViewById(R.id.guest_nameee);
       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // name.setText(user.getEmail()+"Welcome"+user.getDisplayName());

        db=FirebaseFirestore.getInstance();


        mRecyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        adapter= new RecyclerViewAdapter(HomeScreenNavDrawer.this,guestList);
        mRecyclerView.setAdapter(adapter);


        db.collection("guest")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot doc: (task.getResult())){
                            guest guest=new guest(doc.getString("id"),
                                    doc.getString("name"),
                                    doc.getString("image"));
                            guestList.add(guest);
                        }
                        //Log.println("name");
                        System.out.println(guestList.toString());
                        System.out.println("hello world");
                        Log.d("nsdh", guestList.toString());
                        adapter=new RecyclerViewAdapter(HomeScreenNavDrawer.this,guestList);
                        mRecyclerView.setAdapter(adapter);
                    }
                });









        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen_nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            startActivity(new Intent(HomeScreenNavDrawer.this,MainActivity.class));
                }
            });


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {

            Intent intent=new Intent(this,gallery.class);
            startActivity(intent);

        } else if (id == R.id.nav_faq) {
            Intent intent=new Intent(this,faq.class);
            startActivity(intent);

        } else if (id == R.id.nav_about_us) {
            Intent intent=new Intent(this,about_us.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact_us) {
            Intent intent=new Intent(this,contact_us.class);
            startActivity(intent);


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
