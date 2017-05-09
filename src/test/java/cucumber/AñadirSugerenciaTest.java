package cucumber;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pSystem.Application;
import pSystem.SistemaDeParticipacion.ManageSuggestion;
import pSystem.model.Suggestion;

@ContextConfiguration(classes=Application.class)
public class AñadirSugerenciaTest {
	
	@Autowired
	private ManageSuggestion manageSuggestion;
	
	public String content;
	
	private Suggestion suggestion;
	
	private Suggestion result;
	
	@Given("^contenido a añadir \"([^\"]*)\"$")
	public void givenContenido(String contenido){
		this.content = contenido;
	}
	
	@When("^creo la sugerencia$")
	public void whenCreo(){
		suggestion = new Suggestion(content, null, null);
	}
	
	@Then("^la inserto en la BDD$")
	public void thenInserto(){
		result = manageSuggestion.addSuggestion(suggestion);
	}
	
	@And("^el resultado es distinto de null$")
	public void andCompruebo(){
		Assert.assertTrue(result!=null);
	}
}
