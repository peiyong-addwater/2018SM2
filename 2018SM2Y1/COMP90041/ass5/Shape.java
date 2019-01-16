public abstract class Shape {

    public abstract Double perimeter();
    public abstract Double area();

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}