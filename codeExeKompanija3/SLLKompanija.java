package codeExeKompanija3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id,int plata, SLLNode succ) {
        this.id = id;
        this.plata=plata;
        this.succ = succ;
    }


}

class SLL {
    private SLLNode first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }


    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id,plata, first);
        first = ins;
    }

    public void insertLast(int id,int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id,plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }


    public SLL brisi_pomali_od(int iznos) {
        // Vasiot kod tuka
        SLLNode current = this.first;
        SLLNode pred = this.first;

        while(current!=null){
            if(current.plata<iznos){
                if(current == this.first){
                    this.first = current.succ;
                    current = this.first;
                    pred = this.first;

                }else{
                    pred.succ = current.succ;
                    current = current.succ;
                }
            }else{
                pred = current;
                current = current.succ;
            }

        }
        return this;


    }

    public SLL sortiraj_opagacki() {
        // Vasiot kod tuka

        SLLNode current = this.first;


        while(current!=null){
            SLLNode pomosen = current.succ;
            while (pomosen!=null){
                if(current.id < pomosen.id){
                    int smeniId = current.id;
                    current.id = pomosen.id;
                    pomosen.id = smeniId;

                    int smeniPLata = current.plata;
                    current.plata = pomosen.plata;
                    pomosen.plata = smeniPLata;
                }
                pomosen = pomosen.succ;
            }
            current=current.succ;
        }

        return this;

    }
    public void pecati (SLL lista)
    {
        SLLNode p=lista.first;
        while(p!=null)
        {
            System.out.println(p.id+","+p.plata);
            p=p.succ;
        }
    }

}
public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s=stdin.readLine();
            String s1=stdin.readLine();
            lista1.insertLast(Integer.parseInt(s),Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1=lista1.brisi_pomali_od(Integer.parseInt(s));
        if(lista1!=null)
        {
            lista1=lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }

    }
}
