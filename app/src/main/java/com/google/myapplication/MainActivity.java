package com.google.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    EditText sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10;

    EditText[] sub = new EditText[10];

    TextView title,length;

//    Spinner List1,List2,List3,List4,List5,List6,List7,List8,List9,List10;
    Spinner[] List = new Spinner[10];

//    Spinner credit1,credit2,credit3,credit4,credit5,credit6,credit7,credit8,credit9,credit10;
    Spinner[] credit = new Spinner[10];

    String getCredit,getList;

    boolean runActive = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            runActive=true;



//                FOR TITLE

        title=findViewById(R.id.app_title);

        //                FOR length

        length=findViewById(R.id.length);

////                FOR SUBJECTS
//                sub1= findViewById(R.id.sub1);
//                sub2= findViewById(R.id.sub2);
//                sub3= findViewById(R.id.sub3);
//                sub4= findViewById(R.id.sub4);
//                sub5= findViewById(R.id.sub5);
//                sub6= findViewById(R.id.sub6);
//                sub7= findViewById(R.id.sub7);
//                sub8= findViewById(R.id.sub8);
//                sub9= findViewById(R.id.sub9);
//                sub10=findViewById(R.id.sub10);



//                using loop to grab subid`s

                    for(int i=0; i<10; i++) {

                            String dumSubId = "sub" + (i+1);
                           int subId = getResources().getIdentifier(dumSubId, "id", getPackageName());
                            sub[i] = (EditText) findViewById(subId);
                        }



////                FOR CREDIT
//                credit1= findViewById(R.id.credit1);
//                credit2= findViewById(R.id.credit2);
//                credit3= findViewById(R.id.credit3);
//                credit4= findViewById(R.id.credit4);
//                credit5= findViewById(R.id.credit5);
//                credit6= findViewById(R.id.credit6);
//                credit7= findViewById(R.id.credit7);
//                credit8= findViewById(R.id.credit8);
//                credit9= findViewById(R.id.credit9);
//                credit10= findViewById(R.id.credit10);

        //                using loop to grab credit id`s

        for(int i=0; i<10; i++) {

            String dumCreditId = "credit" + (i+1);
            int creditId = getResources().getIdentifier(dumCreditId, "id", getPackageName());
            credit[i] = (Spinner) findViewById(creditId);
        }



////                FOR GRADE
//                List1= findViewById(R.id.list1);
//                List2= findViewById(R.id.list2);
//                List3= findViewById(R.id.list3);
//                List4= findViewById(R.id.list4);
//                List5= findViewById(R.id.list5);
//                List6= findViewById(R.id.list6);
//                List7= findViewById(R.id.list7);
//                List8= findViewById(R.id.list8);
//                List9= findViewById(R.id.list9);
//                List10= findViewById(R.id.list10);

        //                using loop to grab grade id`s

        for(int i=0; i<10; i++) {

            String dumGradeId = "list" + (i+1);
            int listId = getResources().getIdentifier(dumGradeId, "id", getPackageName());
            List[i] = (Spinner) findViewById(listId);
        }




//___________________________________________________________________________________________

        ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.creditArr,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//        //  SET ADAPTER FOR CREDIT
//        credit1.setAdapter(adapter);
//        credit2.setAdapter(adapter);
//        credit3.setAdapter(adapter);
//        credit4.setAdapter(adapter);
//        credit5.setAdapter(adapter);
//        credit6.setAdapter(adapter);
//        credit7.setAdapter(adapter);
//        credit8.setAdapter(adapter);
//        credit9.setAdapter(adapter);
//        credit10.setAdapter(adapter);

        //                using loop to set adapter for credit

        for(int i=0; i<10; i++) {

            credit[i].setAdapter(adapter);
        }




        ArrayAdapter adapter2= ArrayAdapter.createFromResource(this,R.array.gradeArr,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        ////        SET ADAPTER FOR GRADE
//
//        List1.setAdapter(adapter2);
//        List2.setAdapter(adapter2);
//        List3.setAdapter(adapter2);
//        List4.setAdapter(adapter2);
//        List5.setAdapter(adapter2);
//        List6.setAdapter(adapter2);
//        List7.setAdapter(adapter2);
//        List8.setAdapter(adapter2);
//        List9.setAdapter(adapter2);
//        List10.setAdapter(adapter2);


        //                using loop to set adapter for list

        for(int i=0; i<10; i++) {

            List[i].setAdapter(adapter2);
        }




        if (runActive){

            for (int i=0; i<10; i++){

                //_____________________CREDIT 1 /LIST1_________________________________________________________________________
                int finalI1 = i;
                credit[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        getCredit= credit[finalI1].getSelectedItem().toString();
                        getList=List[finalI1].getSelectedItem().toString();

                        boolean check = check(getCredit,getList);

//                    if (!getCredit.equals("CREDIT")){
//
//                        String len = length.getText().toString();
//                        int inc = Integer.parseInt(len);
//                        inc += 1;
//                        len= Integer.toString(inc);
//                        length.setText(len);
//
//                    }
//
//                    else{
//
//                        String len = length.getText().toString();
//                        int reduce = Integer.parseInt(len);
//                        reduce -= 1;
//                        len= Integer.toString(reduce);
//                        length.setText(len);
//                    }


                        if (!check){


                            startUpdate(getCredit,getList,finalI1);
                        }





                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                int finalI = finalI1;
                List[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                        getCredit= credit[finalI].getSelectedItem().toString();
                        getList=List[finalI].getSelectedItem().toString();

                        boolean check = check(getCredit,getCredit);

                        if (!check){

                            startUpdate(getCredit,getList,finalI);
                        }

                        else{

                        }



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
//____________________________________________________________________________________________________

            }
        }

////<--------------------------------------------------------------------------------------------------------------->
//
////______________________CREDIT 2 /LIST 2________________________________________________________________________
//        credit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit2.getSelectedItem().toString();
//                list=List2.getSelectedItem().toString();
//
//               boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//               else {
//
//                   String len = length.getText().toString();
//                   int reduce = Integer.parseInt(len);
//                   reduce -= 1;
//                   len= Integer.toString(reduce);
//                   length.setText(len);
//               }
//
//
//                    if (!check){
//
//
//                            startUpdate(credit,list);
//                    }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit2.getSelectedItem().toString();
//                list=List2.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//        //_______________________CREDIT 3 /LIST 3_______________________________________________________________________
//        credit3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit3.getSelectedItem().toString();
//                list=List3.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit3.getSelectedItem().toString();
//                list=List3.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//        //___________________CREDIT 4 /LIST 4___________________________________________________________________________
//        credit4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit4.getSelectedItem().toString();
//                list=List4.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit4.getSelectedItem().toString();
//                list=List4.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//        //____________________CREDIT 5 /LIST 5__________________________________________________________________________
//        credit5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit5.getSelectedItem().toString();
//                list=List5.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit5.getSelectedItem().toString();
//                list=List5.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//        //____________________CREDIT 6 /LIST 6__________________________________________________________________________
//        credit6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit6.getSelectedItem().toString();
//                list=List6.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit6.getSelectedItem().toString();
//                list=List6.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//        //____________________CREDIT 7 /LIST 7__________________________________________________________________________
//        credit7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit7.getSelectedItem().toString();
//                list=List7.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit7.getSelectedItem().toString();
//                list=List7.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//
//// ____________________CREDIT 8 /LIST 8__________________________________________________________________________
//        credit8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit8.getSelectedItem().toString();
//                list=List8.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit8.getSelectedItem().toString();
//                list=List8.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//
//// ____________________CREDIT 9 /LIST 9__________________________________________________________________________
//        credit9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit9.getSelectedItem().toString();
//                list=List9.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit9.getSelectedItem().toString();
//                list=List9.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
//
//// ____________________CREDIT 10 /LIST 10__________________________________________________________________________
//        credit10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit10.getSelectedItem().toString();
//                list=List10.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!credit.equals("CREDIT")){
//
//                    String len = length.getText().toString();
//                    int inc = Integer.parseInt(len);
//                    inc += 1;
//                    len= Integer.toString(inc);
//                    length.setText(len);
//
//                }
//
//
//                else{
//
//                    String len = length.getText().toString();
//                    int reduce = Integer.parseInt(len);
//                    reduce -= 1;
//                    len= Integer.toString(reduce);
//                    length.setText(len);
//                }
//
//                if (!check){
//
//
//                    startUpdate(credit,list);
//                }
//
//
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        List10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                credit= credit10.getSelectedItem().toString();
//                list=List10.getSelectedItem().toString();
//
//                boolean check = check(credit,list);
//
//                if (!check){
//
//                    startUpdate(credit,list);
//                }
//
//                else{
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
////____________________________________________________________________________________________________
//
//
////<--------------------------------------------------------------------------------------------------------->
//
    }

//    function to check activity in credits and list
    private boolean check(String credit, String list) {

        if ((credit.equals("CREDIT") && list.equals("GRADE")) ||
                (!credit.equals("CREDIT") && list.equals("GRADE")) || (credit.equals("CREDIT") && !list.equals("GRADE"))){

                return true;
        }

        return false;
    }


//    function to start updating the scores
    private void startUpdate(String credit, String list, int select) {


        float total_credit=0.0f;
        float total_point=0.0f;

        float decPoint,decCredit;

        decPoint= getGradePoint(list);


        if(decPoint>=0f){

            decCredit= Float.parseFloat(credit);
            total_credit += decCredit;
            total_point += (decPoint * decCredit);
        }



//        String len = length.getText().toString();
//        int select=Integer.parseInt(len);

        float calc_gpa = total_point / total_credit;
        float gpa=Math.round(calc_gpa);

            if (select==1){


                String Gpa= Float.toString(gpa);
                title.setText(Gpa);
            }

            else if (select>1){

                String getTitle = title.getText().toString();
                float prevGpa= Float.parseFloat(getTitle);
                gpa = (gpa +prevGpa )/ 2.0f;

                String GPA=Float.toString(gpa);
                title.setText(GPA);
            }




    }

    private float getGradePoint(String grade) {


        switch (grade) {
            case "S":
                return 10.0f;
            case "A":
                return 9.0f;
            case "B":
                return 8.0f;
            case "C":
                return 7.0f;
            case "D":
                return 6.0f;
            case "E":
                return 5.0f;
            default:
                return 0.0f;
        }

    }


}