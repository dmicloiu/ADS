import java.util.ArrayList;
import java.util.List;

public class Vertex {

    List<Vertex> outgoingEdges;

    int id;

    public Vertex(int id) {
        this.outgoingEdges = new ArrayList<>();
        this.id = id;
    }

    public List<Vertex> getOutgoingEdges() {
        return outgoingEdges;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }

    @Override
    public int hashCode() {
        return id;
    }

}
