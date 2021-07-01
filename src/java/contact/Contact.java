package contact;

public class Contact {
    private String name;
    private String mobileNumber;


    public Contact() {
    }

    public Contact(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public static Contact createContact(String name, String mobileNumber) {
        return new Contact(name, mobileNumber);
    }

    public Contact createNewContact(String name, String mobileNumber) {
        return new Contact(name, mobileNumber);
    }
}
