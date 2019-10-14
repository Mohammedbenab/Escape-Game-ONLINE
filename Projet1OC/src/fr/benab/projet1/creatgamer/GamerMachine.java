package fr.benab.projet1.creatgamer;

public class GamerMachine implements ICreatGame{

	@Override
	public GamerMachine getGamerMachine() {
		return new GamerMachine();
	}

	@Override
	public GamerMen getGamerMen() {
		return new GamerMen();
	}

}
