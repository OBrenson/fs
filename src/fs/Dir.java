package fs;

import java.util.ArrayList;
import java.util.List;

public class Dir {
    private List<Dir> nodes;
    private Dir parent;
    private String name;

    private String content;

    public Dir(String name) {
        this.name = name;
        nodes = new ArrayList<>();
    }

    public Dir(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Dir(String name, Dir parent) {
        this.name = name;
        nodes = new ArrayList<>();
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Dir> getNodes() {
        return nodes;
    }

    public void setNodes(List<Dir> nodes) {
        this.nodes = nodes;
    }

    public Dir getParent() {
        return parent;
    }

    public void setParent(Dir parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
