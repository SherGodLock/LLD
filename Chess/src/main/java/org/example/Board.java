package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.piece.*;

@Getter @Setter
public class Board {
    public static final int DEFAULT_SIZE = 8;
    Box[][] boxes;

    public Board() {
        boxes = new Box[DEFAULT_SIZE][DEFAULT_SIZE];

        for(int i=0;i<DEFAULT_SIZE;i++)
        {
            for(int j=0;j<DEFAULT_SIZE;j++)
            {
                boxes[i][j] = new Box(i, j);
            }
        }

        // initialize white pieces
        boxes[0][0] = new Box(0, 0, new Rook(PieceType.WHITE));
        boxes[0][1] = new Box(0, 1, new Knight(PieceType.WHITE));
        boxes[0][2] = new Box(0, 2, new Bishop(PieceType.WHITE));
        //...
        boxes[1][0] = new Box(1, 0, new Pawn(PieceType.WHITE));
        boxes[1][1] = new Box(1, 1, new Pawn(PieceType.WHITE));
        //...

        // initialize black pieces
        boxes[7][0] = new Box(7, 0, new Rook(PieceType.BLACK));
        boxes[7][1] = new Box(7, 1, new Knight(PieceType.BLACK));
        boxes[7][2] = new Box(7, 2, new Bishop(PieceType.BLACK));
        //...
        boxes[6][0] = new Box(6, 0, new Pawn(PieceType.BLACK));
        boxes[6][1] = new Box(6, 1, new Pawn(PieceType.BLACK));
        //...
    }

    public Box getBox(int i, int j) {
        return this.boxes[i][j];
    }
}
