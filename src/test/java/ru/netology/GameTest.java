package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player saint = new Player(0, "Vasy", 55);
    Player dark = new Player(1, "Petr", 67);
    Player white = new Player(2, "Ivan", 2);
    Player color = new Player(3, "Alex", 2);

    @Test
    public void shouldToWinPlayer2() { //победил 2 игрок
        Game game = new Game();
        game.register(saint); //55
        game.register(dark); //67


        int actual = game.round("Vasy", "Petr");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldToWinPlayer1() { //победил 1 игрок
        Game game = new Game();
        game.register(saint); //55
        game.register(white); //2

        int expected = 1;
        int actual = game.round("Vasy", "Ivan");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawPlayer() { //ничья
        Game game = new Game();
        game.register(white); //2
        game.register(color); //2

        int expected = 0;
        int actual = game.round("Ivan", "Alex");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNoFindPlayer() { //поиск не зарегистрированного имени
        Game game = new Game();
        game.register(saint);
        game.register(color);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anton", "Alex");
        });
    }

    @Test
    public void shouldNothingRegistration() { //в игре никто не участвовал
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anton", "Alex");
        });
    }
}
