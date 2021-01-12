public class Receipt {
    public int ID;

    public int CustomerID;

    public double Total;

    public double ChangeOwed;

    public String PaymentMethod;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setChangeOwed(double changeOwed) {
        ChangeOwed = changeOwed;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getChangeOwed() {
        return ChangeOwed;
    }

    public double getTotal() {
        return Total;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public int getID() {
        return ID;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void GenerateReceipt() {
    }
}
