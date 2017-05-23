package hamill.daniel.utils;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Batch;

import hamill.daniel.entity.Entity;

public class GeneticAlgorithm {

	private static final int GENERATION_SIZE = 200;
	
	private ArrayList<String[]> generations;
	private int currentGen;
	private int currentIndividual;
	private Random r;
	private Entity entity;
	
	public GeneticAlgorithm() {
		generations = new ArrayList<String[]>();
		generations.ensureCapacity(30);
		currentGen = 0;
		entity = new Entity(100,100);
		r = new Random();
	}
	
	public void tick(float delta) {
//		entity.tick(delta);
		runGen();
	}
	
	public void draw(Batch batch) {
		entity.draw(batch);
	}
	
	public void runProgram() {
		generateGeneration();
		runGen();
	}
	
	public void runGen() {
		for(String bitString: generations.get(currentGen)) {
			entity.current.x = 100;
			entity.current.y = 100;
			entity.interpret(bitString);
		}
	}
	
	public void evaluateGen() {
		
	}
	
	public void generateGeneration() {
		generations.add(new String[GENERATION_SIZE]);
		for(int i = 0; i < GENERATION_SIZE; i++) {
			generations.get(currentGen)[i] = generateString();
		}
	}
	
	public String generateString() {
		String path = "";
		for(int i = 0; i < randomWithRange(5,25); i++) {
			path += Integer.toBinaryString(r.nextInt(2)) +
					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*15)+1)))) + 
					Integer.toBinaryString(r.nextInt(2)) +
					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*15)+1)))) +
					String.format("%08d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*50)+1))));
//			System.out.println(Integer.toBinaryString(r.nextInt(2)) +
//					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*15)+1)))) + 
//					Integer.toBinaryString(r.nextInt(2)) +
//					String.format("%04d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*15)+1)))) +
//					String.format("%08d", Integer.parseInt(Integer.toBinaryString((int)((Math.random()*50)+1)))));
		}
		return path;
	}
	
	int randomWithRange(int min, int max) {
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
}
