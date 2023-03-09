import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MyGraph {
    private int numVertices;
    private int numEdges;
    private HashMap<Vertex, ArrayList<GraphPairing>> graph;

    public MyGraph(){
        numEdges = 0;
        numVertices = 0;
        graph = new HashMap<>();
    }

    public int numVertices(){
        return numVertices;
    }

    public int numEdges(){
        return numEdges;
    }

    public void insertVertex(String name){
        Vertex temp = new Vertex(name);
        //assume for now the given name does not exist in the map
        graph.put(temp, null);
        numVertices++;
    }

    public void print(){
       Set<Vertex> vertexList = graph.keySet();

       for (Vertex v: vertexList){
           System.out.print(v + ": ");
           System.out.println(graph.get(v));
       }
    }

    private Vertex getVertexFromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for(Vertex v: vertices){
            if(v.getName().equals(s)){
                return v;
            }
        }
        return null;
    }

    public String opposite(String vertex, String edge){
        Vertex v = getVertexFromString(vertex);
        Edge e = getEdgeFromString(edge);

        ArrayList<GraphPairing> gps = graph.get(v);
        if(gps==null)
            return null;
        return null;
    }

    public String[] endVertices(String edge){
        String[] vertices = new String[2];
        Edge e = getEdgeFromString(edge);
        Vertex v1;
        Vertex v2;
        Set<Vertex> vertexList = graph.keySet();
        for (Vertex v: vertexList){
            ArrayList<GraphPairing> gps = graph.get(v);
            for (GraphPairing gp:gps){
                if(gp.getE()==e){
                    v1=v;
                    v2=gp.getV();
                    vertices[0]=v1.getName();
                    vertices[1]=v2.getName();

                }
            }
        }
        return vertices;
    }

    public String getEdge(String vertex1, String vertex2){
        Vertex v1= getVertexFromString(vertex1);
        Vertex v2= getVertexFromString(vertex2);

        ArrayList<GraphPairing> gps= graph.get(v1);
        for (GraphPairing gp:gps){
            if (gp.getV() == v2){
                return gp.getE().getName();
            }
        }
        return null;
    }

    private Edge getEdgeFromString(String s){
        Set<Vertex> vertices = graph.keySet();
        for(Vertex v: vertices){
            ArrayList<GraphPairing> gps= graph.get(v);
            if(gps != null)
                for (GraphPairing g:gps){
                   Edge e = g.getE();
                   if(e.getName().equals(s)){
                       return e;
                   }
                }
        }
        return null;
    }

    public void insertEdge(String v1, String v2, String edgeName){
        Set<Vertex> vertices = graph.keySet();
        Edge edge = new Edge(edgeName);
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2 = new Vertex(v2);
        for(Vertex v: vertices){
            if(v.compareTo(new Vertex(v1))==0){
                vertex1 = v;
                break;
            }
            if(v.compareTo(new Vertex(v2))==0){
                vertex2 = v;
                break;
            }
        }

        System.out.println("Contains v1: "+ graph.containsKey(vertex1));
        System.out.println("Contains v2: "+ graph.containsKey(vertex2));

        ArrayList<GraphPairing> v1EdgeList = graph.get(vertex1);
        if(v1EdgeList==null){
            graph.put(vertex1, new ArrayList<>());
        }
        graph.get(vertex1).add(new GraphPairing(vertex1,edge));

        ArrayList<GraphPairing> v2EdgeList = graph.get(vertex2);
        if(v2EdgeList==null){
            graph.put(vertex2, new ArrayList<>());
        }
        graph.get(vertex2).add(new GraphPairing(vertex2,edge));

        numEdges++;
    }
    public Set<Vertex> vertices(){
        return graph.keySet();
    }

}
