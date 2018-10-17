package notepad;

public class Pet extends Record{

    private String name;
    private String birthday;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + getId() + ", " +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean hasSubstring(String str) {
        return name.contains(str)
                || birthday.contains(str);
    }

    @Override
    public void askQuestions() {
        System.out.println("Enter pet name:");
        name = Main.askString();
        System.out.println("Enter birthday:");
        birthday = Main.askString();

    }
}
