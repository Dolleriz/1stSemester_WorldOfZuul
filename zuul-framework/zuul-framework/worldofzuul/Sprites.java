package worldofzuul;


import javafx.scene.image.Image;

//We made alot of changes to this class. We argued about deleting it, however kept it for easier readability.
//Our first idea was to have a moveable sprite using keyboardInputs, but moved from that idea due to complexity.
//So now it just sets an image and makes us able to change the size and getters and setters.
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