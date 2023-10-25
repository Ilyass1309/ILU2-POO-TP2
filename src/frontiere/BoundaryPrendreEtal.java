package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean bool = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder chaine = new StringBuilder();
		if (bool) {
			chaine.append("Je suis d�sol� " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.\n");
		}
		else {
			chaine.append("Bonjour" + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.\n");
			boolean boolResteEtal = controlPrendreEtal.resteEtals();
			if (!boolResteEtal) {
				chaine.append("D�sol�e " + nomVendeur + " je n'ai plus d'�tal qui ne soit pas occup�.\n");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("C'est parfait, il me reste un �tal pour vous !\n");
		chaine.append("Il me faudrait quelques renseignements :\n");
		chaine.append("Quel produit souhaitez-vous vendre ?");
		String produit = scan.next();
		chaine.append("Combien souhaitez-vous en vendre ?");
		int nbProd = scan.nextInt();
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProd);
		if (numEtal != -1) {
			chaine.append("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numEtal + "\n");
		}
	}
}

//scan.next