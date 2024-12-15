package br.ufrn.batalharpg;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    private static final String CSV_FILE = "personagem_test_cases.csv";

    @TestFactory
    Stream<DynamicTest> carregarTestesDoCSV() throws Exception {
        List<DynamicTest> testes = new ArrayList<>();

        // Carrega o arquivo CSV do classpath
        InputStream inputStream = PersonagemTest.class.getClassLoader().getResourceAsStream(CSV_FILE);
        if (inputStream == null) {
            throw new FileNotFoundException("Arquivo não encontrado no classpath: " + CSV_FILE);
        }

        // Lê o arquivo CSV
        Reader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader("Classe", "Ataque", "Velocidade", "Resistência", "Defesa", "Saída", "MensagemEsperada")
                .withFirstRecordAsHeader()
                .parse(reader);

        // Processa cada linha do CSV como um teste
        for (CSVRecord record : records) {
            String classe = record.get("Classe").trim();
            int ataque = Integer.parseInt(record.get("Ataque").trim());
            int velocidade = Integer.parseInt(record.get("Velocidade").trim());
            int resistencia = Integer.parseInt(record.get("Resistência").trim());
            int defesa = Integer.parseInt(record.get("Defesa").trim());
            String saida = record.get("Saída").trim();
            String mensagemEsperada = record.get("MensagemEsperada").trim();

            if (saida.equalsIgnoreCase("Valido")) {
                testes.add(DynamicTest.dynamicTest(
                        "Teste Válido - " + classe + ": " + ataque + ", " + velocidade + ", " + resistencia + ", " + defesa,
                        () -> {
                            if (classe.equalsIgnoreCase("Assassino")) {
                                assertDoesNotThrow(() -> new Assassino(ataque, velocidade, resistencia, defesa));
                            } else if (classe.equalsIgnoreCase("Guerreiro")) {
                                assertDoesNotThrow(() -> new Guerreiro(ataque, velocidade, resistencia, defesa));
                            }
                        }
                ));
            } else if (saida.equalsIgnoreCase("Invalido")) {
                testes.add(DynamicTest.dynamicTest(
                        "Teste Inválido - " + classe + ": " + ataque + ", " + velocidade + ", " + resistencia + ", " + defesa,
                        () -> {
                            Exception exception = assertThrows(IllegalStateException.class, () -> {
                                if (classe.equalsIgnoreCase("Assassino")) {
                                    new Assassino(ataque, velocidade, resistencia, defesa);
                                } else if (classe.equalsIgnoreCase("Guerreiro")) {
                                    new Guerreiro(ataque, velocidade, resistencia, defesa);
                                }
                            });
                            assertEquals(mensagemEsperada, exception.getMessage());
                        }
                ));
            }
        }
        return testes.stream();
    }
}
