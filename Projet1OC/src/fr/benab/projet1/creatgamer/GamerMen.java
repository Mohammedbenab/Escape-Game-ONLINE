package fr.benab.projet1.creatgamer;


public class GamerMen implements ICreatGame{

	@Override
	public GamerMen getGamerMen() {
		return new GamerMen();
	}

	@Override
	public GamerMachine getGamerMachine() {
		return new GamerMachine();
	}

}

