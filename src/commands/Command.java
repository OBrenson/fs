package commands;

import fs.Dir;

public interface Command {

    String getName();

    String execute(DirWrap wr, String name);
}
