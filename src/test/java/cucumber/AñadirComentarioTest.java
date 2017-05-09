package cucumber;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pSystem.Application;
import pSystem.SistemaDeParticipacion.ManageComment;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Comment;
import pSystem.model.Suggestion;

@ContextConfiguration(classes=Application.class)
public class AñadirComentarioTest {
	
	@Autowired
	private ManageSuggestion manageSuggestion;
	
	@Autowired
	private ManageComment manageComment;
	
	private Suggestion suggestion;
	
	private Comment comment;
	
	private Comment result;
	
	@Given("^creo la sugerencia para comentarla$")
	public void givenContenido(){
		suggestion = new Suggestion("Contenido", null, null);
		suggestion = manageSuggestion.addSuggestion(suggestion);
	}
	
	@When("^contenido del comentario \"([^\"]*)\"$")
	public void whenCreo(String comentario){
		comment = new Comment(comentario, suggestion, null);
	}
	
	@Then("^inserto el comentario$")
	public void thenInserto(){
		result = manageComment.addComment(comment);
	}
	
	@And("^compruebo que ha sido añadido$")
	public void andCompruebo(){
		Assert.assertTrue(result!=null);
	}
}
