# Proyect Tasks Challenge

# Instalacion y Ejecucion:
1- Buildeo del proyecto
2- Se carga una DB en memoria con las reglas de los tipos de tarea 
al inicio de la ejecucion del proyecto, los datos se encuentran en 
data.sql, estas reglas se pueden cambiar en este archivo y antes de 
ejecutar el microservicio.

## Ejecucion
accediendo al swagger-ui en: http://localhost:8080/swagger-ui.html#/

2- Para almacenar una nueva tarea:
http://localhost:8080/swagger-ui.html#/task-controller/saveTaskUsingPOST
    a- Al almacenar se aplicaran las reglas de cada tipo de tarea, 
       donde se emitira un mensaje de guardado o un error en su defecto. 
    b- Las tareas son almacenadas en una base de datos en memoria. 

3- Para obtener toda la lista de tareas:
    http://localhost:8080/v1/tasks/listAll

4- Se puede obtener una tarea por id:
    http://localhost:8080/v1/tasks/{id}

# Autor: Raul Espinola - raulespinola@gmail.com

