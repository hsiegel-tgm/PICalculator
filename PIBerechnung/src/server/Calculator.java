package server;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public interface Calculator extends java.rmi.Remote {
	public BigDecimal pi(int anzahl_nachkommastellen) throws RemoteException;
}
