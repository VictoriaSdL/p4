# API REST - Reservas de Pistas de Tenis

Este proyecto es una API REST desarrollada con Spring Boot para gestionar reservas de pistas de tenis.  
Forma parte de la práctica de la asignatura en Comillas ICAI.

## Funcionalidad

Permite realizar operaciones CRUD sobre reservas:
- **Crear** una reserva
- **Leer** una reserva por su ID
- **Actualizar** una reserva existente
- **Eliminar** una reserva

---

## Tabla de Endpoints

| Método | Ruta                      | Cuerpo JSON requerido                         | Descripción                                | Respuestas posibles                     |
|--------|---------------------------|-----------------------------------------------|--------------------------------------------|------------------------------------------|
| POST   | `/api/reservas`          | `{ "nombre": "Lucía", "fecha": "2025-04-20", "pista": 4 }` | Crea una nueva reserva                     | 201 Created, 400 Bad Request             |
| GET    | `/api/reservas/{id}`     | –                                             | Obtiene la reserva con ID indicado         | 200 OK, 404 Not Found                    |
| PUT    | `/api/reservas/{id}`     | `{ "nombre": "Nuevo Nombre", "fecha": "2025-04-25", "pista": 3 }` | Actualiza la reserva con ese ID | 200 OK, 400 Bad Request, 404 Not Found   |
| DELETE | `/api/reservas/{id}`     | –                                             | Elimina la reserva con ese ID              | 204 No Content, 404 Not Found            |

---

## Validaciones

- `nombre`: obligatorio
- `fecha`: obligatoria
- `pista`: debe estar entre 1 y 10

---

## Ejemplo de error 400 (validación)

```json
[
  {
    "mensaje": "La pista debe ser al menos la número 1",
    "campo": "pista",
    "valorRechazado": 0
  }
]
