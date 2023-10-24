package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.piece.Piece;

@Getter @Setter
public class Box {
    int x;
    int y;
    Piece p;

    public Box(int x, int y) {
        new Box(x, y, null);
    }

    public Box(int x, int y, Piece p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public boolean isEmpty() {
        return this.p == null;
    }

    public boolean placePiece(Piece p) {
        if(this.p != null) return false;
        this.p = p;
        return true;
    }
}
