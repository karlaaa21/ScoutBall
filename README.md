<img width="2000" height="860" alt="Red and White Dynamic Soccer Team Acrylic Tumbler" src="https://github.com/user-attachments/assets/c9d75fc8-93e7-4aad-b255-30372333585f" />

## Descripcion del proyecto
ScoutBall es un sistema orientado al fútbol donde jugadores pueden buscar equipos y equipos pueden encontrar nuevos talentos.
El proyecto busca facilitar la conexión entre futbolistas y clubes mediante la gestión de postulaciones, ofertas.
---
## Integrantes
- Diego Bolivar 
- Claudio Escudero
- Karla Miranda
---
## | Tecnología | Descripción |
|:----------|:----------|
| Java 17 | Desarrollo del sistema |
| Spring Boot | Framework backend |
| Spring Data JPA | Gestión de datos |
| MySQL | Base de datos |
| Maven | Administrador de dependencias |
| Lombok | Simplificación del codigo mediane anotacioones |
| Postman | Pruebas de endpoints |

---
## Arquitectura del proyecto
El proyecto está organizado utilizando una arquitectura por capas, permitiendo una mejor separación de responsabilidades y organización del código.
src/main/java/com/scoutball

── config
── controller
── dto
── model
── repository
── service
---
## Base de Datos
El sistema utiliza la siguiente base de datos:

```tx scoutball```

## Entidades principales
- equipo
- jugador
- oferta
- postulacion
## Endpoints Disponibles
---
### Equipos
*   **Listar equipos:** `GET /api/v1/equipo` - Retorna todos los equipos.
*   **Buscar por ID:** `GET /api/v1/equipo/{id}`
*   **Crear equipo:** `POST /api/v1/equipo`
    *   *Body JSON:*
       `{
        "nombre_equipo": "Real Madrid C.F.",
        "ubicacion": "Madrid",
        "pais": "España",
        "liga": "LaLiga",
        "tecnico": "Carlo Ancelotti",
        "titulos": 36,
        "correo": "contacto@realmadrid.com",
        "numero_tlf": "+34913984300",
        "interes": "Búsqueda de talentos jóvenes en Sudamérica",
      }`
*   **Actualizar:** 
    *   **Método:** `PUT`
    *   **URL:** `/api/v1/equipo/{id}`
    *   **Descripción:** Permite modificar cualquier atributo del equipo.
    *   **Body JSON:**
    *  *   *Body JSON:*
        `{
        "nombre_equipo": "Real Madrid C.F.",
        "ubicacion": "Madrid",
        "pais": "España",
        "liga": "LaLiga",
        "tecnico": "Álvaro Arbeloa",
        "titulos": 36,
        "correo": "contacto@realmadrid.com",
        "numero_tlf": "+34913984300",
        "interes": "Búsqueda de talentos jóvenes en Sudamérica",
      }`
*   **Eliminar:** 
    *   **Método:** `DELETE`
    *   **URL:** `/api/v1/equipo/{id}`
    *   **Descripción:** Elimina permanentemente el equipo por su ID.
---
### Jugador
*  **Listar jugadores**
    *   **Método:** `GET`
    *   **URL:** `/api/v1/jugadores`
    *   **Descripción:** Retorna la lista completa de jugadores registrados.

*   **Crear jugador**
    *   **Método:** `POST`
    *   **URL:** `/api/v1/jugadores`
    *   **Body JSON:**
      ```json
      {
        "pnombre": "Alexis",
        "snombre": "Alejandro",
        "appaterno": "Sánchez",
        "apmaterno": "Sánchez",
        "nacionalidad": "Chilena",
        "fecha_nacimiento": "1988-12-19",
        "correo": "alexis.as@example.com",
        "numero_tlf": "+56912345678",
        "direccion": "Tocopilla, Chile",
        "sobre_mi": "Delantero con amplia experiencia internacional y gran regate.",
        "posicion": "Extremo / Delantero",
        "altura": 1.69,
        "peso": 62.0,
        "sexo": "Masculino",
        "pierna_habil": "Derecha",
        "representante": "Fernando Felicevich",
        "equipo": "Agente Libre"
      }
      ```
*  **Actualizar jugador**
    *   **Método:** `PUT`
    *   **URL:** `/api/v1/jugadores/{id}`
    *   **Descripción:** Permite modificar cualquier atributo del jugador.
    *   **Body JSON:**
      ```json
      {
        "pnombre": "Alexis",
        "snombre": "Alejandro",
        "appaterno": "Sánchez",
        "apmaterno": "Sánchez",
        "nacionalidad": "Chilena",
        "fecha_nacimiento": "1988-12-19",
        "correo": "alexis.new@example.com",
        "numero_tlf": "+56999999999",
        "direccion": "Marsella, Francia",
        "sobre_mi": "Actualización: Jugador en excelente forma física.",
        "posicion": "Extremo Izquierdo",
        "altura": 1.69,
        "peso": 64.5,
        "sexo": "Masculino",
        "pierna_habil": "Derecha",
        "representante": "Fernando Felicevich",
        "equipo": "Olympique de Marsella"
      }
      ```
*   **Eliminar jugador**
    *   **Método:** `DELETE`
    *   **URL:** `/api/v1/jugador/{id}`
    *   **Descripción:** Elimina permanentemente el perfil del jugador por su ID.
---
## Ofertas
*
*   **Listar ofertas**
    *   **Método:** `GET` | **URL:** `/api/v1/oferta`
    *   **Descripción:** Retorna todas las ofertas disponibles.

*   **Crear oferta**
    *   **Método:** `POST`
    *   **URL:** `/api/v1/oferta`
    *   **Body JSON:**
      ```json
      {
        "fecha_oferta": 20260514,
        "fecha_limite_oferta": 20260614,
        "posicion": "Defensa Central",
        "descripcion": "Se busca jugador con buen juego aéreo y liderazgo.",
        "correo": "scouting@club.com",
        "numero_telefonico": "+56987654321",
        "salario": "1500 USD"
      }
      ```
*   **Actualizar oferta**
    *   **Método:** `PUT`
    *   **URL:** `/api/v1/oferta/{id}`
    *   **Descripción:** Permite modificar cualquier atributo de oferta.
    *   **Body JSON:**
      ```json
      {
      "fecha_oferta": 20260514,
        "fecha_limite_oferta": 20260614,
        "posicion": "Defensa Central",
        "descripcion": "Se busca jugador con buen juego aéreo y liderazgo.",
        "correo": "scouting@club.com",
        "numero_telefonico": "+56987654321",
        "salario": "3000 USD"
      }
      ```
*  **Eliminar oferta**
    *   **Método:** `DELETE`
    *   **URL:** `/api/v1/oferta/{id}`
    *   **Descripción:** Elimina permanentemente la oferta por su ID.
    ---
    ### Postulacion
    
*  **Listar postulaciones**
    *   **Método:** `GET` | **URL:** `/api/v1/postulacion`
    *   **Descripción:** Retorna todas las postulaciones.

*   **Crear postulación**
    *   **Método:** `POST`
    *   **URL:** `/api/v1/postulacion`
    *   **Body JSON:**
      ```json
      {
        "estado": "Pendiente",
        "mensaje": "Me gustaría probarme en su club, tengo disponibilidad inmediata.",
        "fecha_postulacion": 20260514
      }
      ```
  
*  **Actualizar postulacion**
    *   **Método:** `PUT`
    *   **URL:** `/api/v1/postulacion/{id}`
    *   **Descripción:** Permite modificar cualquier atributo de postulacion.
    *   **Body JSON:**
      ```json
      {
     "estado": "Aprobada",
        "mensaje": "Me gustaría probarme en su club, tengo disponibilidad inmediata.",
        "fecha_postulacion": 20260514
      }
      ```
*  **Eliminar postulacion**
    *   **Método:** `DELETE`
    *   **URL:** `/api/v1/postulacion/{id}`
    *   **Descripción:** Elimina permanentemente postulacion por su ID.
---
* #**¿Como ejecutar el proyecto?**
  ## Paso 1:
  ### Debes clonar este repositorio en tu interpretador de codigo de preferencia que cuente con java
  ```tx https://github.com/karlaaa21/ScoutBall.git```7
  ## Paso 2:
  ### Inicia los servicios de MySQL (Laragon,XAMPP),utiliza HeidiSQL o tu cliente de base de datos preferido para verificar la conexión.
  #### - No te preocupes por las tablas, hibernate se encargara de de mapear y crear la arquitectura automaticamente al arrancar.

  ## Paso 3:
  ## El proyecto es compatible con cualquier entorno que soporte Java:
  ## -Localiza la clase principal dentro de la ruta: src/main/java/com/scoutball/ScoutBallApplication.java.
  ## -ScoutBallApplication.java. y run Java.
  
      
      
      


