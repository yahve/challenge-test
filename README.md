
# Test Challenge
este es un proyecto abierto para la libre discusi'on de como fue hecho

| herramientas | Link |
| ------ | ------ |
| Java 11 | [java 11](https://openjdk.java.net/projects/jdk/11/) |
| Spring boot | [spring boot](https://start.spring.io/) |
| liquidbase | [liquidbase](https://www.liquibase.org/) |
| Docker | [docker](https://www.docker.com/) |
| testcontainer | [testcontainers](https://www.testcontainers.org/) |
| spockframework | [spockframework](http://spockframework.org/) |

# Arquitectura

Se trabaja como una arquitectura hexagonal, y los directorios fueron organizados
por ¿quien eres? y ¿que tipo? este es un ejemplo peque#o pero podemos ver que
el primer directorio en verse es usuarios dentro de el estan las carpetas de aplicaciones
dominio e infraestructura

- ¿podemos discutir algunas cosas con respecto a los directorios?, SI, siempre es bueno un feedback permanente de la comunidad

# ¿Ventajas?

 cuando trabajas con un MVP de bajo presupuesto es casi imposible usar arquitectura de microservicios
 por el motivo del costo del monitoreo de los mismos, pero eso no quiere decir que hay que hacer mal las cosas
 por ejemplo si quisieramos extender este proyecto a otro modulo por ejemplo: seguridad y todo lo que el tiene
 podemos hacer otra carpeta ¿quien eres? y dentro de el sus tipos. A mediano plazo una vez que el proyecto
 tenga sifuciente presupuesto separarlo en microservicios no va a ser un dolor de cabeza el separarlo.
 
# Test

- El proyecto cuenta con una covertura del 95% aproximadamente.
- se uso spock framework para testear unitariamente algunas funcionalidades
- para el resto se uso test de integracion con el apoyo de testcontainers


