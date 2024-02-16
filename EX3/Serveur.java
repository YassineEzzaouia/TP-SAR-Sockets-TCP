package EX3;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        int port = 12345; // Port sur lequel le serveur écoute
        
        try {
            // Création d'une socket serveur
            ServerSocket serverSocket = new ServerSocket(port);
            
            System.out.println("Serveur en attente de connexion...");
            
            while (true) {
                // Accepter une connexion du client
                Socket clientSocket = serverSocket.accept();
                
                // Flux pour lire les données envoyées par le client
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                // Flux pour envoyer des données au client
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                
                // Lecture de l'âge et du nom de la personne envoyés par le client
                int age = in.readInt();
                String nom = in.readUTF();
                
                // Génération d'un identificateur de client (ici simplement un nombre aléatoire)
                int identificateurClient = (int) (Math.random() * 1000);
                
                // Affichage des informations reçues du client
                System.out.println("Client: " + nom + ", Age: " + age);
                
                // Envoi de l'identificateur de client au client
                out.writeInt(identificateurClient);
                
                // Fermeture des flux et de la connexion avec le client
                in.close();
                out.close();
                clientSocket.close();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
