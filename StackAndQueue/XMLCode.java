package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
public class XMLCode {


    private static boolean isValid(String s) {

        ArrayStack<String> stek = new ArrayStack<>(100);
        boolean isValid = false;
        if(s.charAt(0) == '['){
            if(s.charAt(1) != '/'){
                stek.push(s.substring(1, s.length()));
                System.out.println(stek.peek());
            }
            else{
                if(stek.peek().equals(s.substring(2, s.length()))){
                    isValid = true;
                }
                else{
                    isValid = false;

                }
            }
        }
        return isValid;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid;

       for(String red : redovi){
           if(isValid(red)){
               System.out.println(1);
           }
           else {
               System.out.println(0);
           }
       }

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni


        br.close();

    }
}
