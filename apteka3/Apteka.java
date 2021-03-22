package apteka3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Apteka {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        CBHT<String, Lek> tabela = new CBHT<>(2*n);

        for(int i=0;i<n;i++){
            String lek = br.readLine();
            String [] detali = lek.split(" ");
            int daliIma = Integer.parseInt(detali[1]);
            int zaliha = Integer.parseInt(detali[2]);
            int cena = Integer.parseInt(detali[3]);
            Lek lekObj = new Lek(daliIma, zaliha, cena);
            tabela.insert(detali[0], lekObj);
        }

        //System.out.println(tabela);
        String prebaruvaj = br.readLine();
        while(!prebaruvaj.equals("KRAJ")){
            String golemi = prebaruvaj.toUpperCase();
            int kolku = Integer.parseInt(br.readLine());
            SLLNode<MapEntry<String, Lek>> jazol = tabela.search(golemi);
            if(jazol!=null){
                System.out.println(golemi);
                if(jazol.element.value.daliIma==0){
                    System.out.println("NEG");
                }else{
                    System.out.println("POZ");
                }
                System.out.println(jazol.element.value.zaliha);
                System.out.println(jazol.element.value.cena);
                if(jazol.element.value.zaliha<kolku){
                    System.out.println("Nema dovolno lekovi");
                }else{
                    jazol.element.value.zaliha = jazol.element.value.zaliha - kolku;
                    System.out.println("Napravena naracka");
                }

            }else{
                System.out.println("nema takov lek");
            }

            prebaruvaj = br.readLine();
        }


    }




}
