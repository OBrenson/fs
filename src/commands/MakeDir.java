package commands;

import fs.Dir;

public class MakeDir implements Command{

    public static final String NAME = "mkdir";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String execute(DirWrap dw, String name) {
        Dir dir = dw.getDir();
        for(Dir d: dir.getNodes()) {
            if(d.getName().equals(name)) {
                return "already exists";
            }
        }
        Dir nDir = new Dir(name, dir);
        dir.getNodes().add(nDir);
        return "";
    }
}
