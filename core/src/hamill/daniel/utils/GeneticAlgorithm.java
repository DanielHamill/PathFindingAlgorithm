package hamill.daniel.utils;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Batch;

import hamill.daniel.Main;
import hamill.daniel.screens.MainScreen;

public class GeneticAlgorithm {

	private static final int GENERATION_SIZE = 200;
	private static final double MUTATION_RATE = 0.1;
	
	public MainScreen screen;
	
	private ArrayList<Chromosome[]> generations;
	private int currentGen;
	private Random r;
	private boolean running;
	
	public GeneticAlgorithm(MainScreen screen) {
		this.screen = screen;
		
		generations = new ArrayList<Chromosome[]>();
		generations.ensureCapacity(30);
		currentGen = 0;
		r = new Random();
		running = false;
	}
	
	public void tick(float delta) {
		if(running) {
			runGen();
			
			boolean allDone = true;
			for(Chromosome ch: generations.get(currentGen)) {
				if(!ch.ran) allDone = false;
			}
			
			if(allDone) {
				evaluateGen();
				currentGen++;
				createNextGen();
			}
		}
	}
	
	public void draw(Batch batch) {
		for(Chromosome ch: generations.get(currentGen)) {
			ch.entity.draw(batch);
		}
	}
	
	public void runProgram() {
		generateGeneration();
		running = true;
	}
	
	public void runGen() {
		for(Chromosome ch: generations.get(currentGen)) {
			ch.entity.run();
		}
	}
	
	public void evaluateGen() {
		for(Chromosome ch: generations.get(currentGen)) {
			double efficiency = 99999999999d;
			if(ch.reachedGoal) efficiency = ch.entity.distance;
			ch.fitness = (double) (1/(new Vec2(25,25,0).distanceFrom(ch.entity.current))) * 1000;
			System.out.println(efficiency);
			System.out.println(ch.fitness);
		}
	}
	
	public void createNextGen() {
		ArrayList<Chromosome> genePool = new ArrayList<Chromosome>();
		generations.add(new Chromosome[GENERATION_SIZE]);
		
		for(Chromosome ch: generations.get(currentGen-1)) {
			for(int i = 0; i < ch.fitness; i++) {
				genePool.add(ch);
			}
		}
		
		for(int i = 0; i < GENERATION_SIZE; i++) {
			generations.get(currentGen)[i] = cross(genePool.get((int) (Math.random()*genePool.size())),genePool.get((int) (Math.random()*genePool.size())));
		}
	}
	
	public void generateGeneration() {
		generations.add(new Chromosome[GENERATION_SIZE]);
		for(int i = 0; i < GENERATION_SIZE; i++) {
			generations.get(currentGen)[i] = new Chromosome(generateString(), this, screen);
		}
	}
	
	public String generateString() {
		String path = "";
		for(int i = 0; i < 20; i++) {
			path += Integer.toBinaryString(r.nextInt(2)) +
					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*5)+1)))) + 
					Integer.toBinaryString(r.nextInt(2)) +
					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*5)+1)))) +
					String.format("%08d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*50)+1))));
		}
		return path;
	}
	
	public Chromosome cross(Chromosome ch1, Chromosome ch2) {
		int midPoint = (int) (Math.random()*ch1.path.length());
		Chromosome newCh = new Chromosome(ch1.path.substring(0, midPoint) + ch2.path.substring(midPoint, ch2.path.length()),this, screen);
		String oldPath = newCh.path;
		if(Math.random()<=MUTATION_RATE) {
			int mutatedIndex = (int) (Math.random()*oldPath.length());
			String newPath = oldPath.substring(0, mutatedIndex) + (oldPath.charAt(mutatedIndex)=='0'?"1":"0") + oldPath.substring(mutatedIndex+1,oldPath.length());
			return new Chromosome(newPath, this, screen);
		}
		return newCh;
	}
	
	int randomWithRange(int min, int max) {
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
}
