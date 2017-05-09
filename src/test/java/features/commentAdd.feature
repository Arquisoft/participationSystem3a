Feature: Añadir comentario
  Scenario: Añadir comentario a sugerencia
  	Given creo la sugerencia para comentarla
    When contenido del comentario "contenido comment"
    Then inserto el comentario
	And compruebo que ha sido añadido