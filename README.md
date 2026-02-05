# Proyecto: Loan Application

## 1. Instrucciones para ejecutar el proyecto

Este proyecto utiliza Spring Boot y Maven. Para ejecutarlo localmente:

1. **Requisitos previos:**
   - Java 17 o superior instalado.
   - Maven (o puedes usar el Maven Wrapper incluido).

2. **Compilar y ejecutar:**
   - Abre una terminal en la raíz del proyecto.
   - Ejecuta:
     ```bash
     ./mvnw spring-boot:run
   - El servicio se iniciará en el puerto por defecto (8080) y se publica en 'api/loan-requests'. Por ejemplo 'http://localhost:8080/api/loan-requests'

## 2. Arquitectura y decisiones técnicas tomadas

- **Arquitectura:**
  - El proyecto sigue una estructura típica de Spring Boot, con capas separadas para controlador (`controller`), servicio (`service`), repositorio (`repository`), DTOs (`dto`), modelos (`model`), utilidades (`utils`) y validadores (`validators`).
  - Controller: endpoints REST que reciben y responden solicitudes.
  - Service: lógica de negocio y validaciones.
  - Repository: almacenamiento en memoria cargado desde JSON (`src/main/resources/data/loanRequests.json`).
  - DTOs y Models: definición de datos de entrada/salida y modelo de dominio.
  - Validators y Utils: validaciones personalizadas (DNI/NIE, nombres, estados) y utilidades generales.

- **Decisiones técnicas:**
  - Uso de Spring Boot para facilitar la configuración y configuración automática.
  - Separación clara de responsabilidades siguiendo buenas prácticas de diseño.
  - Uso de enums para estados y monedas, mejorando la mantenibilidad y evitando errores.
  - Configuración externa mediante `application.properties` para facilitar cambios.
  - Se obiva la fecha de creación en la solicitud de préstamo, considerándolo un dato impuesto por el sistema.
  - Por defecto el estado de la solicitud de préstamo es "PENDING", ya que es el estado inicial lógico.

## 3. Posibles mejoras y extensiones

### Funcionales
- Implementar autenticación y autorización, por ejemplo JWT.
- Añadir mas endpoints como actualizar y eliminar solicitudes de préstamo.
- Internacionalización de mensajes y validaciones.
- Integración con una base de datos real.

### Técnicas / Arquitecturales
- Ampliar las pruebas unitarias e integración, aprovechando la inyección de dependencias para mantener un desarrollo ágil.
- Implementar un manejo global de excepciones que devuelva errores claros y consistentes.
- Mejorar la gestión de errores e implementar logging estructurado para facilitar el diagnóstico y seguimiento de problemas.

