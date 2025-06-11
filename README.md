# Rick and Morty API - Backend (Spring Boot)

Este proyecto es la parte backend de la prueba técnica de desarrollo para Yobel SCM. Desarrollado en **Java con Spring Boot**, se encarga de consumir la API oficial de Rick and Morty y exponer endpoints REST simplificados para ser utilizados por el frontend.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Web (RestTemplate)
- Maven

---

## Endpoints disponibles

### `GET /api/characters/page?page={n}`  
Obtiene una página específica de personajes.

### `GET /api/characters/search?name={nombre}`  
Busca personajes por nombre (coincidencias parciales). Retorna una lista.

### `GET /api/characters/{id}`  
Obtiene el detalle de un personaje por su ID.

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/backend-yobel-prueba.git
2. Importar el proyecto en un IDE compatible (IntelliJ / Eclipse / VS Code).
3. Ejecutar la clase principal:
   ```bash
   com.ejemplo.RickAndMortyApplication
5. El servidor se levantará por defecto en:
   ```bash
   http://localhost:8080

---

## Estructura del proyecto:

src/
 └── main/
     └── java/
         └── com/ejemplo/
             ├── controller/
             ├── service/
             └── model/

---

## Notas

El backend actúa como proxy entre el frontend y la API pública, transformando y simplificando la data.
Se implementó lógica para recorrer todas las páginas en búsquedas por nombre.

---

## Autor
Rael Rivero Espinoza

---
