import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics2D;
public class StickerGenerator {
    public void make()throws Exception{
        //read the image
        BufferedImage originalImage = ImageIO.read(new File("resource/img/movie.jpg"));


        //create a new image in memory with transparency and new size
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height+200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        //copy the original image to the new image
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0,0, null);
        //write a sentence on the new image


        //write the new image to a file
        ImageIO.write(newImage, "png", new File("output/sticker.png"));
    }
    public static void main(String[] args)throws Exception{
        var maker = new StickerGenerator();
        maker.make();
    }
}
