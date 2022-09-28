import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader.deconstruct("words1.txt");
        System.out.println("**************************");
        Session session = new Session();
        session.countFile("words1.txt");

        new UserWindow(new Session());
    }
}