package test;

import controllers.TournamentController;
import models.Tournament;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validaciones.TournamentValidators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class TournamentControllerTest {

    private TournamentController controller;
    private static final String FILA_ESTUDIANTE = cargarFilaEstudiante();

    private static String cargarFilaEstudiante() {
        try (BufferedReader reader = new BufferedReader(new FileReader("student.env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("FILA_ESTUDIANTE=")) {
                    return line.substring("FILA_ESTUDIANTE=".length()).trim();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR: No se pudo leer student.env: " + e.getMessage());
        }
        return null;
    }

    private void invocarMetodoOrdenamiento(String methodName, Tournament[] data) {
        try {
            Method method = TournamentController.class.getMethod(methodName, Tournament[].class);
            method.invoke(controller, (Object) data);
        } catch (NoSuchMethodException e) {
            org.junit.jupiter.api.Assertions.fail(
                    "ERROR: El metodo '" + methodName + "(Tournament[])' no existe en TournamentController.");
        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail(
                    "ERROR al ejecutar el metodo '" + methodName + "': " + e.getMessage());
        }
    }

    private Tournament invocarBusqueda(String methodName, Tournament[] sorted, int value) {
        try {
            Method method = TournamentController.class.getMethod(methodName, Tournament[].class, int.class);
            return (Tournament) method.invoke(controller, sorted, value);
        } catch (NoSuchMethodException e) {
            org.junit.jupiter.api.Assertions.fail(
                    "ERROR: El metodo '" + methodName + "(Tournament[], int)' no existe en TournamentController.");
            return null;
        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail("ERROR al ejecutar busqueda binaria: " + e.getMessage());
            return null;
        }
    }

    @BeforeEach
    public void setUp() {
        controller = new TournamentController();

        if (FILA_ESTUDIANTE == null || FILA_ESTUDIANTE.trim().isEmpty()) {
            throw new RuntimeException("ERROR: Configure FILA_ESTUDIANTE en student.env con A o B.");
        }

        String fila = FILA_ESTUDIANTE.trim().toUpperCase();
        if (!fila.equals("A") && !fila.equals("B")) {
            throw new RuntimeException("ERROR: FILA_ESTUDIANTE debe ser A o B. Valor actual: " + FILA_ESTUDIANTE);
        }
    }

    @Test
    @DisplayName("Test 1: Validar getTotalStarterPoints()")
    public void testGetTotalStarterPoints() {
        Tournament[] tournaments = TournamentTestData.createTournaments();
        TournamentValidators.validarCalculoTotalStarterPoints(tournaments);
    }

    @Test
    @DisplayName("Test 2: Validar ordenamiento por fila")
    public void testMetodoOrdenamientoPorFila() {
        String fila = FILA_ESTUDIANTE.trim().toUpperCase();

        Tournament[] original = TournamentTestData.createTournaments();
        Tournament[] toSort = TournamentValidators.copiarArreglo(original);

        if (fila.equals("A")) {
            invocarMetodoOrdenamiento("sortBubbleDesc", toSort);
        } else {
            invocarMetodoOrdenamiento("sortSelectionDesc", toSort);
        }

        TournamentValidators.validarNoNulos(toSort);
        TournamentValidators.validarIntegridadDatos(original, toSort);
        TournamentValidators.validarOrdenDescendente(toSort);
    }

    @Test
    @DisplayName("Test 3: Validar busqueda binaria por fila")
    public void testBusquedaBinariaPorFila() {
        String fila = FILA_ESTUDIANTE.trim().toUpperCase();

        Tournament[] original = TournamentTestData.createTournaments();
        Tournament[] toSort = TournamentValidators.copiarArreglo(original);

        if (fila.equals("A")) {
            invocarMetodoOrdenamiento("sortBubbleDesc", toSort);

            Tournament r1 = invocarBusqueda("binarySearchByTotalStarterPointsFilaA", toSort, 61);
            TournamentValidators.validarBusquedaExitosa(r1, 61);

            Tournament r2 = invocarBusqueda("binarySearchByTotalStarterPointsFilaA", toSort, 50);
            TournamentValidators.validarBusquedaFallida(r2, 50);
        } else {
            invocarMetodoOrdenamiento("sortSelectionDesc", toSort);

            Tournament r1 = invocarBusqueda("binarySearchByTotalStarterPointsFilaB", toSort, 70);
            TournamentValidators.validarBusquedaExitosa(r1, 70);

            Tournament r2 = invocarBusqueda("binarySearchByTotalStarterPointsFilaB", toSort, 33);
            TournamentValidators.validarBusquedaFallida(r2, 33);
        }
    }
}
