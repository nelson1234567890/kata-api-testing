Feature: Consumo API de put user

Scenario Template: Actualizar un cliente
  Given <usuario> consume la API de fakestoreapi put-users
  When actualiza un usuario con ID <userId>
  Then la respuesta del api es el codigo http 200

  Examples:
    | Descripcion                                         | usuario | userId |
    | cliente hace la cctualizaciond e un usuario         | nelson  | 1      |
    | cliente hace la actualizacion de un usuario y falla | laura   | juannn |

