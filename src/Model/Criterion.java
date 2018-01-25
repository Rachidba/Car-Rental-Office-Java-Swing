package Model;


/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:25 PM
 */
public interface Criterion<T> {
    public boolean isSatisfiedBy(T c);
}