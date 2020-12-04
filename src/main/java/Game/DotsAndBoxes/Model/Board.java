package Game.DotsAndBoxes.Model;

public abstract class Board {
    private int size;
    private int length;
    private int width;

    public Board() {
        this.length = 8;
        this.width = 8;
        this.size = 64; //count the dots


    }
    //Board
    /*
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
    | * * * * * * * * |
     */
}
