package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] donnerListeVendeur(String produit) {
		Gaulois[] gauloisProd = village.rechercherVendeursProduit(produit);
		return gauloisProd;
	}
	
	public int assezEnStock(Gaulois vendeur, int nbProd) {
		Etal etal = village.rechercherEtal(vendeur);
		return etal.getQuantite();
	}
	
	public void retirerQuantite(Gaulois vendeur, int quantite) {
		Etal etal = village.rechercherEtal(vendeur);
		etal.acheterProduit(quantite);
	}
}
