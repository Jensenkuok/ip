package jamal;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getTaskDisplay() {
        return "[T]" + super.getTaskDisplay();
    }
}
