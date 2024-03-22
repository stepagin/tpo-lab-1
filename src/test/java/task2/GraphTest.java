package task2;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GraphTest {

    @Test
    public void testDFS() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        List<Integer> expectedSequence = Arrays.asList(2, 0, 1, 3);
        int startVertex = 2;

        List<Integer> actualSequence = g.dfs(startVertex);

        assertEquals(expectedSequence, actualSequence);
    }

    @Test
    public void testDFSSingleNodeGraph() {
        Graph g = new Graph();
        g.addEdge(0, 0);

        List<Integer> expectedSequenceSingleNode = List.of(0);
        int startVertexSingleNode = 0;

        List<Integer> actualSequenceSingleNode = g.dfs(startVertexSingleNode);

        assertEquals(expectedSequenceSingleNode, actualSequenceSingleNode);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -1, 0, 12, 100500})
    public void testDFSNoVerticesGraph(int start) {
        assertThrows(IllegalArgumentException.class, () -> {
            Graph g = new Graph();
            List<Integer> result = g.dfs(start);
        });
    }

    @Test
    public void testDFSCycleGraph() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        List<Integer> expectedSequenceCycle = Arrays.asList(0, 1, 2);
        int startVertexCycle = 0;

        List<Integer> actualSequenceCycle = g.dfs(startVertexCycle);

        assertEquals(expectedSequenceCycle, actualSequenceCycle);
    }

    @Test
    public void testDFSFullConnectedGraph() {
        Graph g = new Graph();
        // Создаем полносвязный граф с 10 вершинами
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    g.addEdge(i, j);
                }
            }
        }

        List<Integer> expectedSequenceFullConnected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int startVertexFullConnected = 0;

        List<Integer> actualSequenceFullConnected = g.dfs(startVertexFullConnected);

        assertEquals(expectedSequenceFullConnected, actualSequenceFullConnected);
    }
}
