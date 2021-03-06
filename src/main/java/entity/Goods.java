package entity;

import javax.persistence.*;

/**
 * Created by Олег on 12.02.2017.
 */
@Entity
@Table(name = "GOODS")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCTNAME")
    private String productName;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "AMOUNT")
    private Integer amount;



    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Goods() {
    }

    public Goods(String productName, Double price, Integer amount) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Товар :  " + productName + ".  Цена = " + price + ". Количество  = " + amount;
    }
}
