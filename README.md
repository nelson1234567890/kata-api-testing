## Descripcion
Este es un proyecto de automatizacion de apis que usa serenity con RestAssured para realizar las solicitudes, esta construido bajo la metodologia BDD, y es por eso que esta integrado con cucumber y usa el patron de diseño screenPlay

## Funcionamiento
Para ejecutar el proyecto localmente hay que correr el comando
```
mvn clean verify
```
Esto ejecutara las pruebas declaradas en el paquete runenrs de la carpeta test.

Para obtener el informe de la ejecucion, hay que correr
```
mvn serenity:aggregate
```
## importante
Esta ejecucion se realiza automaticamente gracias al pipeline integrado en el proyecto, la ejecuion tambien puede desencadenarse manualmente.

Y seguramente si lo notaste, al entrar en los actions veras un error relacionado a la ejecucion del proyecto, pero es normal, ya que este proyecto hace el consumo para ver el resultado diferente a exitoso de las apis.

Y finalmente puedes descargar el artefacto con el reporte generado al consumir las apis, este se llama index.html
