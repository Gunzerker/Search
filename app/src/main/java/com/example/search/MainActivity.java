package com.example.search;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText Editid;
    EditText Editimg;
    Button btnAddData;
    Button btnViewall;
    Button button;
    String t[]=new String[13];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        Editid = (EditText)findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ch=Editid.getText().toString();
               if(exists(ch)==true){
                   Intent intents = new Intent(MainActivity.this,Result.class);
                   intents.putExtra("arg",ch);
                   startActivity(intents);
               }
               else{
                   showMessage("Erreur","Aucune piece est trouver veuiller entrer l'id de la piece tout en miniscule");
               }

            }
        });
        t[0]="ab0421";
        t[1]="ab0436";
        t[2]="ab0410";
        t[3]="ab0428";
        t[4]="ab0437";
        t[5]="ab0439";
        t[6]="ab440";
        t[7]="ab0451";
        t[8]="ab0486";
        t[9]="ab0495";
        t[10]="abp1014";
        t[11]="abp1044";
        t[12]="abt1014";




    }
    public boolean exists(String ch){
        boolean ok=false;
        for(int i=0;i<t.length;i++){
            if (t[i].equals(ch)==true){
                ok=true;
            }

        }
    return ok;
    }
    public void openResult(String ch){


    }

    public void inserer(String id , String img){
        boolean isInserted = myDb.insertData(id , img);
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
