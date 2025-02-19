package Templates;

import java.util.List;

public class TableauDeBord {

	private Investor investor;

	
	public TableauDeBord(Investor investor) {
		super();
		this.investor = investor;
	}

	

	/**
	 * 
	 * @param nombreDeMensualiteProjet
	 * @param montantInvestiProjet
	 * @param tauxInteretProjet
	 * @param frequenceDInvestissement
	 * @param dureeDeSimulationEnMois
	 */
	public void investissementSimulation(int nombreDeMensualiteProjet, float montantInvestiProjet, float tauxInteretProjet, int frequenceDInvestissement, int dureeDeSimulationEnMois){
	
		float totalRevenu=0;
		float totalInvestissement=0;
		
		float revenu=0;
		
		for(int i=0; i<dureeDeSimulationEnMois; i++){
			System.out.println( "---> Mois = "+(i+1)+" <---" );
			for(int j=0; j<frequenceDInvestissement; j++){
				Project newProject = new Project(tauxInteretProjet, nombreDeMensualiteProjet, montantInvestiProjet);
				investor.addNewProjectEnCours(newProject);
				investor.setCapitalAInvestir(investor.getCapitalAInvestir()-montantInvestiProjet);
				totalInvestissement=totalInvestissement+montantInvestiProjet;
			}	

			for(Project p:investor.getProjetEnCours()){
				investor.setCapitalAInvestir(investor.getCapitalAInvestir()+p.getRevenuParMensualite());
				revenu = revenu+p.getRevenuParMensualite();
				totalRevenu = totalRevenu+p.getRevenuParMensualite();
			}
			System.out.println( "-> Investissement = "+montantInvestiProjet*frequenceDInvestissement);
			System.out.println( "-> Revenu = "+revenu);
			revenu=0;
			if(investor.getCapitalAInvestir()<0)
				System.out.println( "           -> Capital n�gatif");
			System.out.println( "-> Capital = "+investor.getCapitalAInvestir());
		}
		System.out.println( "-> Ce qui sort (Investissements) = "+totalInvestissement);
		System.out.println( "-> Ce qui rentre (Revenu des projets) = "+totalRevenu);
		System.out.println( "-> Etat du capital = "+investor.getCapitalAInvestir());
		

	}
	

}
