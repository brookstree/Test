package graph;
import java.util.*;

/**
 * @author gbrooks
 */
public class Graph {

    public static java.util.ArrayList walkGraph(GNode node) {
        Set allNodes = new HashSet();
        collectNodes(allNodes, node);
        ArrayList list = new ArrayList();
        list.addAll(allNodes);
        return list;
    }

    private static void collectNodes(Set nodes, GNode node) {
        nodes.add(node);
        for (GNode child: node.getChildren())
            collectNodes(nodes, child);
    }

    public static java.util.ArrayList paths(GNode node) {
        ArrayList allPaths = new ArrayList();
        ArrayList curPath = new ArrayList();
        collectPaths(allPaths, curPath, node);
        return allPaths;
    }
    
    private static void collectPaths(ArrayList paths, ArrayList curPath, GNode node) {
        curPath.add(node);
        if (node.getChildren().length == 0) {
            // when at terminal node, we collect a full path
            paths.add(new ArrayList(curPath));
        } else {
            // collect paths of children
            for (GNode child: node.getChildren())
                collectPaths(paths, curPath, child);
        }
        curPath.remove(curPath.size()-1);
    }

}
