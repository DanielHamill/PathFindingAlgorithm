package hamill.daniel.utils;

import hamill.daniel.entity.Entity;

public class Chromosome {
	
	public Double fitness;
	public GeneticAlgorithm ga;
	public Entity entity;
	public String path;
	public boolean ran;

	public Chromosome(String path, GeneticAlgorithm ga) {
		this.ga = ga;
		this.path = path;
		fitness = 0d;
		entity = new Entity(160, 120, this, path);
		ran = false;
	}

}
