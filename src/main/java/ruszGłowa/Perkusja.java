package ruszGłowa;

public class Perkusja {
    boolean talerze = true;
    boolean beben = true;
    void zagrajNaTalerzach() {
        System.out.println("brzdęk, brzdrzrzezdęęk");
    }
    void zagrajNaBebnie() {
        System.out.println("bam,bam, baaaa-am-am");

    }
}

    class PerkusjaTester {
        public static void main(String[] args) {
            Perkusja p = new Perkusja();
            p.zagrajNaBebnie();
            p.beben = false;
            p.zagrajNaTalerzach();
            if (p.beben ==true){p.zagrajNaBebnie();}
        }
    }