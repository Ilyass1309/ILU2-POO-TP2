package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois jerome = new Gaulois("Jerome", 10);
		village.ajouterHabitant(jerome);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(timote);
		village.installerVendeur(timote, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Timote"));
		assertFalse(controlLibererEtal.isVendeur("Jerome"));
	}

	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois jerome = new Gaulois("Jerome", 10);
		village.ajouterHabitant(jerome);
		village.installerVendeur(jerome, "fleurs", 10);
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Jerome");
		String[] donneesEtal = etal.etatEtal();
		for (int i = 0; i < donneesEtal.length; i++) {
			village.installerVendeur(jerome, "fleurs", 10);
			assertEquals(controlLibererEtal.libererEtal("Jerome")[i], donneesEtal[i]);
		}
	}

}
