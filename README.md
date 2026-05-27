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

Este campo calculado permite obtener rapidamente el total de puntos titulares de un torneo para poder comparar torneos al ordenar y para usar ese valor como criterio en la busqueda binaria.

Implementar correctamente:

```java
public int getTotalStarterPoints() {
    // Implementar aqui
}
```

### 2. Metodo de ordenamiento segun fila

Implementar el metodo de ordenamiento correspondiente:

| Fila | Algoritmo      | Orden       | Nombre exacto del metodo |
|------|----------------|-------------|--------------------------|
| A    | Bubble Sort    | Descendente | `sortBubbleDesc`         |
| B    | Selection Sort | Descendente | `sortSelectionDesc`      |

### 3. Busqueda binaria segun fila

Cada fila debe ejecutar la busqueda usando exactamente los parametros asignados en la tabla (Fila A o Fila B) e imprimir en consola, para cada busqueda, si el torneo fue encontrado o no.

Implementar metodos de busqueda binaria para cada fila (arreglo previamente ordenado en descendente):

```java
// FILA A
public Tournament binarySearchByTotalStarterPointsFilaA(Tournament[] tournaments, int totalStarterPoints)

// FILA B
public Tournament binarySearchByTotalStarterPointsFilaB(Tournament[] tournaments, int totalStarterPoints)
```

Tabla de busquedas por fila:

| Fila | Busqueda 1 | Busqueda 2 |
|------|------------|------------|
| A    | 61 puntos  | 50 puntos  |
| B    | 70 puntos  | 33 puntos  |

### 4. Salida en consola

Implementar `main` para mostrar, segun la fila asignada:

Fila A:
1. Listado original.
2. Listado ordenado para Fila A.
3. Resultado de las 2 busquedas de Fila A.

Fila B:
1. Listado original.
2. Listado ordenado para Fila B.
3. Resultado de las 2 busquedas de Fila B.

Adicionalmente, deben tomar una captura (o capturas) de la salida de consola y agregarla(s) al final de este README como evidencia. En la captura debe verse claramente:

1. Listado original.
2. Listado ordenado para Fila X.
3. Resultado de las 2 busquedas de Fila X.

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

| Requerimiento                              | Puntos |
|--------------------------------------------|--------|
| Campo calculado                            | 2.6    |
| Ordenamiento por fila                      | 2.6    |
| Busqueda binaria por fila                  | 2.6    |
| Salida en consola Capturas en README       | 2.0    |
| **Total**                                  | **10** |


# CAPUTRA/S DE SOLUCION EN CONSOLA: