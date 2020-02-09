# sanitas_test4
__________________________________________________________________________________________________________________
											PRUEBA TÉCNICA - TEST4
__________________________________________________________________________________________________________________


__________________________________________________________________________________________________________________
Desarrollo del ejercicio
__________________________________________________________________________________________________________________

- Primero se deben identificar los objetivos a cumplir:

  Objetivo Principal:
  * El objetivo de este ejercicio es implementar un microservicio "calculadora", usando maven + spring-boot
  
  Premisas Funcionales:
  * Este microservicio tiene que exponer un API que debe ser capaz, a partir de unos parámetros de entrada, de realizar operaciones aritméticas. 
  
  * Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. 
  
  * También se incluye con este enunciado un jar que contiene un API de traceo de operaciones que debe ser invocado por el microservicio para tracear el resultado de la operación.
  
  Premisas Técnicas:
  * debe ser un proyecto maven (cualquier versión de maven)
  * debe ser un microservicio spring-boot (cualquier versión de spring-boot)

__________________________________________________________________________________________________________________
Decisiones de implementación y solución
__________________________________________________________________________________________________________________
-  Se parte del hecho que realizar una API que expone servicios para realizar las operaciones teniendo en cuenta:
  * Alcance: se piden que soporte dos operaciones principalmente (suma y resta) con dos elementos.
  * El diseño debe ser escalable y flexible para soportar operaciones más complejas.
  
-  Teniendo en cuenta estas premisas se plantea un diseño inicial de la solución:
  * Es aconsejable definir un método genérico llamado calculadora el cual reciba una expresión como input y de esta forma los consumidores del servicio no tendrán modificaciones en el momento de adicionar nuevas operaciones.
  * El input será un string que contiene la expresión a calcular (en el momento solo dos operaciones).
  * El input string será una cadena compuesta tanto de operadores como de operandos.
  * Los operadores se definirán en una estructura tipo Enum (+, -).
  * El servicio se expone con un método GET ya que no realiza ninguna acción de persistencia de datos.
  
__________________________________________________________________________________________________________________
Iteraciones de desarrollo
__________________________________________________________________________________________________________________
- creación aplicativo spring boot
- creación service con método GET -> Calculate
- creación controller que se encargue de la lógica de cálculo de la expresión enviada 

  
__________________________________________________________________________________________________________________
Reglas para el input expresión
__________________________________________________________________________________________________________________
  * No se soporta enviar dos operadores seguidos, ejemplo: 67+-23, en su lugar la expresión debe ser: 67-23

__________________________________________________________________________________________________________________  
Entrega
__________________________________________________________________________________________________________________
//TODO
- GIT : https://github.com/iteriam/sanitas_test4.git
- Debe referirse una URL de github (o similares) a la dirección de arquitecturainternet@sanitas.es para su análisis. 

//TODO
- El entregable debe compilar en una instalación de maven totalmente limpia, debe indicarse en un fichero README tanto los pasos necesarios para generar el jar final como para ejecutarlo.
