package ruszGłowa.polimorfizm;

public class TestLodzi {
    public static void main(String[] args) {
        Lodz b1 = new Lodz();
        LodzZeglowa b2 = new LodzZeglowa();
        LodzWioslowa b3 = new LodzWioslowa();
        b2.setDlugosc(32);
        b1.plyn();
        b3.plyn();
        b2.plyn();
    }
}
