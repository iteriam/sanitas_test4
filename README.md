## PRUEBA TÉCNICA - TEST4

### Desarrollo del ejercicio

- Primero se deben identificar los objetivos a cumplir:

  Objetivo Principal:
  * El objetivo de este ejercicio es implementar un microservicio "calculadora", usando maven + spring-boot
  
  Premisas Funcionales:

  * Este microservicio tiene que exponer un API que debe ser capaz, a partir de unos parámetros de entrada, de realizar operaciones aritméticas. 
  
  * Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. 
  
  * También se incluye con este enunciado un jar que contiene un API de traceo de operaciones que debe ser invocado por el microservicio para tracear el resultado de la operación.
  
### Decisiones de implementación y solución

Se parte del hecho que realizar una API que expone servicios para realizar las operaciones teniendo en cuenta:

  * Alcance: se piden que soporte dos operaciones principalmente (suma y resta) con dos elementos.
  
  * El diseño debe ser escalable y flexible para soportar operaciones más complejas.
  
Teniendo en cuenta estas premisas se plantea un diseño inicial de la solución:

  * Es aconsejable definir un método genérico llamado calculadora el cual reciba una expresión como input y de esta forma los consumidores del servicio no tendrán modificaciones en el momento de adicionar nuevas operaciones.
  
  * El input será un string que contiene la expresión a calcular (en el momento solo dos operaciones, en caso de usar entidades seria necesario definir estructuras tipo DTO).
  
  * El input string será una cadena compuesta tanto de operadores como de operandos.  
  * El servicio se expone con un método GET ya que no realiza ninguna acción de persistencia de datos.
   
   
### Iteraciones de desarrollo

- Creación aplicativo spring boot

- Creación service con método GET -> Calculate

- Creación controller que se encargue de la lógica de cálculo de la expresión enviada 
- Adición y uso de librería privada trace
  Se debe tener en cuenta que la implementación de la interface TracerAPI la cual según documentación es la clase TracerImpl no se cumple, ya que al tratar de crear la varible de la forma: TracerAPI trace = new TracerImpl(); no se reconoce como una implementación ya que no implementa la interface.

- Se adiciona una clase GeneralResponse, la cual servirá como estructura estandar en la respuesta de los servicios, la cual tiene un campo message para dar claridad al cliente si hubo algún error en la expresión ingresada.
  
### Reglas para el input expresión

  * No se soporta enviar dos operadores seguidos, ejemplo: 67+-23, en su lugar la expresión debe ser: 67-23.
  
  * El separador decimal es el caracter punto "." en caso de enviar una "," se remplazará por un punto.

### Contrucción
- Clonar respositorio de GITHub
[https://github.com/iteriam/sanitas_test4.git]

- Construcción de fuentes: Luego de descargar el repositorio ejecute en el directorio raiz el siguiente comando para adicionar la libreria privada de Trace:
```sh
mvn install:install-file -Dfile=\lib\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
```

```sh
mvn clean compile package install
```

### Ejecución
- Ubicarse en el directorio "target":
```sh
java -jar SanitasTest4-0.0.1-SNAPSHOT.jar
```

Ejemplos:

 * http://localhost:8080/calculate/1,3+1,7
 
 * http://localhost:8080/calculate/43+17