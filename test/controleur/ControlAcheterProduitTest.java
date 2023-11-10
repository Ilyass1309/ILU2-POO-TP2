package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
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
	void testControlAcheterProduit() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testDonnerListeVendeur() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois jerome = new Gaulois("Jerome", 10);
		village.ajouterHabitant(jerome);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(timote);
		village.installerVendeur(timote, "fleurs", 10);
		village.installerVendeur(jerome, "fleurs", 100);
		Gaulois[] gauloisProd = village.rechercherVendeursProduit("fleurs");
		for (int i = 0; i < gauloisProd.length; i++) {
			assertEquals(controlAcheterProduit.donnerListeVendeur("fleurs")[i], gauloisProd[i]);
		}
	}

	@Test
	void testAssezEnStock() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(timote);
		village.installerVendeur(timote, "fleurs", 10);
		assertEquals(controlAcheterProduit.assezEnStock(timote), 10);
	}

	@Test
	void testRetirerQuantite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois timote = new Gaulois("Timote", 8);
		village.ajouterHabitant(timote);
		village.installerVendeur(timote, "fleurs", 4);
		Etal etal = village.rechercherEtal(timote);
		controlAcheterProduit.retirerQuantite(timote, 3);
		assertEquals(etal.getQuantite(), 1);
		controlAcheterProduit.retirerQuantite(timote, 1);
		assertFalse(etal.isEtalOccupe());
	}

}
