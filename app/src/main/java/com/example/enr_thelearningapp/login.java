package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class login extends AppCompatActivity {
    private static final int MY_REQUEST_CODE = 7000;
    List<AuthUI.IdpConfig> providers;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        providers= Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );
        ShowSignInOptions();
    }

    private void ShowSignInOptions() {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTheme(R.style.MyThemes)
                .setLogo(R.drawable.logo)

                .setAlwaysShowSignInMethodScreen(false)

                .setIsSmartLockEnabled(false)

        .build(),MY_REQUEST_CODE); 
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MY_REQUEST_CODE){
            IdpResponse response=IdpResponse.fromResultIntent(data);
            if (resultCode==RESULT_OK)
            {
                //get user
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                //show email on toast

                Intent intent=new Intent(login.this, start.class);
                startActivity(intent);
                login.this.finish();

                //set button sign out
            }
    }

}


}
