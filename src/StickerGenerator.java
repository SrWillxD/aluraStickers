import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGenerator {
    public void make(InputStream inputStream, String fileName) throws Exception{
        //read the image
        BufferedImage originalImage = ImageIO.read(inputStream);


        //create a new image in memory with transparency and new size
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height+200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);


        //copy the original image to the new image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0,0, null);


        //configure font
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);


        //write a sentence on the new image
        graphics.drawString("TOPZERA", 400, newHeight-100);


        //write the new image to a file
        ImageIO.write(newImage, "png", new File(fileName));
    }
}
