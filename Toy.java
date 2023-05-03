class Toy{
    Integer id;
    String name;
    Integer frequency;
    Integer count;

    public Toy( Integer id, String name, Integer frequency, Integer count){
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.count = count;
    }

    public Integer getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getFrequency(){
        return frequency;
    }   


    public void Freq(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("Toy name: %s; chance of prize: %d", name, frequency);
    }
}

