Feature: Consumo API de delete productos

  Scenario Template: Eliminar producto con id especificado
    Given <usuario> relaiza una consulta de producto con el api fakestoreapi delete-productos
    When Elimina el producto con ID <idProduct>
    Then el código de respuesta debe ser 200

    Examples:
      | Descripcion                                | usuario | idProduct |
      | cliente 1 hace el correcto consumo del api | nelson  | 3         |
      | cliente 2 hace consumo incorrecto del api  | laura   | //        |


