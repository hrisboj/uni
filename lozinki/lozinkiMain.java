package lozinki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lozinkiMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        CBHT<String, String> table = new CBHT<>(2*N);
        for(int i=1; i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            table.insert(pom[0], pom[1]);
        }

        while(true){
            String line = br.readLine();
            if(line.equals("KRAJ"))
                break;
            String parts [] = line.split(" ");
            SLLNode<MapEntry<String, String>> temp = table.search(parts[0]);
            if(temp == null  || !(temp.element.value.equals(parts[1])))
                System.out.println("Nenajaven");
            else{
                System.out.println("Najaven");
                break;
            }
        }




    }




}
