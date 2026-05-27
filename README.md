# Examen Practico - Ordenamiento y Busqueda de Torneos

## Enunciado

Se tiene una estructura de datos con tres modelos:

- `Tournament` (torneo), que contiene un arreglo de `Club`.
- `Club` (club), que contiene un arreglo de `Athlete`.
- `Athlete` (atleta), con nombre, puntos y estado de titular.

## Estructura y Atributos Exactos

### Clase `Athlete`
Atributos obligatorios:

- `private String name;`
- `private int points;`
- `private boolean isStarter;`

### Clase `Club`
Atributos obligatorios:

- `private String name;`
- `private Athlete[] athletes;`

### Clase `Tournament`
Atributos obligatorios:

- `private String name;`
- `private Club[] clubs;`

Adicionalmente, `Tournament` debe implementar el campo calculado:

```java
public int getTotalStarterPoints()
```

Este metodo debe sumar los puntos de todos los atletas con `isStarter = true` en todos los clubes del torneo.

---

## Requerimientos

### 1. Campo calculado en Tournament (OBLIGATORIO)

Implementar correctamente:

```java
public int getTotalStarterPoints() {
    // Implementar aqui
}
```

### 2. Metodo de ordenamiento segun fila

Implementar el metodo de ordenamiento correspondiente:

| Fila | Algoritmo      | Orden      | Nombre exacto del metodo |
|------|----------------|------------|--------------------------|
| A    | Bubble Sort    | Descendente| `sortBubbleDesc`         |
| B    | Selection Sort | Descendente| `sortSelectionDesc`      |

### 3. Busqueda binaria segun fila

Implementar metodos de busqueda binaria para cada fila (arreglo previamente ordenado en descendente):

```java
public Tournament binarySearchByTotalStarterPointsFilaA(Tournament[] tournaments, int totalStarterPoints)
public Tournament binarySearchByTotalStarterPointsFilaB(Tournament[] tournaments, int totalStarterPoints)
```

Tabla de busquedas por fila:

| Fila | Busqueda 1                    | Busqueda 2                  |
|------|-------------------------------|-----------------------------|
| A    | 61 puntos (existe)            | 50 puntos (no existe)       |
| B    | 70 puntos (existe)            | 33 puntos (no existe)       |

### 4. Salida en consola

Implementar `main` para mostrar:

1. Listado original.
2. Listado ordenado para Fila A.
3. Resultado de las 2 busquedas de Fila A.
4. Listado ordenado para Fila B.
5. Resultado de las 2 busquedas de Fila B.

---

## Configuracion Obligatoria

En `student.env`:

```env
STUDENT_NAME=SU-NOMBRE-COMPLETO
STUDENT_EMAIL=su.email@est.ups.edu.ec
FILA_ESTUDIANTE=A
```

Cambiar `FILA_ESTUDIANTE` a `A` o `B` segun corresponda.

---

## Compilacion y Pruebas Locales

```bash
mkdir -p bin
javac -cp "lib/*" -d bin $(find src -name "*.java")
```

```bash
java -cp "tools/junit-platform-console-standalone-1.7.0.jar:bin:lib/*" \
  org.junit.platform.console.ConsoleLauncher \
  --select-class "test.TournamentControllerTest" \
  --details tree
```

---

## Rubrica

| Requerimiento                    | Puntos |
|----------------------------------|--------|
| Campo calculado                  | 2.6    |
| Ordenamiento por fila            | 2.6    |
| Busqueda binaria por fila        | 2.6    |
| Salida en consola                | 2.0    |
| **Total**                        | **10** |

---

## Archivos Clave de Esta Evaluacion

- `src/models/Athlete.java`
- `src/models/Club.java`
- `src/models/Tournament.java`
- `src/controllers/TournamentController.java`
- `src/test/TournamentTestData.java`
- `src/test/TournamentControllerTest.java`
- `src/AppTournament.java`
- `lib/validadores-torneos.jar`
