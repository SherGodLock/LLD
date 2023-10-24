package org.example.piece;

import org.example.Board;
import org.example.Box;

public class Rook extends Piece{
    public Rook(PieceType type) {
        super(type);
    }

    @Override
    public boolean canMove(Board board, Box startBox, Box endBox) {
        return false;
    }
}
