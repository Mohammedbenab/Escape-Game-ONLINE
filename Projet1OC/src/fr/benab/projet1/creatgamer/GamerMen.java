package fr.benab.projet1.creatgamer;


public class GamerMen implements ICreatGamer{

	@Override
	public GamerMen getGamerMen() {
		return new GamerMen();
	}

	@Override
	public GamerMachine getGamerMachine() {
		return new GamerMachine();
	}

}

