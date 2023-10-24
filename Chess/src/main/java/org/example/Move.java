package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.piece.Piece;

@Getter @Setter
public class Move {
    private Box startBox;
    private Box endBox;
    private Player player;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    public Move(Player p, Box startBox, Box endBox) {
        this.player = p;
        this.startBox = startBox;
        this.endBox = endBox;
    }

    public void setPieceKilled(Piece endPiece) {

    }
}
