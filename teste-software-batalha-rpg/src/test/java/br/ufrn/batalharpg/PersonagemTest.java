package br.ufrn.batalharpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    // Testes assassino válidos

    @Test
    public void assassinoTesteValido1() {
        assertDoesNotThrow(() -> new Assassino(7, 3, 7, 3));
    }

    @Test
    public void assassinoTesteValido2() {
        assertDoesNotThrow(() -> new Assassino(6, 3, 6, 5));
    }

    @Test
    public void assassinoTesteValido3() {
        assertDoesNotThrow(() -> new Assassino(5, 5, 5, 5));
    }

    // Testes assassino inválidos

    @Test
    public void assassinoTesteInvalido1() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(6, 3, 8, 3));
        assertEquals("Para um Assassino, Ataque e Velocidade devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido2() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(3, 6, 5, 6));
        assertEquals("Para um Assassino, Ataque e Velocidade devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido3() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(5, 3, 8, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido4() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(7, 3, 8, 2));
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido5() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(7, 3, 9, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido6() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(6, 3, 8, 2));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido7() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(8, 3, 6, 3));
        assertEquals("Para um Assassino, Ataque e Velocidade devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido8() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(5, 6, 3, 6));
        assertEquals("Para um Assassino, Ataque e Velocidade devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido9() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(8, 3, 5, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido10() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(8, 3, 7, 2));
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido11() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(9, 3, 7, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido12() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(8, 3, 6, 2));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido13() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(3, 7, 3, 7));
        assertEquals("Para um Assassino, Resistência e Defesa devem ser menores ou iguais a Ataque e Velocidade.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido14() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(2, 8, 2, 8));
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido15() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(3, 6, 3, 6));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido16() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(2, 7, 2, 7));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido17() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(7, 3, 7, 2));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void assassinoTesteInvalido18() {
        Exception exception = assertThrows(IllegalStateException.class, () -> new Assassino(6, 3, 6, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }


    // Testes guerreiro válidos
    @Test
    public void guerreiroTesteValido1() {
        assertDoesNotThrow(() -> new Guerreiro(7, 3, 3, 7));
    }

    @Test
    public void guerreiroTesteValido2() {
        assertDoesNotThrow(() -> new Guerreiro(6, 3, 5, 6));
    }

    @Test
    public void guerreiroTesteValido3() {
        assertDoesNotThrow(() -> new Guerreiro(6, 5, 3, 6));
    }

    @Test
    public void guerreiroTesteValido4() {
        assertDoesNotThrow(() -> new Guerreiro(5, 5, 5, 5));
    }

    // Testes guerreiro inválidos

    @Test
    public void guerreiroTesteInvalido1() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(8, 3, 3, 6);
        });
        assertEquals("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido2() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(10, 4, 3, 3);
        });
        assertEquals("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido3() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(8, 2, 4, 6);
        });
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido4() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(8, 3, 3, 5);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido5() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(9, 4, 3, 3);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido6() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(10, 4, 2, 3);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido7() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(7, 2, 4, 6);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido8() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(9, 4, 2, 3);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido9() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(6, 3, 3, 8);
        });
        assertEquals("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido10() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(3, 4, 3, 10);
        });
        assertEquals("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido11() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(6, 2, 4, 8);
        });
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido12() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(5, 3, 3, 8);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido13() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(3, 4, 3, 9);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido14() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(3, 4, 2, 10);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido15() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(6, 2, 4, 7);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido16() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(3, 4, 2, 9);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido17() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(5, 7, 3, 5);
        });
        assertEquals("Para um Guerreiro, Defesa e Velocidade não podem exceder Resistência ou Ataque.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido18() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(5, 8, 2, 5);
        });
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido19() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(5, 6, 3, 5);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido20() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(5, 7, 2, 5);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido21() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(7, 4, 2, 7);
        });
        assertEquals("Todos os atributos devem ter pelo menos 3 pontos.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido22() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(7, 3, 2, 7);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    public void guerreiroTesteInvalido23() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Guerreiro(6, 3, 3, 6);
        });
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

}