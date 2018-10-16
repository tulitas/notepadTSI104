package notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
//hashmap, treemap, linkmap pozvoljaet sortirovat`
public class Main {
    //12 konstanta dati, metod po date nize
    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public final static String TIME_FORMAT = "mm.HH";
    public final static DateTimeFormatter TIME_FORMATTER
            = DateTimeFormatter.ofPattern(TIME_FORMAT);


    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Record> recordList = new LinkedHashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command ('help' for help):");
            String cmd = scanner.next();
            switch (cmd) {
                case "createperson":
                case "cp":
                    createPerson();
                    break;
                case "createnote":
                case "cn":
                    createNote();
                    break;
                case "createreminder":
                case "cr":
                    createReminder();
                    break;
                case "createalarm":
                case "ca":
                    createAlarm();
                    break;
                case "list":
                    printList();
                    break;
                case "remove":
                    removeById();
                    break;
                case "find":
                    find();
                    break;
                case "help":
                    showHelp();
                    break;
                case "showId":
                case "id":
                    showId();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("It isn't a command");
            }
        }
    }

    private static void createAlarm() {


        var alarm = new Alarm();
        addRecord(alarm);
    }


    private static void createReminder() {


        var reminder = new Reminder();
        addRecord(reminder);
    }

    private static void find() {
        System.out.println("Find what?");
        String str = askString();
        for (Record r : recordList.values()) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }

    private static void createNote() {

        Note note = new Note();
        addRecord(note);
    }

    private static void addRecord(Record r) {
        r.askQuestions();
        recordList.put(r.getId(), r);
        System.out.println(r);
    }

    private static void showHelp() {
        System.out.println("createPerson - bla bla bla bla");
        System.out.println("remove - bla bla bla bla");
        System.out.println("bla bla bla bla");
        System.out.println("bla bla bla bla");
    }

    private static void removeById() {
        System.out.println("Enter ID to remove:");
        int id = askInt();
        recordList.remove(id);
    }
private static void showId(){
        System.out.println("Enter ID to show:");
        int id = askInt();
        Record record = recordList.get(id);
        System.out.println(record);

}
    private static int askInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // skip wrong input
                System.out.println("It isn't a number");
            }
        }
    }


    //    private static void removeById() {
//        System.out.println("Enter ID to remove:");
//        int id = scanner.nextInt();
//        for (Person p : recordList) {
//            if (id == p.getId()) {
//                recordList.remove(p); // not very optimal
//                break;
//            }
//        }
//    }
    private static void printList() {
        for (Record p : recordList.values()) {
            System.out.println(p);
        }
    }

    public static void createPerson() {


        Person person = new Person();
        addRecord(person);
    }

    public static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {

            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    String str = String.join(" ", result);
                    return str.substring(1, str.length() - 1);
                }
                word = scanner.next();
            } while (true);

        } else {
            return word;
        }

    }

    //  Simple phone validation
    private static String askPhone_SIMPLE() {
        while (true) {
            String phone = askString();
            if (phone.length() >= 5) {
                return phone; // valid
            } else {
                System.out.println("Phone number is too short (min 5 digits)");
            }
        }
    }

    // More advanced phone validation Ļ(but still should be treated as an example)
    private static String askPhone() {
        while (true) {
            String phone = askString();
            // checking if there any characters expect digits, spaces, pluses and dashes
            if (phone.chars().anyMatch(c -> !Character.isDigit(c) && c != ' ' && c != '+' && c != '-')) {
                System.out.println("Only digits, spaces, plus and dash are allowed!");
                continue;
            }

            // checking how many digits in the entered number (excluding spaces and other non-digits)
            if (phone.chars().filter(Character::isDigit).count() < 5) {
                System.out.println("At least 5 digits in phone number");
                continue;
            }

            // validation passed
            return phone;
        }
    }
    public static LocalDate askDate(){
        String d = askString();
        LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
        return date;
    }
    public static LocalTime askTime() {
        String t = askString();
        LocalTime time = LocalTime.parse(t, TIME_FORMATTER);
        return time;
    }
}
