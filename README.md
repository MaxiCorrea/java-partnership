# Partnership | DDD Strategic Pattern Example

[![Pattern](https://img.youtube.com/vi/_0_LCam2fpg/0.jpg)](https://www.youtube.com/watch?v=_0_LCam2fpg)

## Que es Partnership en DDD?

Partnership es un patron estrategico de Domain-Driven Design que describe la relacion entre dos Bounded Contexts cuyos equipos tienen exito o fracasan juntos. Ambos equipos coordinan activamente sus planes de desarrollo, sus modelos y sus contratos de integracion.

### Caracteristicas clave

- **Coordinacion mutua**: Ninguno de los dos equipos impone decisiones al otro. Los cambios en el contrato de integracion se negocian y acuerdan entre ambos equipos.
- **Exito compartido**: Si uno de los contextos falla en cumplir su parte, ambos se ven afectados. Existe una dependencia bidireccional en la que los dos equipos alinean sus objetivos.
- **Sincronizacion continua**: Los equipos mantienen comunicacion frecuente para evolucionar juntos el modelo compartido y los contratos de integracion.
- **Sin upstream/downstream**: A diferencia de patrones como Customer-Supplier, en Partnership no hay una relacion de poder asimetrica. Ambos contextos estan al mismo nivel.

### Cuando aplicarlo

- Cuando dos equipos trabajan en funcionalidades que dependen estrechamente entre si.
- Cuando ambos equipos tienen la voluntad y la capacidad de coordinarse de forma continua.
- Cuando el costo de la coordinacion es menor que el beneficio de mantener modelos alineados.

### Cuando NO aplicarlo

- Cuando los equipos no pueden sincronizarse con frecuencia (por zona horaria, organizacion, etc.).
- Cuando la relacion de dependencia es claramente unidireccional (mejor usar Customer-Supplier).
- Cuando uno de los equipos no tiene interes o capacidad de coordinar cambios.

## Ejemplo en este proyecto

Este proyecto modela la relacion Partnership entre dos Bounded Contexts de una empresa de salud: **Authorization** y **Billing**.

### Flujo

```
┌──────────────────────┐       ServiceAuthorizedV1        ┌──────────────────────┐
│    Authorization      │ ──────────────────────────────>  │       Billing         │
│   Bounded Context     │      (Published Language)        │   Bounded Context     │
└──────────────────────┘                                   └──────────────────────┘
```

1. `AuthorizationServiceUseCase` aprueba una autorizacion medica y produce el evento de dominio `ServiceAuthorized`.
2. `ServiceAuthorizedMapper` convierte el evento de dominio al contrato de integracion `ServiceAuthorizedV1`.
3. El evento se publica a traves del puerto `EventPublisher`.
4. `GeneratePreInvoiceUseCase` en el contexto de Billing consume el contrato y genera una `PreInvoice` con un copago del 20%.

### Estructura

```
src/main/java/
├── authorization/              # Bounded Context: Authorization
│   ├── domain/
│   │   ├── Authorization.java          — Agregado raiz
│   │   ├── AuthorizationId.java        — Value Object
│   │   ├── MemberId.java               — Value Object
│   │   ├── AuthorizationStatus.java    — Enum (PENDING, APPROVED)
│   │   └── ServiceAuthorized.java      — Evento de dominio
│   └── application/
│       ├── AuthorizationServiceUseCase.java  — Caso de uso: autorizar servicio
│       ├── ServiceAuthorizedMapper.java      — Mapper: evento dominio -> contrato
│       └── EventPublisher.java               — Puerto de publicacion de eventos
├── integration/
│   └── ServiceAuthorizedV1.java        — Contrato compartido (Published Language)
└── billing/                    # Bounded Context: Billing
    ├── domain/
    │   └── PreInvoice.java             — Entidad de pre-factura
    └── application/
        └── GeneratePreInvoiceUseCase.java  — Caso de uso: generar pre-factura
```

### Por que es Partnership y no otro patron?

El paquete `integration` contiene `ServiceAuthorizedV1`, el **Published Language** que ambos equipos (Authorization y Billing) acuerdan mantener juntos. Cualquier cambio en este contrato requiere coordinacion entre ambos contextos. Ninguno de los dos lo modifica unilateralmente, lo que refleja la naturaleza simetrica del Partnership.
