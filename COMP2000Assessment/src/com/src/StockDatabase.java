public class StockDatabase {
    public String[] ProductID={"","",""};


    public String[] ProductRemaining={"","",""};

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductID(String productID, int Num) {
        ProductID[Num] = productID;
    }

    public void setProductRemaining(String productRemaining, int Num) {
        ProductRemaining[Num] = productRemaining;
    }

    public String[] getProductID() {
        return ProductID;
    }

    public String[] getProductRemaining() {
        return ProductRemaining;
    }

    public Product product;


    public void RemoveProduct() {
    }


    public void AddProduct(String[] productID, String[] productAmount) {
        ProductID= productID;
        ProductRemaining= productAmount;
    }

    public void EditProduct() {
    }


    public void UpdateStockNumber() {
    }
}
