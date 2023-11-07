package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder chaine = new StringBuilder();
		if (infosMarche.length == 0) {
			chaine.append("Le marché est vide, revenez plus tard.\n");
		} else {
			chaine.append(nomAcheteur + ", vous trouverez au marché :\n");
			int i = 0;
			while (i < infosMarche.length){
				chaine.append("-" + infosMarche[i] + " qui vend " + infosMarche[i+1] + " " + infosMarche[i+2]);
				i+=3;
			}
		}
		System.out.println(chaine.toString());
	}
}
