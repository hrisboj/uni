package preveduvac;

public class SLLNode<E> {
    protected E element;
    protected lozinki.SLLNode<E> succ;

    public SLLNode(E elem, lozinki.SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
