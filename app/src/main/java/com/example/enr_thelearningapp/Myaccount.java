package com.example.enr_thelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Myaccount extends AppCompatActivity {
    Button btn_sign_out;
    TextView Fullname;
    TextView emil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        Fullname=(TextView)findViewById(R.id.name) ;
        emil=(TextView)findViewById(R.id.email);
        btn_sign_out=(Button)findViewById(R.id.sign_out);
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.sign_out){
                    AuthUI.getInstance().signOut(Myaccount.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            startActivity(new Intent(Myaccount.this,login.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Myaccount.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();;
                        }
                    });
                }




            }
        });
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String name = user.getDisplayName();
                String email = user.getEmail();
                boolean emailVerified = user.isEmailVerified();
                String uid = user.getUid();



            }



        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.navbar);
        bottomNavigationView.setSelectedItemId(R.id.nav_account);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), search.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_mycourse:
                        startActivity(new Intent(getApplicationContext(),mycourse.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.nav_quiz:
                        startActivity(new Intent(getApplicationContext(), quizactivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                    case R.id.nav_account:

                }
            }
        });
    }
}