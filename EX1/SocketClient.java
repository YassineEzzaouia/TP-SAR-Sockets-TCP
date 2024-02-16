import java.io.*;
import java.net.*;
import java.util.Scanner;

class SocketClient {
    public static void main(String argv[]) {
        int port = 0;
        String host = "";
        Scanner keyb = new Scanner(System.in);
        // Demande à l'utilisateur de saisir le nom du serveur
        System.out.print("Nom du serveur : ");
        host = keyb.next();
        // Demande à l'utilisateur de saisir le port du serveur
        System.out.print("Port du serveur : ");
        try {
            // Lit le port du serveur saisi par l'utilisateur
            port = keyb.nextInt();
        } catch (NumberFormatException e) {
            // Affiche un message d'erreur si le second paramètre n'est pas un entier
            System.err.println("Le second paramètre n'est pas un entier.");
            System.exit(-1);
        }
        try {
            // Résout l'adresse IP du serveur à partir de son nom
            InetAddress adr = InetAddress.getByName(host);
            // Crée un nouveau Socket et se connecte au serveur spécifié
            Socket socket = new Socket(adr, port);
            // Initialise les flux de sortie et d'entrée pour envoyer et recevoir des données
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            // Envoie une chaîne au serveur
            output.writeObject(new String("ma première socket"));
            // Lit une réponse du serveur
            String chaine = (String) input.readObject();
            System.out.println(" recu du serveur : " + chaine);
        } catch (Exception e) {
            // Affiche un message d'erreur en cas d'exception
            System.err.println("Erreur : " + e);
        }
    }
}
