package commands;

import fs.Dir;

public class ListDir implements Command{

    public static final String NAME = "list";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap dir, String name) {
        StringBuilder sb = new StringBuilder();

        for(Dir d : dir.getDir().getNodes()) {
            sb.append(d.getName());
            sb.append(" ");
        }
        return sb.toString();
    }
}
