package apteka3;

public class Lek {
    protected int daliIma;
    protected int zaliha;
    protected int cena;

    public Lek(int daliIma, int zaliha, int cena) {
        this.daliIma = daliIma;
        this.zaliha = zaliha;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Lek{" +
                "daliIma=" + daliIma +
                ", zaliha=" + zaliha +
                ", cena=" + cena +
                '}';
    }
}
