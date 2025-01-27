# Operaciones con Elasticsearch - Postman

En este repositorio tendremos una colección de Postman con varias operaciones para ejecutar sobre nuestro clúster de Elasticsearch creado con **Bonsai.io**.

## Configuración Inicial

Recuerda crear una variable de colección en **Postman** llamada `elasticsearch-host` y asignarle el host de tu clúster. Puedes obtener este valor en **Bonsai.io** en:

```
Access -> Credentials -> Full Access
```

### Ejemplo de Configuración
Ejecuta, desde la consola de **Bonsai.io**, la operación:

```http
PUT /employees
```
Con el siguiente cuerpo:

```json
{
  "mappings": {
    "properties": {
      "Address": {
        "type": "search_as_you_type"
      },
      "Age": {
        "type": "integer"
      },
      "DateOfJoining": {
        "type": "date",
        "format": "yyyy-MM-dd"
      },
      "Designation": {
        "type": "keyword"
      },
      "FirstName": {
        "type": "text"
      },
      "Gender": {
        "type": "keyword"
      },
      "Interests": {
        "type": "text"
      },
      "LastName": {
        "type": "text"
      },
      "MaritalStatus": {
        "type": "keyword"
      },
      "Salary": {
        "type": "double"
      }
    }
  }
}
```

## Carga de Datos

Puedes cargar los datos con el siguiente comando (recuerda ejecutar el comando en el mismo directorio en el que se encuentre el fichero e incluir el host de tu clúster):

### Para Sistemas Basados en Unix:
```bash
curl -XPUT '<<host_obtenido_de_bonsai>>/_bulk' --data-binary @<<nombre_del_archivo_con_datos>>.json -H 'Content-Type: application/json'
```

### Para Sistemas Windows:
```cmd
curl -XPUT "<<host_obtenido_de_bonsai>>/_bulk" --data-binary @<<nombre_del_archivo_con_datos>>.json -H "Content-Type: application/json"
```

### Nota:
En caso de que sea necesario, puede desactivarse la verificación SSL de **cURL** con la opción `-k`.

#### Ejemplo para Windows:
```cmd
curl -k -XPUT "<<host_obtenido_de_bonsai>>/_bulk" --data-binary @<<nombre_del_archivo_con_datos>>.json -H "Content-Type: application/json"
```

## Verificación de la Carga de Datos

Nos aseguramos de que hemos cargado todos los datos ejecutando, desde la consola de **Bonsai.io**, la operación:

```http
GET /employees/_count?pretty
```


