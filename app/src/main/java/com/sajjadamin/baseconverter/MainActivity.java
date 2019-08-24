package com.sajjadamin.baseconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button dot,convert,ac,del,a,b,c,d,e,f,one,two,three,four,five,six,seven,eight,nine,zero;
    TextView inputTextView, outputTextView;
    NavigationView navigationView;
    ImageButton facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNaviganitoClick();
        //initialization textview variables
        inputTextView = findViewById(R.id.input);
        outputTextView = findViewById(R.id.output);
        //initialization keypad variables
        dot = findViewById(R.id.dot);
        convert = findViewById(R.id.convert);
        ac = findViewById(R.id.ac);
        del = findViewById(R.id.del);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        //adding button
        dot.setOnClickListener(this);
        convert.setOnClickListener(this);
        ac.setOnClickListener(this);
        del.setOnClickListener(this);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
    }

    private void setNaviganitoClick() {
        navigationView = findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.about_app:
                        AlertDialog.Builder details_dialog = new AlertDialog.Builder(MainActivity.this);
                        View details_view = getLayoutInflater().inflate(R.layout.app_details,null);
                        details_dialog.setView(details_view);
                        final AlertDialog app_details_dialog = details_dialog.create();
                        app_details_dialog.show();
                        break;
                    case R.id.about_developer:
                        AlertDialog.Builder dev_dialog = new AlertDialog.Builder(MainActivity.this);
                        View dev_view = getLayoutInflater().inflate(R.layout.about_developer,null);
                        dev_dialog.setView(dev_view);
                        final AlertDialog dialog = dev_dialog.create();
                        dialog.show();
                        facebook = dev_view.findViewById(R.id.facebook);
                        facebook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent FacebookIntent = openFacebook(MainActivity.this);
                                startActivity(FacebookIntent);
                            }
                        });
                        break;
                    case R.id.share_app:
                        ApplicationInfo api = getApplicationContext().getApplicationInfo();
                        String apkPath = api.sourceDir;
                        Intent intent1 = new Intent(Intent.ACTION_SEND);
                        intent1.setType("application/vnd.android.package-archive");
                        intent1.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkPath)));
                        startActivity(Intent.createChooser(intent1,"Share this app using.."));
                        break;
                    case R.id.exit_app:
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    public static Intent openFacebook(Context context){
        try {
            context.getPackageManager().getPackageInfo("com.facebook.catana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100004603357087"));
        } catch (PackageManager.NameNotFoundException e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sajjad.amin.100"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.a:
                inputTextView.setText(inputTextView.getText()+"A");
                break;
            case R.id.b:
                inputTextView.setText(inputTextView.getText()+"B");
                break;
            case R.id.c:
                inputTextView.setText(inputTextView.getText()+"C");
                break;
            case R.id.d:
                inputTextView.setText(inputTextView.getText()+"D");
                break;
            case R.id.e:
                inputTextView.setText(inputTextView.getText()+"E");
                break;
            case R.id.f:
                inputTextView.setText(inputTextView.getText()+"F");
                break;
            case R.id.one:
                inputTextView.setText(inputTextView.getText()+"1");
                break;
            case R.id.two:
                inputTextView.setText(inputTextView.getText()+"2");
                break;
            case R.id.three:
                inputTextView.setText(inputTextView.getText()+"3");
                break;
            case R.id.four:
                inputTextView.setText(inputTextView.getText()+"4");
                break;
            case R.id.five:
                inputTextView.setText(inputTextView.getText()+"5");
                break;
            case R.id.six:
                inputTextView.setText(inputTextView.getText()+"6");
                break;
            case R.id.seven:
                inputTextView.setText(inputTextView.getText()+"7");
                break;
            case R.id.eight:
                inputTextView.setText(inputTextView.getText()+"8");
                break;
            case R.id.nine:
                inputTextView.setText(inputTextView.getText()+"9");
                break;
            case R.id.zero:
                inputTextView.setText(inputTextView.getText()+"0");
                break;
            case R.id.dot:
                inputTextView.setText(inputTextView.getText()+".");
                break;
            case R.id.ac:
                inputTextView.setText("");
                outputTextView.setText("");
                break;
            case R.id.del:
                String str = (String) inputTextView.getText();
                if (str != null && str.length() > 0) {
                    inputTextView.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.convert:
                AlertDialog.Builder cnv_dialog = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_layout,null);
                cnv_dialog.setView(view1);
                final AlertDialog dialog = cnv_dialog.create();
                dialog.show();
                //Declaring button
                Button DecToBin,DecToOct,DecToHex,BinToDec,OctToDec,HexToDec,BinToOct,BinToHex,OctToBin,HexToBin,OctToHex,HexToOct;
                //Finding button
                DecToBin = view1.findViewById(R.id.DecToBin);
                DecToOct = view1.findViewById(R.id.DecToOct);
                DecToHex = view1.findViewById(R.id.DecToHex);
                BinToDec = view1.findViewById(R.id.BinToDec);
                OctToDec = view1.findViewById(R.id.OctToDec);
                HexToDec = view1.findViewById(R.id.HexToDec);
                BinToOct = view1.findViewById(R.id.BinToOct);
                BinToHex = view1.findViewById(R.id.BinToHex);
                OctToBin = view1.findViewById(R.id.OctToBin);
                HexToBin = view1.findViewById(R.id.HexToBin);
                OctToHex = view1.findViewById(R.id.OctToHex);
                HexToOct = view1.findViewById(R.id.HexToOct);
                //Adding listener
                final Base base = new Base();

                DecToBin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.DecToBin(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                DecToOct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.DecToOct(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                DecToHex.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.DecToHex(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                BinToDec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.BinToDec(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                OctToDec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.OctToDec(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                HexToDec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.HexToDec(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                BinToOct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.BinToOct(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                BinToHex.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.BinToHex(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                OctToBin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.OctToBin(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                HexToBin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.HexToBin(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                OctToHex.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.OctToHex(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                HexToOct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String input = inputTextView.getText().toString();
                            String output = base.HexToOct(input);
                            outputTextView.setText(output);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"Please choose appropriate method",Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}