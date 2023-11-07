package frontiere;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.next();
		Gaulois[] gauloisProduit = controlAcheterProduit.donnerListeVendeur(produit);
		if (gauloisProduit.equals(null)) {
			System.out.println("Désolé, personne ne vend ce produit au marché.\n");
		}
		else {
			System.out.println("Chez quel commerçant voulez-vous acheter des " + produit 
					+ " ?\n");
			for (int i = 0; i < gauloisProduit.length; i++) {
				System.out.println(i+1 + " - " + gauloisProduit[i].getNom());
			}
			int intVendeur = scan.nextInt()-1;
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " 
			+ gauloisProduit[intVendeur].getNom() + "\n");
			System.out.println("Bonjour " + nomAcheteur + ".\n");
			int nbProd = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?\n");
			int quantiteEtal = controlAcheterProduit.assezEnStock(gauloisProduit[intVendeur], nbProd);
			if (quantiteEtal == 0) {
				System.out.println(nomAcheteur + " veut acheter " + nbProd + " " 
						+ produit + ", malhereusement il n'y en a plus !\n");
			}
			else if (quantiteEtal < nbProd) {
				System.out.println(nomAcheteur + " veut acheter " + nbProd + " " 
						+ produit + ", malhereusement " + nomAcheteur + " n'en a plus que " + quantiteEtal 
						+ ". " + nomAcheteur + " achète tout le stock de " + gauloisProduit[intVendeur].getNom());
				controlAcheterProduit.retirerQuantite(gauloisProduit[intVendeur], quantiteEtal);
			}	
			else {
				System.out.println(nomAcheteur + " achète " + nbProd + " " + produit 
						+ " à " + gauloisProduit[intVendeur].getNom() + "\n");
				controlAcheterProduit.retirerQuantite(gauloisProduit[intVendeur], nbProd);
			}
		}
	}
}
