Feature: Consumo API de post cart

  Scenario Template: crear cart especificado
    Given <usuario> crea un cart al consumir el API tipo post de fakestoreapi post-carts
    When crear un cart con el <userId> y productos especificados
    Then la respuesta debe tener codigo http 200
    And la respuesta debe contener el id del <userId>

    Examples:
      | Descripcion                                                             | usuario | userId |
      | cliente hace la creacion del cart con los productos adecuadamente       | nelson  | 3      |
      | cliente hace la creacion del cart con los productos y falla la creacion | laura   | 29     |


