package worldofzuul;


import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprites{
        private Image image;

        public Sprites()
        {

        }

        public void setImage(Image i)
        {
            image = i;
        }

        public void setImage(String filename)
        {
            Image i = new Image(filename,25,25,true,false);
            setImage(i);

        }
    public Image getImage() {
        return image;
    }
}