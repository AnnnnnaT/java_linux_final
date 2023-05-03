import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ToyMachine {

    public ArrayList<Toy> toys = new ArrayList<>();

    public Queue<Toy> prizes = new LinkedList<>();

    Integer startID = 0;
    

    public void addToy(String name, Integer frequency, Integer count){
        Toy toy = new Toy(startID++, name, frequency, count);
        for (int i = 0; i < count; i++) {
            toys.add(toy);
        }
        
    }

    @Override
    public String toString() {
        StringBuilder toysList = new StringBuilder();
        toysList.append("\nList of toys:\n");
        for (Toy toy: toys) {
            toysList.append(toy.getID()).append(". ").append(toy).append("\n");
        }
        return toysList.toString();
    }    

    public void toQueue() {
        if (toys.isEmpty()) {
            System.out.println("No toys");
            return;
        }

        ArrayList<Toy> toysFreq= new ArrayList<>();
        for (Toy toy : toys) {
            int frequency = toy.getFrequency();
            for (int i = 0; i < frequency; i++) {
                toysFreq.add(toy);
            }
        }

        Collections.shuffle(toysFreq);
        Toy toy = toysFreq.get(0);
        prizes.add(toy);
    }

    public void counter() {

        HashMap<String, Integer> counter = new HashMap<>();

        for (Toy toy : toys) {
            String name = toy.getName();
            int count = counter.getOrDefault(name, 0);
            counter.put(name, count + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public void play(String filePath){
        if (prizes.isEmpty()) {
            System.out.println("No prizes");
            return;
        }

        Toy prize = prizes.poll();

        try {    
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(prize.getName() + "\n");
            writer.close();
        }catch (IOException e) {
            System.out.println("Failed");
            return;
        }
        System.out.println("Congrats! You won " + prize.getName());
        toys.remove(prize);       
        }
    }

