package ca.mcmaster.se2aa4.mazerunner.Configuration;

public class ProgramGuide {
    public final String method;
    public final String test_path;
    public final String file_name;
    public final int maze_length;
    public final int maze_width;

    public ProgramGuide(String file_name, String test_path, String method, int maze_length, int maze_width) {
        this.method = method;
        this.test_path = test_path;
        this.file_name = file_name;
        this.maze_length = maze_length;
        this.maze_width = maze_width;
    }
}
