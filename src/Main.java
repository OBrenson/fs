import commands.*;
import fs.Dir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        DirWrap dir = new DirWrap(testDirs());

        Map<String, Command> commandMap = createCommands();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String in = null;

        while (!"exit".equals(in)) {
            in = reader.readLine();
            in = in + " end";
            in = in.replaceAll("\\s{2,}", " ");
            String[] command = in.split(" ");
            Command c = commandMap.get(command[0]);
            if(c != null) {
                String res = c.execute(dir, command[1]);
                System.out.println(res);
            } else {
                if(!"exit".equals(in)) {
                    System.out.println("unknown command");
                }
            }
        }
    }

    private static Map<String, Command> createCommands() {
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put(ChangeDir.NAME, new ChangeDir());
        commandMap.put(MakeDir.NAME, new MakeDir());
        commandMap.put(ListDir.NAME, new ListDir());
        commandMap.put(PWD.NAME, new PWD());
        commandMap.put(Find.NAME, new Find());
        commandMap.put(Delete.NAME, new Delete());
        commandMap.put(Move.NAME, new Move());
        commandMap.put(Watch.NAME, new Watch());
        return commandMap;
    }

    private static Dir testDirs(){
        Dir dir = new Dir("root");
        DirWrap dw = new DirWrap(dir);
        Command mk = new MakeDir();
        mk.execute(dw, "a");
        mk.execute(dw, "b");
        mk.execute(dw, "c");
        dw.setDir(dir.getNodes().get(0));
        mk.execute(dw, "d");
        dw.setDir(dir.getNodes().get(2));
        mk.execute(dw, "e");
        return dir;
    }
}
