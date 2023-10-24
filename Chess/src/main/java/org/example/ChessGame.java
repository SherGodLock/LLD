package org.example;

import org.example.piece.King;
import org.example.piece.Piece;
import org.example.piece.PieceType;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    private Player[] player;
    private Board board;
    private GameStatus status;
    private List<Move> moves;
    private Player currentTurn;

    public ChessGame(Player player1, Player player2) {
        this.board = new Board();
        this.status = GameStatus.ACTIVE;
        this.player = new Player[2];
        this.player[0] = player1;
        this.player[1] = player2;
        this.moves = new ArrayList<>();

        if(player2.isWhite()) {
            this.currentTurn = player2;
        }
        else this.currentTurn = player1;
    }

    public void resetBoard() {
        this.board = new Board();
    }

    public boolean playMove(Player p, int i, int j, int fi, int fj) {
        if(!currentTurn.equals(p)) return false;

        Box startBox = this.board.getBox(i, j);
        Box endBox = this.board.getBox(fi, fj);
        Move move = new Move(p, startBox, endBox);

        return move(move, p);
    }

    public boolean move(Move move, Player p) {
        Piece sourcePiece = move.getStartBox().getP();
        if(sourcePiece == null) return false;
        if(!(p.isWhite() && sourcePiece.getType().equals(PieceType.WHITE)))
        {
            return false;
        }

        if(!sourcePiece.canMove(this.board, move.getStartBox(), move.getEndBox())) return false;

        Piece destPiece = move.getEndBox().getP();
        if(destPiece != null)
        {
            move.setPieceKilled(destPiece);
            destPiece.setKilled(true);
        }

        if (sourcePiece != null && sourcePiece instanceof King
                && sourcePiece.isCastlingMove()) {
            move.setCastlingMove(true);
        }

        moves.add(move);

        move.getEndBox().setP(sourcePiece);
        move.getStartBox().setP(null);

        if(destPiece instanceof King)
        {
            if(currentTurn.isWhite())
            {
                this.status = GameStatus.WHITE_WIN;
            }
            else this.status = GameStatus.BLACK_WIN;
        }

        this.currentTurn = this.currentTurn == player[0] ? player[1] : player[0];

        return true;
    }
}


enum GameStatus {
    ACTIVE, BLACK_WIN, WHITE_WIN, FORFEIT, STALEMATE, RESIGNATION
}
