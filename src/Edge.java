public class Edge extends GraphObject{
    public String name;
    private int weight;

    public Edge(String name, String name1, int weight) {
        super(name);
        this.name = name1;
        this.weight = weight;
    }

    public Edge(String edgeName) {
        super();
    }

    public boolean equals(Edge other){
        return this.getName().equals(other.getName());
    }
}
