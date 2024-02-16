package EX3;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // Adresse IP ou nom d'hôte du serveur
        int port = 12345; // Port sur lequel le serveur écoute
        
        try {
            // Création de la connexion avec le serveur
            Socket socket = new Socket(host, port);
            
            // Flux pour envoyer des données au serveur
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            // Flux pour lire les données envoyées par le serveur
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            // Données de la personne à envoyer au serveur
            int age = 30;
            String nom = "John Doe";
            
            // Envoi de l'âge et du nom de la personne au serveur
            out.writeInt(age);
            out.writeUTF(nom);
            
            // Lecture de l'identificateur de client renvoyé par le serveur
            int identificateurClient = in.readInt();
            
            // Affichage de l'identificateur de client
            System.out.println("Identificateur de client reçu: " + identificateurClient);
            
            // Fermeture des flux et de la connexion avec le serveur
            out.close();
            in.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

