package DoubleLinkedLists;

public class DivideOddEven {

    public DLL<Integer> parni(DLL<Integer> list){
        DLLNode<Integer> pok = list.getFirst();
        DLL<Integer> parni = new DLL<Integer>();

        while(pok!=null){
            if(pok.element %2 == 0){
                parni.insertLast(pok.element);
            }
            pok = pok.succ;
        }
        return parni;

    }

    public DLL<Integer> neparni(DLL<Integer> list){

        DLLNode<Integer> pok = list.getFirst();
        DLL<Integer> neparni = new DLL<Integer>();

        while(pok!=null){
            if(pok.element%2==1){
                neparni.insertLast(pok.element);
            }
            pok = pok.succ;
        }

        return neparni;

    }

    public static void main(String[] args) {







    }




}
