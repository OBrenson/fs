package commands;

import fs.Dir;

public class Watch implements Command {

    public static final String NAME = "watch";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap wr, String name) {
        Dir dir = wr.getDir();
        for(Dir d : dir.getNodes()) {
            if (d.getName().equals(name) && d.getContent() != null) {
                return d.getContent();
            }
        }
        return "";
    }
}
