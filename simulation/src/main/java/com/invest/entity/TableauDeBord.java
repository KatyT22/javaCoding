package com.invest.entity;

public class TableauDeBord {

	private Investor investor;
	
	public TableauDeBord(Investor investor) {
		super();
		this.investor = investor;
	}


	private void strategyUnMois(int montantAinvestirParMois, int tauxDinteretMoyen, int nombreDePartRembourseParProjet){
		
		int interetParProjet = (tauxDinteretMoyen*montantAinvestirParMois/100);
		
		//if(investor.getCapitalAInvestir()>=20){
			investor.setCapitalAInvestir((investor.getCapitalAInvestir()-montantAinvestirParMois) + ((montantAinvestirParMois+interetParProjet)/nombreDePartRembourseParProjet));
		//}			
	}
	
	
	public void strategy(int montantAinvestirParMois, int tauxDinteretMoyen, int nombreDePartRembourseParProjet, int nombreDeMoisInvesti){
	
		for(int i=0; i<nombreDeMoisInvesti; i++){
			strategyUnMois(montantAinvestirParMois, tauxDinteretMoyen, nombreDePartRembourseParProjet);
		}

	}

}
