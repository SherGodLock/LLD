package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player extends Account{
    private boolean isWhite;
    private Person person;

    public Player(Person person, boolean isWhite) {
        this.person = person;
        this.isWhite = isWhite;
    }
}
