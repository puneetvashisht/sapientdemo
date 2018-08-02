package com.demo_03.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams  {
    private Collection< Task > tasks;
    
    public Streams() {
    	final Collection< Task > tasks = Arrays.asList(
    		    new Task( Status.OPEN, 15 ),
    		    new Task( Status.CLOSED, 10 ),
    		    new Task( Status.OPEN, 25 ) 
    		);
    	this.tasks = tasks;
	}
    
    public double getTotalPointsOfAllTasks(){
    	final double totalPoints = tasks
    	   .stream()
    	   .parallel()
    	   .map( task -> task.getPoints() ) // or map( Task::getPoints ) 
    	   .reduce( 0, Integer::sum );
    	    
    	return totalPoints;
    }
    
    public long getTotalPointsOfOpenTasks(){
    	// Calculate total points of all active tasks using sum()
    	final long totalPoints = tasks
    	    .stream()
    	    .filter( task -> task.getStatus() == Status.OPEN )
    	    .mapToInt( Task::getPoints )
    	    .sum();
    	
    	return totalPoints;
    }

    public long getTotalPointsOfClosedTasks(){
    	// Calculate total points of all active tasks using sum()
    	final long totalPoints = tasks
    	    .stream()
    	    .filter( task -> task.getStatus() == Status.CLOSED )
    	    .mapToInt( Task::getPoints )
    	    .sum();
    	
    	return totalPoints;
    }

    public Map<Status, List<Task>> groupTasksByStatus(){
    	// Group tasks by their status
    	final Map< Status, List< Task > > map = tasks
    	    .stream()
    	    .collect( Collectors.groupingBy( Task::getStatus ));
    	
    	return map;
    }
    
    public int getNumberOfOpenTasks(){
    	final int result = this.tasks
    	    .stream()
    	    .filter( task -> task.getStatus() == Status.OPEN )
    	    .mapToInt( (task)-> 1 )
    	    .sum();
    	
    	return result;
    }
    
    public int getNumberOfClosedTasks(){
    	Map<Status, List<Task>> tasksByStatus = groupTasksByStatus();
    	List<Task> list = tasksByStatus.get(Status.CLOSED);
    	return list.size();
    }
    
    public Collection<String> getOverallPercentOfEachTask(){
    	// Calculate the weight of each tasks (as percent of total points) 
    	final Collection< String > result = tasks
    	    .stream()                                        // Stream< String >
    	    .mapToInt( Task::getPoints )                     // IntStream
    	    .asLongStream()                                  // LongStream
    	    .mapToDouble( points -> points / getTotalPointsOfAllTasks() )   // DoubleStream
    	    .boxed()                                         // Stream< Double >
    	    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
    	    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
    	    .collect( Collectors.toList() );                 // List< String > 
    	        
    	return result;
    }
    
    public static void main(String[] args) {
    	Streams streams = new Streams();
		System.out.println("Total Points of all tasks: "+streams.getTotalPointsOfAllTasks());
		System.out.println("Total points of open tasks: "+streams.getTotalPointsOfOpenTasks());
		System.out.println("Total points of closed tasks: "+streams.getTotalPointsOfClosedTasks());
		System.out.println("Grouped tasks: "+streams.groupTasksByStatus());
		System.out.println("Number of Open tasks: "+streams.getNumberOfOpenTasks());
		System.out.println("Number of Closed tasks: "+streams.getNumberOfClosedTasks());
		System.out.println("Percentage of each task: "+streams.getOverallPercentOfEachTask());
	}
    
}