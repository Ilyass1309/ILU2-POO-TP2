package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
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
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite ,village);
		assertNotNull(controlPrendreEtal, "Constructeur non null");
	}

	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite ,village);
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois jerome = new Gaulois("Jerome", 10);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(jerome);
		village.ajouterHabitant(timote);
		village.installerVendeur(jerome, "fleurs", 10);
		village.installerVendeur(timote, "fleurs", 12);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite ,village);
		Gaulois jerome = new Gaulois("Jerome", 10);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(jerome);
		village.ajouterHabitant(timote);
		assertEquals(controlPrendreEtal.prendreEtal("Jerome", "fleurs", 12), 0);
		
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite ,village);
		Gaulois jerome = new Gaulois("Jerome", 10);
		village.ajouterHabitant(jerome);
		village.installerVendeur(jerome, "fleurs", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Jerome"));
		assertFalse(controlPrendreEtal.verifierIdentite("pas un vendeur"));
	}

}
