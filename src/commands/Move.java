package commands;

import fs.Dir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Move implements Command {

    public static final String NAME = "move";

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String execute(DirWrap wr, String name) {
        Dir dir = wr.getDir();
        String[] names = name.split(",");
        if(names.length != 2) {
            return "";
        }
        names[1]= names[1].replace("\\", "\\\\");
        if(new File(names[1]).isFile()) {
            try {
                new MakeDir().execute(wr, names[0]);
                dir.getNodes().get(dir.getNodes().size()-1).setContent(Files.readString(Path.of(names[1])));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
