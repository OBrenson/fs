package commands;

import fs.Dir;

public class PWD implements Command{

    public static final String NAME = "pwd";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap wr, String name) {
        StringBuilder sb = new StringBuilder();
        Dir node = wr.getDir();
        while (node != null) {
            sb.insert(0, node.getName());
            sb.insert(0, "/");
            node = node.getParent();
        }
        return sb.toString();
    }
}
