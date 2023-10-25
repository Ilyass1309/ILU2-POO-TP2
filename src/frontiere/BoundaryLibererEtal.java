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
			chaine.append("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
		}
	}

}
