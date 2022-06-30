package com.entreprise.metier;

public class InfosEmpruntModel implements Calculable{

	private int duree, capital;
	private double emprunt,mensualite;
	
	public InfosEmpruntModel(int capital, double emprunt,int duree) {
		this.duree = duree;
		this.capital = capital;
		this.emprunt = emprunt;
	}
	
	public double CalculMensualite(int capital, double emprunt, int duree) {
		double mensu = ( capital*(emprunt/12) ) / (1- (1 + (emprunt/12)-(12 * duree)) );
		this.mensualite=mensu;
		return mensu;
	}
	
	@Override
	public String toString() {
		return "InfosEmpruntModel [duree=" + duree + ", capital=" + capital + ", emprunt=" + emprunt + ", mensualite="
				+ mensualite + "]";
	}
	
	

	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public double getEmprunt() {
		return emprunt;
	}
	public void setEmprunt(double emprunt) {
		this.emprunt = emprunt;
	}
	public double getMensualite() {
		return mensualite;
	}
	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}
	
	
}
