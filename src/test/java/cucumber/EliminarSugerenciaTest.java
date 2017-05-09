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
public class EliminarSugerenciaTest {
	
	@Autowired
	private ManageSuggestion manageSuggestion;
	
	private Suggestion suggestion;
	
	private Suggestion result;
	
	@Given("^contenido de la sugerencia \"([^\"]*)\"$")
	public void givenContenido(String contenido){
		suggestion = new Suggestion(contenido, null, null);
		result = manageSuggestion.addSuggestion(suggestion);
	}
	
	@When("^he añadido la sugerencia$")
	public void whenCreo(){
		Assert.assertTrue(result!=null);
	}
	
	@Then("^la elimino$")
	public void thenInserto(){
		manageSuggestion.deleteSuggestion(result.getId());
	}
	
	@And("^compruebo que no existe$")
	public void andCompruebo(){
		Assert.assertNull(manageSuggestion.getSuggestion(result.getId()));
	}
}
