package graph;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gbrooks
 */
public class GraphTest {

    private GNode nodeA;
    private GNode nodeB;
    private GNode nodeC;
    private GNode nodeD;
    private GNode nodeE;
    private GNode nodeF;
    private GNode nodeG;
    private GNode nodeH;
    private GNode nodeI;
    private GNode nodeJ;
    
    public GraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nodeE = new SimpleNode("E");
        nodeF = new SimpleNode("F");
        GNode[] nodesEF = { nodeE, nodeF };
        nodeB = new SimpleNode("B", nodesEF);
        nodeG = new SimpleNode("G");
        nodeH = new SimpleNode("H");
        nodeI = new SimpleNode("I");
        GNode[] nodesGHI = { nodeG, nodeH, nodeI };
        nodeC = new SimpleNode("C", nodesGHI);
        nodeJ = new SimpleNode("J");
        GNode[] nodesJ = { nodeJ };
        nodeD = new SimpleNode("D", nodesJ);
        GNode[] nodesBCD = { nodeB, nodeC, nodeD };
        nodeA = new SimpleNode("A", nodesBCD);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of paths method, of class Graph.
     */
    @Test
    public void testPaths() {
        System.out.println("paths");

        ArrayList expResult = new ArrayList();
        expResult.add(buildPath(nodeA, nodeB, nodeE));
        expResult.add(buildPath(nodeA, nodeB, nodeF));
        expResult.add(buildPath(nodeA, nodeC, nodeG));
        expResult.add(buildPath(nodeA, nodeC, nodeH));
        expResult.add(buildPath(nodeA, nodeC, nodeI));
        expResult.add(buildPath(nodeA, nodeD, nodeJ));

        ArrayList result = Graph.paths(nodeA);

        assertEquals(expResult.size(), result.size());
        for (int i = 0; i != result.size(); ++i) {
            ArrayList expPath = (ArrayList)expResult.get(i);
            ArrayList path = (ArrayList)result.get(i);
            System.out.print("expect ");
            printPath(expPath);
            System.out.print(", got ");
            printPath(path);
            System.out.println();
            assertEquals(expPath.size(), path.size());
            for (int j = 0; j != path.size(); ++j) {
                assertEquals(expPath.get(j), path.get(j));
            }
        }
    }
    private void printPath(ArrayList path) {
        System.out.print("( ");
        for (Object node: path) {
            GNode gnode = (GNode)node;
            System.out.print(gnode.getName());
            System.out.print(" ");
        }
        System.out.print(")");
    }

    private ArrayList buildPath(GNode n1, GNode n2, GNode n3) {
        ArrayList path = new ArrayList();
        path.add(n1);
        path.add(n2);
        path.add(n3);
        return path;
    }

    /**
     * Test of walkGraph method, of class Graph.
     */
    @Test
    public void testWalkGraph() {
        System.out.println("walkGraph");

        java.util.Set expResult = new java.util.HashSet();
        expResult.add(nodeA);
        expResult.add(nodeB);
        expResult.add(nodeC);
        expResult.add(nodeD);
        expResult.add(nodeE);
        expResult.add(nodeF);
        expResult.add(nodeG);
        expResult.add(nodeH);
        expResult.add(nodeI);
        expResult.add(nodeJ);

        ArrayList list = Graph.walkGraph(nodeA);
        java.util.Set result = new java.util.HashSet();
        result.addAll(list);
        
        assertEquals(expResult, result);
    }
}