package Kurs1024kb;

public class Boots extends Product {

    private Integer size;
    private boolean isNaturalSkin;

    public Boots (Long id, String productName, Float price, Float weight, String color, Integer productCount, Integer size, boolean isNaturalSkin){
        super(id,productName,price,weight, color,productCount);
        this.size=size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }
}
