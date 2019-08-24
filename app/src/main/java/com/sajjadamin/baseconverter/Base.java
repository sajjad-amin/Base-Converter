package com.sajjadamin.baseconverter;

import java.util.ArrayList;

public class Base {
    public String DecToBin(String inp){
        float firstFloat, floatPart;
        int intPart;
        String binOfInt,binOfFrac,output = null;
        ArrayList<String> arr3 = new ArrayList<String>();
        //converting float
        firstFloat = Float.parseFloat(inp);
        //int part
        intPart = (int) firstFloat;
        //float part
        String[] arr1 = inp.split("\\.");
        if(arr1.length == 2){
            floatPart = Float.parseFloat("."+arr1[1]);
            for(int i = 1; i <= 5; i++){
                float x = floatPart * 2;
                arr3.add(Integer.toString((int)x));
                String[] arr2 = Float.toString(x).split("\\.");
                floatPart = Float.parseFloat("."+arr2[1]);
            }
        }
        //binary of int part
        binOfInt = Integer.toBinaryString(intPart);
        //final result
        if(arr1.length == 2){
            //binary of float part
            binOfFrac = arr3.get(0)+arr3.get(1)+arr3.get(2)+arr3.get(3)+arr3.get(4);
            output = binOfInt+"."+binOfFrac;
        }else{
            output = binOfInt;
        }
        return output;
    }
    //Decimal to Octal
    public String DecToOct(String inp){
        float firstFloat, floatPart;
        int intPart;
        String octOfInt,octOfFrac,output = null;
        ArrayList<String> arr3 = new ArrayList<String>();
        //converting float
        firstFloat = Float.parseFloat(inp);
        //int part
        intPart = (int) firstFloat;
        //float part
        String[] arr1 = inp.split("\\.");
        if(arr1.length == 2){
            floatPart = Float.parseFloat("."+arr1[1]);
            for(int i = 1; i <= 5; i++){
                float x = floatPart * 8;
                arr3.add(Integer.toString((int)x));
                String[] arr2 = Float.toString(x).split("\\.");
                floatPart = Float.parseFloat("."+arr2[1]);
            }
        }
        //octal of int part
        octOfInt = Integer.toOctalString(intPart);
        //final result
        if(arr1.length == 2){
            //octal of float part
            octOfFrac = arr3.get(0)+arr3.get(1)+arr3.get(2)+arr3.get(3)+arr3.get(4);
            output = octOfInt+"."+octOfFrac;
        }else{
            output = octOfInt;
        }
        return output;
    }
    //Decimal to Hexadecimal
    public String DecToHex(String inp){
        float firstFloat, floatPart;
        int intPart;
        String hexOfInt,hexOfFrac,output = null;
        ArrayList<String> arr3 = new ArrayList<String>();
        //converting float
        firstFloat = Float.parseFloat(inp);
        //int part
        intPart = (int) firstFloat;
        //float part
        String[] arr1 = inp.split("\\.");
        if(arr1.length == 2){
            floatPart = Float.parseFloat("."+arr1[1]);
            for(int i = 1; i <= 5; i++){
                float x = floatPart * 16;
                if((int)x >= 9){
                    arr3.add(Integer.toHexString((int)x));
                }else{
                    arr3.add(Integer.toString((int)x));
                }
                String[] arr2 = Float.toString(x).split("\\.");
                floatPart = Float.parseFloat("."+arr2[1]);
            }
        }
        //hexadecimal of int part
        hexOfInt = Integer.toHexString(intPart);
        //final result
        if(arr1.length == 2){
            //hexadecimal of float part
            hexOfFrac = arr3.get(0)+arr3.get(1)+arr3.get(2)+arr3.get(3)+arr3.get(4);
            output = hexOfInt+"."+hexOfFrac;
        }else{
            output = hexOfInt;
        }
        return output.toUpperCase();
    }
    //Binary to Decimal
    public String BinToDec(String inp){
        float firstFloat, DecOfFrac = 0;
        String intPart, floatPart = null, DecOfInt, output = null;
        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();
        //converting float
        firstFloat = Float.parseFloat(inp);
        //getting integer part
        intPart = Integer.toString((int) firstFloat);
        //decimal of integer part
        DecOfInt = Integer.toString(Integer.parseInt(intPart,2));
        //getting floating part
        String[] arr3 = inp.split("\\.");
        if(arr3.length == 2){
            floatPart = arr3[1];
            String[] arr4 = floatPart.split("(?!^)");
            for(int i = 0; i <= floatPart.length()-1; i++){
                float x = Integer.parseInt(arr4[i]) * (float) Math.pow(2, -(i+1));
                arr1.add(Float.toString(x));
            }
            for(int i = 0; i < arr1.size(); i++){
                if(arr1.get(i).contains("Infinity")){
                    arr2.add(arr1.get(i).replace("Infinity", "0"));
                }else{
                    arr2.add(arr1.get(i));
                }
            }
            for(int i = 0; i < arr2.size(); i++){
                DecOfFrac += Float.parseFloat(arr2.get(i));
            }
        }
        if(arr3.length == 2){
            output = Float.toString(Float.parseFloat(DecOfInt)+DecOfFrac);
        }else{
            output = DecOfInt;
        }
        return output;
    }
    //Octal to Decimal
    public String OctToDec(String inp){
        float firstFloat, DecOfFrac = 0;
        String intPart, floatPart = null, DecOfInt, output = null;
        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();
        //converting float
        firstFloat = Float.parseFloat(inp);
        //getting integer part
        intPart = Integer.toString((int) firstFloat);
        //decimal of integer part
        DecOfInt = Integer.toString(Integer.parseInt(intPart,8));
        //getting floating part
        String[] arr3 = inp.split("\\.");
        if(arr3.length == 2){
            floatPart = arr3[1];
            String[] arr4 = floatPart.split("(?!^)");
            for(int i = 0; i <= floatPart.length()-1; i++){
                float x = Integer.parseInt(arr4[i]) * (float)Math.pow(8, -(i+1));
                arr1.add(Float.toString(x));
            }
            for(int i = 0; i < arr1.size(); i++){
                if(arr1.get(i).contains("Infinity")){
                    arr2.add(arr1.get(i).replace("Infinity", "0"));
                }else{
                    arr2.add(arr1.get(i));
                }
            }
            for(int i = 0; i < arr2.size(); i++){
                DecOfFrac += Float.parseFloat(arr2.get(i));
            }
        }
        if(arr3.length == 2){
            output = Float.toString(Float.parseFloat(DecOfInt)+DecOfFrac);
        }else{
            output = DecOfInt;
        }
        return output;
    }
    //Hexadecimal to Binary
    public String HexToDec(String inp){
        float HexOfFrac = 0;
        String intPart, floatPart = null, DecOfInt, output = null;
        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();
        //getting integer part
        String[] arr3 = inp.split("\\.");
        intPart = arr3[0];
        if(arr3.length == 2){
            floatPart = arr3[1];
            String[] arr4 = floatPart.split("(?!^)");
            for(int i = 0; i <= floatPart.length()-1; i++){
                float x = Integer.parseInt(arr4[i], 16) * (float)Math.pow(16, -(i+1));
                arr1.add(Float.toString(x));
            }
            for(int i = 0; i < arr1.size(); i++){
                if(arr1.get(i).contains("Infinity")){
                    arr2.add(arr1.get(i).replace("Infinity", "0"));
                }else{
                    arr2.add(arr1.get(i));
                }
            }
            for(int i = 0; i < arr2.size(); i++){
                HexOfFrac += Float.parseFloat(arr2.get(i));
            }
        }
        //hexadecimal of integer part
        DecOfInt = Integer.toString(Integer.parseInt(intPart,16));
        //getting floating part
        if(arr3.length == 2){
            output = Float.toString(Float.parseFloat(DecOfInt)+HexOfFrac);
        }else{
            output = DecOfInt;
        }
        return output;
    }
    //Binary to Octal
    public String BinToOct(String inp){
        String output = DecToOct(BinToDec(inp));
        return output;
    }
    //Binary to Hexadecimal
    public String BinToHex(String inp){
        String output = DecToHex(BinToDec(inp));
        return output;
    }
    //Octal to Binary
    public String OctToBin(String inp){
        String output = DecToBin(OctToDec(inp));
        return output;
    }
    //Hexadecimal to Binary
    public String HexToBin(String inp){
        String output = DecToBin(HexToDec(inp));
        return output;
    }
    //Octal to Hexadecimal
    public String OctToHex(String inp){
        String output = DecToHex(OctToDec(inp));
        return output;
    }
    //Hexadecimal to Octal
    public String HexToOct(String inp){
        String output = DecToOct(HexToDec(inp));
        return output;
    }
}
