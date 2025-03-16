Feature: Consumo API de get productos

 Scenario Template: Obtener producto con id especificado
    Given <usuario> consume la API de fakestoreapi get-productos
    When solicita el producto con ID <idProduct>
    Then el código de respuesta debe ser 200
    And la respuesta debe contener el título del producto

   Examples:
     | Descripcion                                | usuario | idProduct |
     | cliente 1 hace el correcto consumo del api | nelson  | 3         |
     | cliente 2 hace consumo incorrecto del api  | laura   | //        |


