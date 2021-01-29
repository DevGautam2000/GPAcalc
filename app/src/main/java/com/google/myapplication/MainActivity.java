/*

        AUTHOR : GAUTAM CHANDRA SAHA
        DESCRIPTION:  GPA (GRADE POINT AVERAGE) CALCULATOR
        TIME & DATE :
        STARTED:  FRIDAY, 15 JAN 2021
        ENDED WITH VERSION 1.0 ON TUESDAY, 26 JAN 2021


*/



package com.google.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText[] sub = new EditText[10];

    TextView title;

    Spinner[] List = new Spinner[10];

    Spinner[] credit = new Spinner[10];

    String getCredit,getList;

    int length=0;

    Button submit;

    ImageView reset,menu;

    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);


        int defSize = 10;


//                FOR TITLE

        title = findViewById(R.id.app_title);

        //                FOR SUBMIT BUTTON

        submit = findViewById(R.id.submit);

//                using loop to grab sub id`s

        for (int i = 0; i < defSize; i++) {

            String dumSubId = "sub" + (i + 1);
            int subId = getResources().getIdentifier(dumSubId, "id", getPackageName());
            sub[i] =findViewById(subId);
        }

        //                using loop to grab credit id`s

        for (int i = 0; i < defSize; i++) {

            String dumCreditId = "credit" + (i + 1);
            int creditId = getResources().getIdentifier(dumCreditId, "id", getPackageName());
            credit[i] = (Spinner) findViewById(creditId);
        }

        //                using loop to grab grade id`s

        for (int i = 0; i < defSize; i++) {

            String dumGradeId = "list" + (i + 1);
            int listId = getResources().getIdentifier(dumGradeId, "id", getPackageName());
            List[i] = (Spinner) findViewById(listId);
        }



//___________________________________________________________________________________________

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.creditArr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //                using loop to set adapter for credit

        for (int i = 0; i < defSize; i++) {

            credit[i].setAdapter(adapter);
        }


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.gradeArr, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //                using loop to set adapter for list

        for (int i = 0; i < defSize; i++) {

            List[i].setAdapter(adapter2);
        }




//        ______________________________________________


        String[] selectC = new String[10];
        String[] selectL = new String[10];


        for (int i = 0; i < defSize; i++) {

            selectC[i] = "CREDIT";
            selectL[i] = "GRADE";
        }



        //SUBMIT STARTS HERE
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                MainActivity len = new MainActivity();
                int j=0;

                for (int i = 0; i < defSize; i++) {

                    getCredit = credit[i].getSelectedItem().toString();
                    getList = List[i].getSelectedItem().toString();



                    if (check(getCredit, getList)) {

                        selectC[i-j] = getCredit;
                        selectL[i-j] = getList;

                        len.length++;

                    }

                    else
                        j++;


                }


                int nullCheck=0 ;
                for (int i = 0; i < defSize; i++) {


                    if (selectC[i].equals("CREDIT") && selectL[i].equals("GRADE") ) {

                        nullCheck++;
                    }
                }


                if (nullCheck==defSize){

                    title.setText(R.string.title);
                    return;

                }


                    startUpdate(selectC,selectL,len); //the logic


            }
        });



        //RESET AND NAV MENU

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < defSize; i++) {

                    selectC[i] = "CREDIT";
                    selectL[i] = "GRADE";


                        credit[i].setAdapter(adapter);

                        List[i].setAdapter(adapter2);

                        sub[i].setText(null);


                }

                title.setText(R.string.title);



            }



        });


        menu=findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, NavMenu.class));
            }
        });

    }



//    function to check activity in credits and list
        private boolean check (String credit, String list){

            if ((credit.equals("CREDIT") && list.equals("GRADE")) ||
                    (!credit.equals("CREDIT") && list.equals("GRADE")) || (credit.equals("CREDIT") && !list.equals("GRADE"))) {

                return false;
            }

            return true;
        }


//    function to start updating the scores
    private void startUpdate(String[] credit, String[] list, MainActivity len ) {




        float decPoint,decCredit;


        float totalPoint=0f;
        float totalCredit=0f;


        for (int i=0 ; i<len.length ;i++ )
        {

            decPoint= getGradePoint(list[i]);


            if(decPoint>=0f ){




                    decCredit = Float.parseFloat(credit[i]);

                    totalPoint += (decPoint * decCredit);
                    totalCredit += decCredit;

            }



        }

        float gpa = totalPoint / totalCredit;
        gpa= Math.round(gpa * 100 ) / 100f;

        String GPA=Float.toString(gpa);
        title.setText(GPA);



    }

    private float getGradePoint(String grade) {


        switch (grade) {
            case "S":
                return 10f;
            case "A":
                return 9f;
            case "B":
                return 8f;
            case "C":
                return 7f;
            case "D":
                return 6f;
            case "E":
                return 5f;
            default:
                return 0f;
        }

    }


}