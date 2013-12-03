
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
	public BigDecimal pi(int anzahl_nachkommastellen);
}