package commands;

import fs.Dir;

public class ChangeDir implements Command{
    public static final String NAME = "cd";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String execute(DirWrap dw, String name) {
        if("/..".equals(name)) {
            if(dw.getDir().getParent() != null) {
                dw.setDir(dw.getDir().getParent());
            }
            return "";
        }
        Dir dir = dw.getDir();
        for(Dir d : dir.getNodes()) {
            if(d.getName().equals(name)) {
                if(d.getContent() == null) {
                    dw.setDir(d);
                    break;
                }
            }
        }
        return "";
    }
}
