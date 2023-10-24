package org.example.piece;

import org.example.Board;
import org.example.Box;

public class Knight extends Piece{
    public Knight(PieceType type) {
        super(type);
    }

    @Override
    public boolean canMove(Board board, Box startBox, Box endBox) {
        if(endBox.getP().getType().equals(this.getType())) return false;

        int x = Math.abs(startBox.getX() - endBox.getX());
        int y = Math.abs(startBox.getY() - endBox.getY());

        return x*y == 2;
    }
}
