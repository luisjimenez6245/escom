import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


public class Server implements iRemote {

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            iRemote stub = (iRemote) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("iRemote", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("No se ha podido conectar" +  e.getLocalizedMessage());
        }
        
    }
    @Override
    public String printMsg(String pregunta) throws RemoteException {
        String preguntas[] = { "COMO TE LLAMAS", "DONDE VIVES", "EN QUE ESCUELA ESTUDIAS", "EN QUE SEMESTRE VAS",
                "ERES REGULAR", "TIENES NOVIA", "CUAL ES TU PROMEDIO", "CHIVAS O AMERICA", "CUANDO ES TU CUMPLEAÑOS" };
        String respuestas[] = { "MI NOMBRE ES TAMAGOCHI", "EN LA COMPU", "EN ESCOM", "2DO SEMESTRE", "SI, SOY REGULAR",
                "NO, estoy solo :C", "9.9 COMO DEBE DE SER", "CHIVAS", "EL 31 DE AGOSTO" };
        for (int i = 0; i < 10; i++)
            if (preguntas[i].equals(pregunta))
                return respuestas[i];
        return "";
    }

}

interface iRemote extends Remote {
    String printMsg(String pregunta) throws RemoteException;
}