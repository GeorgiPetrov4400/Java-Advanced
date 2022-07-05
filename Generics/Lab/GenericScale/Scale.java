package GenericsLab.GenericScale;

public class Scale<T extends Comparable<T>> {
    private T leftElement;
    private T rightElement;

    public Scale(T leftElement, T rightElement) {
        this.leftElement = leftElement;
        this.rightElement = rightElement;
    }

    public T getHeavier() {
        if (leftElement.compareTo(rightElement) > 0) {
            return leftElement;
        } else if (leftElement.compareTo(rightElement) < 0) {
            return rightElement;
        }
        return null;
    }
}
