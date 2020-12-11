package worldofzuul;

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