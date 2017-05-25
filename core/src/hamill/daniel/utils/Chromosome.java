package hamill.daniel.utils;

import hamill.daniel.entity.Entity;
import hamill.daniel.screens.MainScreen;

public class Chromosome {
	
	public Double fitness;
	public MainScreen screen;
	public Entity entity;
	public String path;
	public boolean ran;
	public boolean reachedGoal;

	public Chromosome(String path, GeneticAlgorithm ga, MainScreen screen) {
		this.screen = screen;
		this.path = path;
		fitness = 0d;
		entity = new Entity(310, 220, this, path, screen);
		ran = false;
	}

}
