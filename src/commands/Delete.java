package commands;

import fs.Dir;

public class Delete implements Command{
    public static final String NAME = "del";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap wr, String name) {
        int index = 0;
        boolean founded = false;
        for(Dir d : wr.getDir().getNodes()) {
            if(d.getName().equals(name)) {
                founded = true;
                break;
            }
            index++;
        }
        if(founded) {
            wr.getDir().getNodes().remove(index);
        }
        return "";
    }
}
