Logo.png
TEMA:
PROYECTO FINAL

INTEGRANTES:
DIANA AVILA MACAS
davilam3@est.ups.edu.ec

SEBASTIÁN CABRERA MEZA
Ccabreram1@est.ups.edu.ec

DOCENTE:
 PABLO ANDRES TORRES PEÑA 
 
MATERIA:
 ESTRUCTURA DE DATOS
 
GRUPO:
3
 
PERIODO ACADÉMICO:
 2024-2024


Objetivos Generales 
•	Desarrollar un sistema de resolución de laberinto utilizando diferentes algoritmos de búsqueda, implementado MVC para una mejor interacción entre el usuario 
y la interfaz en donde se visualice las rutas que son más óptimas para su ejecución.

Objetivos Específicos
•	Diseñar e implementar cuatro métodos distintos para encontrar rutas en un laberinto con diversos algoritmos de Búsqueda.

Descripción del Problema 
En este proyecto se debe encontrar la ruta más efectiva entre dos puntos en un laberinto desde el punto A hasta el punto B. 
Dentro de la misma cada celda pueda ser transitable o no, afectando la capacidad de movimiento en donde se requiere 
implementar y comparar distintos algoritmos de búsqueda como el método recursivo simple, método con programación dinámica, 
BFS (Breadth-First Search), y DFS (Depth-First Search), para asi facilitar el descubrimiento de la ruta desde el punto A al 
punto B final y lograr un resultado satisfactorio para el usuario y el programador.

Descripción de la propuesta de solución
La solución presentada se basa en un algoritmo de facil comprensión, utilizando JAVA, en donde se ha establecido un punto de inicio y 
punto de final en una matriz de 10x10. Se implementaron los 4 diferentes algoritmos de búsqueda, en el cual algunos coinciden en la ruta, 
pero son diferentes en su forma de ejecución. 
Al final se implementó lo necesario en cada método teniendo en cuenta que cada celda del laberinto debe ser transitable 
así mismo dependiendo del algoritmo que de implementación. 

Criterio por integrante de su propuesta
•	Diana Avila:
Mi criterio es que cada algoritmo tiene su nivel de complejidad dependiendo de su estructura al momento de programar y mostrar al usuario el camino que se formó en el cual puede que sea corto o largo. Incluso si es que cada método es diferente pueden llegar a mismos resultados como lo es el DFS, recursivo y caché, entonces el BFS tiene el camino mas corto debido a su programación y su estructura.
	
•	Sebastian Cabrera:
La propuesta de código para el laberinto se basa en un diseño claro y modular que sigue el patrón MVC. La clase Maze maneja la lógica del laberinto y las operaciones de resolución, la vista MazeView proporciona una interfaz gráfica para interactuar con el laberinto, y el controlador MazeController la comunicación entre el modelo y la vista. 

Capturas de la implementación final de la UI.
        ![alt text](image-1.png)
        ![alt text](image-2.png)
        ![alt text](image-3.png)
        ![alt text](image-4.png)

Conclusiones
La mejor opción para encontrar la mejor ruta es el BFS es la mejor opción para encontrar el camino más corto en un laberinto. Esto se debe a que explora todas las rutas posibles de igual longitud antes de pasar a rutas más largas, asegurando así el camino más corto al destino. La programación dinámica es más útil en problemas donde las soluciones se pueden construir a partir de subsoluciones óptimas.

Consideraciones:
Que el usuario pueda generar celdas no transitables.
Y pueda generar el punto de inicio y llegada.



