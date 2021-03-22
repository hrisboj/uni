package RGBTopki;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // Elementi na stekot se objekti od proizvolen tip.

    // Metodi za pristap:

    public boolean isEmpty ();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek ();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:

    public void clear ();
    // Go prazni stekot.

    public void push (E x);
    // Go dodava x na vrvot na stekot.

    public E pop ();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}


class ArrayStack<E> implements Stack<E> {

    // Stekot e pretstaven na sledniot nacin:
    //depth e dlabochinata na stekot, a
    // elems[0...depth-1] se negovite elementi.
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Konstrukcija na nov, prazen stek.
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Vrakja true ako i samo ako stekot e prazen.
        return (depth == 0);
    }


    public E peek () {
        // Go vrakja elementot na vrvot od stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Go prazni stekot.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }


    public void push (E x) {
        // Go dodava x na vrvot na stekot.
        elems[depth++] = x;
    }


    public E pop () {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}




public class kutii {

    public static void funk(Stack<String> stek) {

        Stack<String> stekSredina = new ArrayStack<>(100);
        Stack<String> stekKraj = new ArrayStack<>(100);

        while (!stek.isEmpty()) {
            if (stek.peek().equals("b")) {
                stekKraj.push(stek.pop());
            } else {
                stekSredina.push(stek.pop());
            }
        }
        while (!stekSredina.isEmpty()) {
            if (stekSredina.peek().equals("g")) {
                stekKraj.push(stekSredina.pop());
            }else{
                stek.push(stekSredina.pop());
            }
        }
        while (!stek.isEmpty()){
            stekKraj.push(stek.pop());
        }

        while(!stekKraj.isEmpty()){
            System.out.println(stekKraj.pop());
        }


    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> stek = new ArrayStack<>(n);

        for(int i = 0; i < n; i++){
            stek.push(br.readLine());
        }

        funk(stek);

    }
}



