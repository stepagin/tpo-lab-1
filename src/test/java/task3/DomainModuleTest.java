package task3;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DomainModuleTest {
    static Whale whale;

    @Test
    @DisplayName("Position change")
    public void changePosition() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        whale = new Whale();
        whale.setPosition("Лёжа");

        assertEquals("Кит меняет позицию: Лёжа\r\n", outputStream.toString());
    }

    @Test
    @DisplayName("Realize that it is a whale")
    public void realizeWhale() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        whale = new Whale();
        whale.realizeWhale();
        whale.getUsedToThoughts();

        assertEquals("Кит осознаёт себя как кит.\r\nСущество свыкается с мыслью: Я кит.\r\n", outputStream.toString());
    }

    @Test
    @DisplayName("Realize that it is not a whale")
    public void realizeNotWhale() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        whale = new Whale();
        whale.realizeNotWhale();
        whale.getUsedToThoughts();

        assertEquals("Кит осознаёт, что он не кит.\r\nСущество свыкается с мыслью: Я не кит.\r\n", outputStream.toString());
    }


}
