Feature: Insertar sugerencia en BDD
  Scenario: añado sugerencia a BDD
  	Given contenido a añadir "sugerencia en cucumber"
    When creo la sugerencia
    Then la inserto en la BDD
	And el resultado es distinto de null