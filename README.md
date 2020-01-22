# Pathfinding Genetic Algorithm
This is a path finding algorithm that uses evolutionary programing techniques based off of genetics.  

The goal is to find the best path from the bottom right corner to the top right
corner while obstacles (the red squares) are randomly generated in the way.

### Environment and obstacles
Examples of randomly generated obstacles:    
![1](https://i.imgur.com/rtdHwzd.png)

![2](https://i.imgur.com/CjrU60f.png)

![3](https://i.imgur.com/AJ5BaFq.png)

### Genetic Algorithm
Each grey square is an 'individual' in its generation. They start off with a random sequence of path vectors.  

Their fitness value (the parameter that decides if they get to reproduce) is the inverse distance from the goal.  

Each individual in the next generation is created using a combination of the vectors from two individuals from the previous generation.  


### Example:
Generation 0  
![0](https://media.giphy.com/media/QVOeaDxvITHJPPV7cl/giphy.gif)  
Final Generation
![Final](https://media.giphy.com/media/XExkm3vK8pDJgjOlcZ/giphy.gif)  
