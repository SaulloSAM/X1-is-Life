package saulosinesio.x1_islife.classes;

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();
    private Singleton () {}

    public Planeswlaker planeswlaker = new Planeswlaker();
    public Jogadores jogador01 = new Jogadores();
    public Jogadores jogador02 = new Jogadores();
    public Jogadores jogador03 = new Jogadores();

    public static Singleton getInstance () {
        return INSTANCE;
    }
}
