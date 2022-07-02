package com.alt.orderservice;

public class Test {

    public static void main(String[] args) {

        int a[]={5,4,10,10,6,4};

        for(int i=0;i<a.length;i++){

            for(int j = 0; j<a.length; j++){
                if(a[i]==a[j]){
                    System.out.println(a[i]);
                    break;
                }


            }
        }
    }
}
