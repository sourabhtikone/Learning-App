package com.example.enr_thelearningapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class QuizSets extends AppCompatActivity {
    private GridView sets_gridview;
    private FirebaseFirestore firestore;
    public static int Category_id;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sets);

        //toolbar
        Toolbar toolbar=findViewById(R.id.settollbar);
       setSupportActionBar(toolbar);


       String title=getIntent().getStringExtra("CATEGORY");
        Category_id=getIntent().getIntExtra("CATEGORY_ID", 1);
       getSupportActionBar().setTitle(title);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //gridview
        sets_gridview=findViewById(R.id.sets_gridview);


        //progress bar
       loadingDialog=new Dialog(QuizSets.this);
       loadingDialog.setContentView(R.layout.loading_progressbar);
       loadingDialog.setCancelable(false);
       loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_vackground);
       loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
       loadingDialog.show();

        firestore=FirebaseFirestore.getInstance();

        loadSets();


    }

    public void loadSets()
    {
        firestore.collection("QUIZ").document("CAT" +String.valueOf(Category_id)).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.isSuccessful()){
                            DocumentSnapshot doc=task.getResult();

                            if (doc.exists())
                            {
                                long sets=(long)doc.get("SETS");

                                SetsAdapter adapter=new SetsAdapter((int)sets);
                                sets_gridview.setAdapter(adapter);
                            }
                            else
                            {
                                Toast.makeText(QuizSets.this,"No CAT document exist",Toast.LENGTH_LONG).show();
                                finish();
                            }

                        }
                        else
                        {
                            Toast.makeText(QuizSets.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                        loadingDialog.cancel();

                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            QuizSets.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}