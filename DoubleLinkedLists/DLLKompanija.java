package DoubleLinkedLists;

public class DLLKompanija {

    public void deleteElement(DLL<Integer> lista, int plata){

        DLLNode<Integer> pok = lista.getFirst();

        while(pok!=null){
            if(pok.plata < plata){
                DLLNode<Integer> temp = pok;
                pok = pok.succ;
                lista.delete(temp);
            }else{
                pok=pok.succ;
            }
        }

        if(lista.length() == 0){
            System.out.println("nema");
        }






    }










    public DLL<Integer> sortList(DLL<Integer> lista){

        DLLNode<Integer> sortedFirst = null;
        DLLNode<Integer> sorted = null;
        DLLNode<Integer> max=null;
        DLLNode<Integer> pok = lista.getFirst();

        while(lista.length()!=0){
            max = lista.getFirst();
            pok = lista.getFirst();
            while(pok!=null){
                if(pok.ID > max.ID){
                    max = pok;
                }
                pok = pok.succ;
            }

            if(sortedFirst == null){
                sortedFirst = max;
                sorted = max;
            }else{
                sorted.succ = max;
                sorted = sorted.succ;
            }
            lista.delete(max);

        }

        lista.getFirst() = sortedFirst;



    }





}
