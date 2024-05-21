import java.util.Objects;

public class Expert {
    private long priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expert expert = (Expert) o;
        return Objects.equals(priority, expert.priority);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(priority);
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Expert(Long priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "priority=" + priority +
                '}';
    }
}
