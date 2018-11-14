package com.example.divyanshuagrawal.calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "Fuck";
        Calculator calc = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = findViewById(R.id.txtScreen);
        Random rand = new Random();
        String[] slang = {
                "You are ugly",
                "Your mom is fat",
                "Hey, You suck",
                "Your life is without meaning",
                "Hi. No one loves you.",
                "Hi idiot",
                "Okay Google",
                "Deleting porn...",
                "Setting Porn as Status",
                "Asshole detected."
        };
        int rnd = rand.nextInt(10);
        if(rnd>=0) txt.setText(slang[rnd]);
        }
    }


    public void doFun(View view) {
        double x = calc.Calculate();
        TextView txt = findViewById(R.id.txtScreen);
        if(x==-121212){
            txt.setText("Fuck you");
        }else {
            //Log.d(LOG_TAG,Double.parseDouble(x));

            txt.setText(Double.toString(x));
        }

        calc.expFirst=Double.toString(x);
        calc.expSecond="0";
        calc.isFirst=true;


    }

    public void doUpd(){
        TextView txt = findViewById(R.id.txtScreen);
        if(calc.isFirst){
            txt.setText(Double.toString(Double.parseDouble(calc.expFirst)));
        }else{
            txt.setText(Double.toString(Double.parseDouble(calc.expSecond)));
        }
    }
    /*public void doUpdSpcl(){
        TextView txt = findViewById(R.id.txtScreen);
        if(calc.isFirst){
            txt.setText(calc.expFirst);
        }else{
            txt.setText(calc.expSecond);
        }
    }*/

    public void one(View view) {

        if(calc.isFirst){
            calc.expFirst+="1";
        }else{
            calc.expSecond+="1";
        }
        doUpd();

    }
    public void dec(View view) {

        if(calc.isFirst){
            calc.expFirst+=".";
        }else{
            calc.expSecond+=".";
        }
        doUpd();

    }
    public void two(View view) {

        if(calc.isFirst){
            calc.expFirst+="2";
        }else{
            calc.expSecond+="2";
        }
        doUpd();
    }
    public void three(View view) {

        if(calc.isFirst){
            calc.expFirst+="3";
        }else{
            calc.expSecond+="3";
        }
        doUpd();

    }
    public void four(View view) {

        if(calc.isFirst){
            calc.expFirst+="4";
        }else{
            calc.expSecond+="4";
        }
        doUpd();

    }
    public void five(View view) {

        if(calc.isFirst){
            calc.expFirst+="5";
        }else{
            calc.expSecond+="5";
        }
        doUpd();

    }
    public void six(View view) {

        if(calc.isFirst){
            calc.expFirst+="6";
        }else{
            calc.expSecond+="6";
        }
        doUpd();

    }
    public void seven(View view) {

        if(calc.isFirst){
            calc.expFirst+="7";
        }else{
            calc.expSecond+="7";
        }
        doUpd();

    }
    public void eight(View view) {

        if(calc.isFirst){
            calc.expFirst+="8";
        }else{
            calc.expSecond+="8";
        }
        doUpd();
    }
    public void nine(View view) {

        if(calc.isFirst){
            calc.expFirst+="9";
        }else{
            calc.expSecond+="9";
        }
        doUpd();

    }
    public void zero(View view) {

        if(calc.isFirst){
            calc.expFirst+="0";
        }else{
            calc.expSecond+="0";
        }

        doUpd();
    }

    public void add(View view) {
        calc.operator="+";
        TextView txt = findViewById(R.id.txtScreen);
        txt.setText("+");
        calc.isFirst = false;
    }
    public void subtract(View view) {
        calc.operator="-";
        TextView txt = findViewById(R.id.txtScreen);
        txt.setText("-");
        calc.isFirst = false;
    }
    public void divide(View view) {
        calc.operator="/";
        TextView txt = findViewById(R.id.txtScreen);
        txt.setText("÷");
        calc.isFirst = false;
    }
    public void multiply(View view) {
        calc.operator="*";
        TextView txt = findViewById(R.id.txtScreen);
        txt.setText("×");
        calc.isFirst = false;
    }
    public void clear(View view) {
        calc.expFirst="0";
        calc.expSecond="0";
        calc.isFirst=true;
        calc.operator="+";
        TextView txt = findViewById(R.id.txtScreen);

        doUpd();
        txt.setText("0");
    }

    public void about(View view) {
        Intent about = new Intent(this, About.class);
        startActivity(about);
    }
}

class Calculator{
    String expFirst;
    String expSecond;
    String operator;
    boolean isFirst;

    Calculator(){
        expFirst = "0";
        expSecond = "0";
        isFirst=true;
        operator = "+";
    }

    double Calculate(){
        if(operator=="+"){
           return Double.parseDouble(expFirst)+Double.parseDouble(expSecond);

        }else if(operator=="-"){
            return Double.parseDouble(expFirst)-Double.parseDouble(expSecond);
        }else if(operator=="*"){
            return Double.parseDouble(expFirst)*Double.parseDouble(expSecond);
        }else if(operator=="/"){
            if(Double.parseDouble(expSecond)==0){
                return -121212;
            }else{
                return Double.parseDouble(expFirst)/Double.parseDouble(expSecond);
            }
        }
        else{
            return 0;
        }
    }
}
