package commands;

import fs.Dir;

public class DirWrap {

    private Dir dir;

    public DirWrap(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
