
public class Main{
public static void main(String[] args) {
    ToyMachine prizes = new ToyMachine();
    prizes.addToy("Bear", 10, 10);
    prizes.addToy( "Barby", 20, 5);
    prizes.addToy("Cat", 45, 20);
    prizes.addToy("Ball", 60, 30);

    prizes.counter();  
    System.out.println();

    for (int i = 0; i < 10; i++) {
        prizes.toQueue();
        prizes.play("wonToys.txt");
        prizes.counter(); 
    }
}
}