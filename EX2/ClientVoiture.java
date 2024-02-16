package EX2;
import java.io.*;
import java.net.*;

public class ClientVoiture {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse IP ou nom d'hôte du serveur
        int port = 12345; // Port sur lequel le serveur écoute
        
        try {
            // Création de l'objet voiture
            voiture car = new voiture("SUV", "Toyota");
            car.setCarburant(50); // Exemple: remplir la voiture avec 50 litres de carburant
            
            // Établir la connexion avec le serveur
            Socket socket = new Socket(host, port);
            
            // Flux d'objets pour envoyer l'objet voiture au serveur
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(car); // Envoi de l'objet voiture au serveur
            
            // Fermer la connexion
            out.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
