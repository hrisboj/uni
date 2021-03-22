package StackAndQueue;

import java.util.Scanner;

public class MVR {

    static class Gragjanin{

        String imePrezime;
        int lKarta;
        int pasos;
        int vozacka;

        public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
            this.imePrezime = imePrezime;
            this.lKarta = lKarta;
            this.pasos = pasos;
            this.vozacka = vozacka;
        }

        public String getImePrezime() {
            return imePrezime;
        }

        public void setImePrezime(String imePrezime) {
            this.imePrezime = imePrezime;
        }

        public int getlKarta() {
            return lKarta;
        }

        public void setlKarta(int lKarta) {
            this.lKarta = lKarta;
        }

        public int getPasos() {
            return pasos;
        }

        public void setPasos(int pasos) {
            this.pasos = pasos;
        }

        public int getVozacka() {
            return vozacka;
        }

        public void setVozacka(int vozacka) {
            this.vozacka = vozacka;
        }

        @Override
        public String toString() {
            return "Gragjanin{" +
                    "imePrezime='" + imePrezime + '\'' +
                    ", lKarta=" + lKarta +
                    ", pasos=" + pasos +
                    ", vozacka=" + vozacka +
                    '}';
        }
    }



    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);


        ArrayQueue<Gragjanin> redicaLKarta = new ArrayQueue<>(100);
        ArrayQueue<Gragjanin> redicaPasos = new ArrayQueue<>(100);
        ArrayQueue<Gragjanin> redicaVozacka = new ArrayQueue<>(100);

        ArrayQueue<String> redosled = new ArrayQueue<>(100);

        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);

            if(covek.getlKarta() ==1){
                redicaLKarta.enqueue(covek);
            }
            else if(covek.getPasos() ==1){
                redicaPasos.enqueue(covek);
            }
            else redicaVozacka.enqueue(covek);

        }

        while(!(redicaLKarta.isEmpty())){
            Gragjanin pom = redicaLKarta.dequeue();
            if(pom.getPasos() == 1){
                redicaPasos.enqueue(pom);
            }
            else if(pom.getVozacka() ==1){
                redicaVozacka.enqueue(pom);
            }
            else System.out.println(pom.getImePrezime());
        }
        while (!(redicaPasos.isEmpty())){
            Gragjanin pom = redicaPasos.dequeue();
            if(pom.getVozacka() == 1){
                redicaVozacka.enqueue(pom);
            }
            else
                System.out.println(pom.getImePrezime());
        }
        while (!(redicaVozacka.isEmpty())){
            Gragjanin pom = redicaVozacka.dequeue();
            System.out.println(pom.getImePrezime());
        }


    }

}
