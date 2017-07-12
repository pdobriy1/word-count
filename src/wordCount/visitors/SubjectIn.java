package wordCount.visitors;

import java.util.Observer;

public interface SubjectIn {
	public void registerObserver(ObserverIn o);
	public void removeObserver(ObserverIn o);
	public void notifyObserver(int updateValueIn);
}
