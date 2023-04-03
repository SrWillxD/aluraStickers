import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
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
        var font = new Font("Impact", Font.BOLD, 65);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);


        //write a sentence on the new image
        String text = "";

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D rectangle2D =  fontMetrics.getStringBounds(text, graphics);

        int textWidth = (int) rectangle2D.getWidth();
        int textPositionX = (width - textWidth)/2;
        int textPositionY = newHeight-90;
        graphics.drawString(text, textPositionX, textPositionY);

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(text, font, fontRenderContext);

        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(textPositionX, textPositionY );
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(width * 0.004f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);


        //write the new image to a file
        ImageIO.write(newImage, "png", new File(fileName));
    }
}
