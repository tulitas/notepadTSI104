package notepad;

public class Person extends Record {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String hairColor;

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", hairColor='" + hairColor + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return name.contains(str)
                || surname.contains(str)
                || phone.contains(str)
                || email.contains(str)
                || hairColor.contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter name:");
        name = Main.askString();

        System.out.println("Enter surname:");
        surname = Main.askString();

        System.out.println("Enter phone:");
        phone = Main.askString();

        System.out.println("Enter email:");
        email = Main.askString();

        System.out.println("Hair color:");
        email = Main.askString();
    }
}
