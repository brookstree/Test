package graph;

/**
 *
 * @author gbrooks
 */
public class SimpleNode implements GNode {
    private String name;
    private GNode[] children;

    SimpleNode(String myName) {
        name = myName;
        children = new GNode[0];
    }
    
    SimpleNode(String myName, GNode[] myChildren) {
        name = myName;
        children = myChildren;
    }

    public String getName() {
        return name;
    }

    public GNode[] getChildren() {
        return children;
    }

}
