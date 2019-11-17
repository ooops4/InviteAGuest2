package com.blaxtation.inviteaguest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //Button btn_sign_out;
    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //btn_sign_out=(Button)findViewById(R.id.btn_sign_out);
       /* btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(MainActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_sign_out.setEnabled(false);
                                showSignInOptions();
                            }
                        });
            }
        });
        
        */
        providers= Arrays.asList(
               // new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
               // new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()

        );

        showSignInOptions();


    }
    private void showSignInOptions(){

        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                .setTheme(R.style.MyTheme)
                .build(),MY_REQUEST_CODE
        );


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if (requestCode==MY_REQUEST_CODE)
    {

        IdpResponse response= IdpResponse.fromResultIntent(data);
        if (resultCode==RESULT_OK) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Toast.makeText(this, "Welcome " + user.getDisplayName(), Toast.LENGTH_SHORT).show();


            Intent toHomeScreen = new Intent(MainActivity.this,HomeScreenNavDrawer.class);
            startActivity(toHomeScreen);
            finish();

        }
        else
        {
        Toast.makeText(this, ""+response.getError().getMessage(), Toast.LENGTH_SHORT).show();
    }
    }
}
}
