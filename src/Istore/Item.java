package studentmanagementsystem;
import java.math.BigDecimal;

public class Item {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Integer inventoryId;
    private String storeName;
    private String imagePath;


    public Item(Integer id, String name, BigDecimal price, Integer stock, String description, Integer inventoryId, String storeName, String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.inventoryId = inventoryId;
        this.storeName = storeName;
        this.imagePath = imagePath;
    }

    public Item(Integer id, String name, BigDecimal price, Integer stock, String description, Integer inventoryId, String storeName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.inventoryId = inventoryId;
        this.storeName = storeName;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getStoreName() {
        return storeName;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getImagePath() {
        return imagePath;
    }


    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
