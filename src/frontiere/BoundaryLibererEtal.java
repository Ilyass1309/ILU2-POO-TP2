package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean bool = controlLibererEtal.isVendeur(nomVendeur);
		StringBuilder chaine = new StringBuilder();
		if (!bool) {
			chaine.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0].equals("true")) {
				chaine.append("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + "\n");
				chaine.append("En revoir " + nomVendeur + ", passez une bonne journée.\n");
			}
		}
		System.out.println(chaine.toString());
	}

}
