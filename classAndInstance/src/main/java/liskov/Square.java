package liskov;

public class Square extends Rectangle {
    @Override
    public void setHeight(int height) {
        setSide(height);
    }
    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    public void setSide(int size) {
        super.setHeight(size);
        super.setWidth(size);
    }
}
