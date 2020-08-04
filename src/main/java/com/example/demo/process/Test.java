package com.example.demo.process;

import com.example.demo.domain.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class Test {

    @Value("${file.path}")
    private String filePath;

    @EventListener(ApplicationReadyEvent.class)
    public void startProcessing() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String nodeNumber = reader.readLine();
        int node = Integer.decode(nodeNumber);
        Node[] data = new Node[node];
        for (int i = 0; i < node; i++) {
            data[i] = new Node(i);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");
            int from = Integer.decode(split[0]);
            int to = Integer.decode(split[1]);
            data[from].addNode(data[to]);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < node; i++) {
            if (!data[i].isInbound()) {
                depthFirstSearch(data[i], new LinkedList<>());
            }
        }
    }

    public void depthFirstSearch(Node node, List<Integer> list) {
        if (node.getAdjacentNodes() == null) {
            for (Integer value : list) {
                System.out.print(value + "-");
            }
            System.out.println(node.getVlaue());
        } else {
            list.add(node.getVlaue());
            for (Node adjacentNode : node.getAdjacentNodes()) {
                depthFirstSearch(adjacentNode, list);
            }
            list.remove((Object) node.getVlaue());
        }
    }

}