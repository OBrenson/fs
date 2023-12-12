package commands;

import fs.Dir;

public class Find implements Command {

    public static final String NAME = "find";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap wr, String name) {
       return find(wr.getDir(), name);
    }

    public String find(Dir dir, String name) {
        if(dir.getName().equals(name)) {
            return new PWD().execute(new DirWrap(dir), "");
        }
        for(Dir d : dir.getNodes()) {
            String res = find(d, name);
            if(res != null) {
                return res;
            }
        }
        return null;
    }
}
