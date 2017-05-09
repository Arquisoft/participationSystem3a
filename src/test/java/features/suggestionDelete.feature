Feature: Insertar y borrar en BDD
  Scenario: añado sugerencia y la elimino
  	Given contenido de la sugerencia "sugerencia para borrar"
    When he añadido la sugerencia
    Then la elimino
	And compruebo que no existe