package StackAndQueue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Postfiks {

    public static int funk(String [] vlez) {

        ArrayStack<Integer> stek = new ArrayStack<Integer>(100);
        for (String x : vlez) {
            if (Character.isDigit(x.charAt(0))){
                stek.push(Integer.parseInt(x));
            }
            else if(x.charAt(0) == '+'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv+vtor);
            }
            else if(x.charAt(0) == '-'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv-vtor);
            }
            else if(x.charAt(0) == '*'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv*vtor);
            }
            else if(x.charAt(0) == '/'){
                int vtor = stek.pop();
                int prv = stek.pop();
                stek.push(prv/vtor);
            }

        }
        return stek.pop();
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        String [] ex = expression.split(" ");

        System.out.println(funk(ex));


        br.close();

    }
}








