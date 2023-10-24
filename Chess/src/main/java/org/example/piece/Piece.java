package org.example.piece;

import lombok.Getter;
import lombok.Setter;
import org.example.Board;
import org.example.Box;

@Getter @Setter
public abstract class Piece {
    private PieceType type;
    private boolean isKilled = false;
    public Piece(PieceType type) {
        this.type = type;
    }

    public abstract boolean canMove(Board board, Box startBox, Box endBox);

    public boolean isCastlingMove() {
        // check if the starting and ending position are correct
        return false;
    }
}

