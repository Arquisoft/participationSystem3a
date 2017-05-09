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
import pSystem.model.RestringedWords;
import pSystem.model.Suggestion;

@ContextConfiguration(classes=Application.class)
public class AñadirSugerenciaConPalabrasProhibidas {
	
	@Autowired
	private ManageSuggestion manageSuggestion;
	
	private Suggestion suggestion;
	
	private Suggestion result;
	
	@Given("^añado palabras prohibidas \"([^\"]*)\"$")
	public void given(String contenido){
		RestringedWords word = new RestringedWords(contenido);
		word = manageSuggestion.addRestringedWord(word);
		Assert.assertFalse(word==null);
	}
	
	@When("^la creo con contenido prohibido$")
	public void when(){
		suggestion = new Suggestion("imbecil", null, null);
	}
	
	@Then("^trato de insertarla$")
	public void then(){
		result = manageSuggestion.addSuggestion(suggestion);
	}
	
	@And("^compruebo que no fue posible$")
	public void and(){
		Assert.assertNull(result);
	}
}
