package com.google.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NavMenu extends AppCompatActivity {

    ImageView instagram,linkedin,github,home;

    ImageView mail;

    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_menu);


        infoText=findViewById(R.id.infoText);


        infoText.setText(String.format("How to use GPAcalc?\n\nGPA or Grade Point Average is a number that indicates how well or how high you scored in your courses on average.\n" +
                "\nTo calculate your GPA fill in the CREDIT column with the credit of the subject and specify the corresponding grade achieved in the GRADE column.\n" +
                "\nThen click on calculate button to see your GPA.\n\nThe button on the right on the homescreen is a reset button if you wish to reset the columns.\n"+
                "\nCheck source on GitHub, link is attached at bottom.\n"));



        home=findViewById(R.id.hom);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getParentActivityIntent();
                finish();
            }
        });

        instagram=findViewById(R.id.instagram);

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotoUrl("https://instagram.com/gautamcsaha");
            }
        });

        linkedin=findViewById(R.id.linkedin);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotoUrl("https://www.linkedin.com/in/gautam-chandra-saha-896735205/");
            }
        });

        github=findViewById(R.id.github);

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotoUrl("https://github.com/DevGautam2000/GPAcalc");
            }
        });



        mail=findViewById(R.id.mail);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotoUrl("mailto:devgautam1231@gmail.com");
            }
        });
    }


    private void gotoUrl(String url) {

        Uri urcl = Uri.parse(url);

        startActivity(new Intent(Intent.ACTION_VIEW,urcl));
    }
}