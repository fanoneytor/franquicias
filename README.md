# Aplicación de Gestión de Franquicias

Esta es una aplicación Spring Boot diseñada para gestionar franquicias, sucursales y productos, utilizando PostgreSQL como base de datos.

## Tecnologías Utilizadas

*   **Spring Boot**: Framework para el desarrollo de aplicaciones Java.
*   **Java 17**: Lenguaje de programación.
*   **Maven**: Herramienta de gestión de proyectos y construcción.
*   **PostgreSQL**: Base de datos relacional.
*   **Docker**: Plataforma para el desarrollo, envío y ejecución de aplicaciones en contenedores.
*   **Docker Compose**: Herramienta para definir y ejecutar aplicaciones Docker multi-contenedor.

## Requisitos Previos

Antes de desplegar la aplicación, asegúrate de tener instalado lo siguiente:

*   **Java Development Kit (JDK) 17**
*   **Apache Maven**
*   **Docker Desktop** (incluye Docker Engine y Docker Compose) - [Descargar Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Estructura del Proyecto

La estructura relevante del proyecto es la siguiente:

```
franquicias/
├── src/                          # Código fuente de la aplicación Spring Boot
├── pom.xml                       # Archivo de configuración de Maven
├── Dockerfile                    # Definición para construir la imagen Docker de la aplicación
├── docker-compose.yml            # Orquestación de la aplicación y la base de datos PostgreSQL
├── .env                          # Variables de entorno para la configuración de la base de datos (IGNORADO POR GIT)
└── infra/                        # Archivos de Terraform para la gestión de infraestructura como código (IaC)
    └── .terraform.lock.hcl       # Bloqueo de versiones de proveedores de Terraform
    └── main.tf                   # Definición de recursos de infraestructura
    └── variables.tf              # Definición de variables de Terraform
    └── terraform.tfvars          # Valores de variables de Terraform (IGNORADO POR GIT)
    └── .gitignore                # Reglas de ignorado para Terraform
```

## Despliegue Local con Docker Compose

Sigue estos pasos para levantar la aplicación y la base de datos en tu entorno local usando Docker Compose.

### 1. Configuración de Variables de Entorno

La aplicación utiliza variables de entorno para conectarse a la base de datos. Estas variables se definen en el archivo `.env.local`.

Si no existe, crea un archivo llamado `.env.local` en la raíz del directorio `franquicias/` con el siguiente contenido:

```dotenv
DB_URL=jdbc:postgresql://db:5432/franquicias
DB_USERNAME=user
DB_PASSWORD=passwoed
POSTGRES_DB=franquicias
POSTGRES_USER=user
POSTGRES_PASSWORD=password
```

### 2. Construir y Ejecutar la Aplicación

Navega a la raíz del directorio `franquicias/` en tu terminal:

```bash
cd C:/Users/Fano/Desktop/DEV/Nequi/franquicias/
```

Luego, ejecuta el siguiente comando para construir la imagen de la aplicación y levantar todos los servicios definidos en `docker-compose.yml`:

```bash
docker-compose up --build
```

*   El comando `--build` asegura que la imagen de tu aplicación Spring Boot se construya desde el código fuente más reciente.
*   Docker Compose leerá las variables de entorno desde el archivo `.env` y las inyectará en el contenedor de la aplicación.
*   La base de datos PostgreSQL se iniciará primero, y luego tu aplicación se conectará a ella.

Si deseas ejecutar los contenedores en segundo plano (detached mode), puedes usar:

```bash
docker-compose up -d --build
```

### 3. Acceder a la Aplicación

Una vez que los contenedores estén en funcionamiento, la aplicación Spring Boot estará accesible en el puerto `8080` de tu máquina local.

Por ejemplo, si tienes un endpoint `/api/products`, podrías acceder a él en `http://localhost:8080/api/products`.

### 4. Detener la Aplicación

Para detener y eliminar los contenedores (pero conservando los datos de la base de datos gracias al volumen `db-data`):

```bash
docker-compose down
```

## Configuración de la Base de Datos

La base de datos PostgreSQL se configura a través del servicio `db` en `docker-compose.yml`.

*   **Nombre de la Base de Datos**: `franquicias_db`
*   **Usuario**: `user`
*   **Contraseña**: `password`

Estas credenciales son las que se esperan en el archivo `.env` y son utilizadas por la aplicación Spring Boot para establecer la conexión.

## Gestión de Infraestructura (Terraform)

La carpeta `infra/` contiene configuraciones de Terraform para la gestión de infraestructura como código (IaC). Esto permite provisionar y gestionar recursos en la nube (como instancias de base de datos, servidores de aplicaciones, redes, etc.) de manera automatizada y versionada. Para más detalles sobre cómo usar Terraform, consulta los archivos dentro de la carpeta `infra/` y la documentación oficial de Terraform.
