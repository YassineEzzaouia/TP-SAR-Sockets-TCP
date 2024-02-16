import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketServeur {
    public static void main(String argv[]) {
        int port = 0;
        Scanner keyb = new Scanner(System.in);
        // Demande à l'utilisateur de saisir le port d'écoute
        System.out.print("Port d'écoute : ");
        try {
            // Lit le port d'écoute saisi par l'utilisateur
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // Affiche un message d'erreur si le paramètre n'est pas un entier
            System.err.println("Le paramètre n'est pas un entier.");
            System.err.println("Usage : java ServeurUDP port-serveur");
            System.exit(-1);
        }
        try {
            // Crée un nouveau ServerSocket pour écouter les connexions entrantes sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(port);
            // Attend une connexion entrante et accepte-la une fois qu'elle arrive
            Socket socket = serverSocket.accept();
            // Initialise les flux de sortie et d'entrée pour envoyer et recevoir des données
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Lit une chaîne envoyée par le client
            String chaine = (String) input.readObject();
            System.out.println(" recu : " + chaine);
            // Affiche l'adresse IP et le port du client
            System.out.println(" ca vient de : " + socket.getInetAddress() + ":" + socket.getPort());
            // Envoie une réponse au client
            output.writeObject(new String("bien recu"));
        } catch (Exception e) {
            // Affiche un message d'erreur en cas d'exception
            System.err.println("Erreur : " + e);
        }
    }
}
