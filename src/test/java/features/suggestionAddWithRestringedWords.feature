Feature: Intento de insercion con palabras prohibidas
  Scenario: intento añadir sugerencia a BDD
  	Given añado palabras prohibidas "imbecil"
    When la creo con contenido prohibido
    Then trato de insertarla
	And compruebo que no fue posible