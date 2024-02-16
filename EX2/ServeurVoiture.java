package EX2;
import java.io.*;
import java.net.*;

public class ServeurVoiture {
    public static void main(String[] args) {
        int port = 12345; // Port sur lequel le serveur écoute
        
        try {
            // Création d'une socket serveur
            ServerSocket serverSocket = new ServerSocket(port);
            
            System.out.println("Serveur en attente de connexion...");
            
            // Accepter une connexion du client
            Socket clientSocket = serverSocket.accept();
            
            // Flux d'objets pour recevoir l'objet voiture du client
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            
            // Lecture de l'objet voiture envoyé par le client
            voiture car = (voiture) in.readObject();
            
            // Affichage des informations de la voiture
            System.out.println("Type de voiture: " + car.type);
            System.out.println("Modèle de voiture: " + car.model);
            System.out.println("Quantité de carburant: " + car.getCarburant() + " litres");
            System.out.println("Capacité de réservoir: " + car.getCapacite() + " litres");
            
            // Fermer les flux et la connexion
            in.close();
            clientSocket.close();
            serverSocket.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
