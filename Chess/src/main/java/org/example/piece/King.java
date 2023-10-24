package org.example.piece;

import lombok.Getter;
import lombok.Setter;
import org.example.Board;
import org.example.Box;

@Getter @Setter
public class King extends Piece{
    private boolean castlingDone = false;
    public King(PieceType type) {
        super(type);
    }

    @Override
    public boolean canMove(Board board, Box startBox, Box endBox) {
        if(endBox.getP().getType().equals(this.getType())) return false;

        int x = Math.abs(startBox.getX() - endBox.getX());
        int y = Math.abs(startBox.getY() - endBox.getY());

        if(x+y == 1)
        {
            // check if king is getting attack.
            return true;
        }

        return this.isValidCastlingMove(board, startBox, endBox);
    }

    public boolean isValidCastlingMove(Board board, Box startBox, Box endBox) {
        if(this.isCastlingDone()) return false;

        // check for the white king castling
        if(this.getType().equals(PieceType.WHITE)
                && startBox.getX() == 0 && startBox.getY() == 4 && endBox.getY() == 0) {
            // confirm if white king moved to the correct ending box
            if (Math.abs(endBox.getY() - startBox.getY()) == 2) {
                // check if there the Rook is in the correct position
                // check if there is no piece between Rook and the King
                // check if the King or the Rook has not moved before
                // check if this move will not result in king being attacked
                //...
                this.setCastlingDone(true);
                return true;
            }
        } else {
            // check for the black king castling
            this.setCastlingDone(true);
            return true;
        }

        return false;
    }
}
