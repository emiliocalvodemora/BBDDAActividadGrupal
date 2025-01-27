# BBDDAActividadGrupal
Operaciones con Elasticsearch - Postman
En este repositorio tendremos una colección de Postman con varias operaciones para ejecutar sobre nuestro clúster de Elasticsearch creado con Bonsai.io.

Recuerda que deberás crear una variable de colección en Postman llamada elasticsearch-host y asignarle el host de tu clúster. Puedes obtener este valor en Bonsai.io (Access -> Credentials -> Full Access)

Ejemplo: ejecuta, desde la consola de Bonsai.io la operación PUT /employees con el siguiente cuerpo:
{
   "mappings":{
      "properties":{
         "Address":{
            "type":"search_as_you_type"
         },
         "Age":{
            "type":"integer"
         },
         "DateOfJoining":{
            "type":"date",
            "format":"yyyy-MM-dd"
         },
         "Designation":{
            "type":"keyword"
         },
         "FirstName":{
            "type":"text"
         },
         "Gender":{
            "type":"keyword"
         },
         "Interests":{
            "type":"text"
         },
         "LastName":{
            "type":"text"
         },
         "MaritalStatus":{
            "type":"keyword"
         },
         "Salary":{
            "type":"double"
         }
      }
   }
}
La carga la puedes realizar con el siguiente comando (recuerda ejecutar el comando en el mismo directorio en el que se encuentre el fichero e incluir el host de tu clúster):

Para sistemas basados en Unix:

curl -XPUT '<<host_obtenido_de_bonsai>>/_bulk' --data-binary @<<nombre_del_archivo_con_datos>>.json -H 'Content-Type: application/json'
Para sistemas Windows:

curl -XPUT "<<host_obtenido_de_bonsai>>/_bulk" --data-binary @<<nombre_del_archivo_con_datos>>.json -H "Content-Type: application/json"
En caso de que sea necesario, puede desactivarse la verificación SSL de cURL con la opción -k (ejemplo para Windows)

curl -k -XPUT "<<host_obtenido_de_bonsai>>/_bulk" --data-binary @<<nombre_del_archivo_con_datos>>.json -H "Content-Type: application/json"
Nos aseguramos de que hemos cargado todos los datos ejecutando desde la consola de Bonsai.io la operación /employees/_count?pretty que nos debería indicar que hay 9.999 registros almacenados. ¡Estamos listos para comenzar a jugar!
