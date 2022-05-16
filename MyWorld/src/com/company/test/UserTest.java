package com.company.test;

import com.company.model.Card;
import com.company.model.Order;
import com.company.model.User;
import com.company.repository.CardRepository;
import com.company.repository.UserRepository;
import com.company.service.CardService;
import com.company.service.OrderService;
import com.company.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class UserTest {

    public static void userTest() {
        //test user with local server H2 DB
        //fillDataBase();
        printUsers();
        getUserByEmail();
    }

//        //unitary tests
//        testCreateUserView();
//        testCreateUserController();
//
//        testChangePinView();
//        testChangePinController(usersTest);
//
//        testTransferController(usersTest);
//        testTransferView();
//
//        testDepositView();
//        //testLoan(users);
//        System.out.println("Tests USER ending... \n");

    public static void fillDataBase(){
        // let s create some orders
        LocalDate date1 = LocalDate.of(2022, 5, 15);
        Order newOrder1 = new Order("Cafe", 2.5, date1, "052022");
        LocalDate date2 = LocalDate.of(2022, 5, 5);
        Order newOrder2 = new Order("Pizza", 12.25, date2, "052022");
        LocalDate date3 = LocalDate.of(2022, 5, 12);
        Order newOrder3 = new Order("Books Java", 32.85, date3, "052022");
        LocalDate date4 = LocalDate.of(2022, 5, 3);
        Order newOrder4 = new Order("Meal", 10.15, date4, "052022");
        //let s persist on DB
        OrderService.create(newOrder1);
        OrderService.create(newOrder2);
        OrderService.create(newOrder3);
        OrderService.create(newOrder4);
        //let's create some cards
        Card cardCreated1 = CardService.createCard();
        Card cardCreated2 = CardService.createCard();
        Card cardCreated3 = CardService.createCard();
        Card cardCreated4 = CardService.createCard();
        Card cardCreated5 = new Card(12341234123412358L, 10000.00, "PayPal", 1234);
        //let s create a keyMonthDate in card #5
        cardCreated5.addDateKeys("052022");

        //add cardCreated5
        CardRepository.create(cardCreated5);
        //let's extract the card number from card
        long cardNumber1 = cardCreated1.getCardNumber();
        long cardNumber2 = cardCreated2.getCardNumber();
        long cardNumber3 = cardCreated3.getCardNumber();
        long cardNumber4 = cardCreated4.getCardNumber();
        long cardNumber5 = cardCreated5.getCardNumber();
        //just to work with them, no having a void arraylist
        User newUser1 = new User("Alex", "Pixel", 25);
        User newUser2 = new User("Thomas", "Edison", 35);
        User newUser3 = new User("Susan", "Lane", 46);
        User newUser4 = new User("Marta", "Gross", 86);
        User newUser5 = new User("Elon", "Musk", 56, "elon@musk.mars", "1234");
        //let s add cardNumber long to user, so one user > one card
        newUser1.addCardNumber(cardNumber1);
        newUser2.addCardNumber(cardNumber2);
        newUser3.addCardNumber(cardNumber3);
        newUser4.addCardNumber(cardNumber4);
        newUser5.addCardNumber(cardNumber5);
        //let s persist on DB
        UserService.create(newUser1);
        UserService.create(newUser2);
        UserService.create(newUser3);
        UserService.create(newUser4);
        UserService.create(newUser5);

    }

    public static void printUsers() {
        // let s see if there are users
        System.out.println("Test #printUsers");
        List<User> userList =  UserRepository.getAllUsers();
        System.out.println("Users:" + userList + "\n");
    }

    public static void getUserByEmail(){
        // let s see if user exists at DB by email
        System.out.println("Test #getUserByEmail");
        User userFound = UserService.getUserByEmail("APixel@helsinki.uni");
        System.out.println("userFound > APixel@helsinki.uni : " + userFound);
        // let s see if user doesn't exist at DB by email
        User userNotFound = UserService.getUserByEmail("EMusk@toronto.uni");
        System.out.println("userNotFound > EMusk@toronto.uni : " + userNotFound);
    }


//
//    public static void testCreateUserView() {
//        //test view so we need to send data as string
//        String fakeDataUser = "Bruce\n" + "Jones\n" + "12\n" + "88889999555533334\n" + "500.00\n" + "Visa\n";
//        Scanner fakeReader = new Scanner(fakeDataUser);
//
//        String status = IOView.createUser(fakeReader);
//        if (status.equals("created")) System.out.println("Test #testCreateUserView OK");
//        else System.out.println("Test #testCreateUserView FAIL");
//    }
//
//    public static void testCreateUserController() {
//        //to test and discover weather
//        // (1) user is created
//        // (2) user is saved in arraylist properly
//        // (3) get hashmap and unpack it
//        // (4) create response hashmap and works
//        HashMap<String, String> fakeDataUser = new HashMap();
//        fakeDataUser.put("operation", "createUser");
//        fakeDataUser.put("name", "Sonia");
//        fakeDataUser.put("surname", "Lopes");
//        fakeDataUser.put("age", "10");
//        fakeDataUser.put("cardNumber", "9999222244447777");
//        fakeDataUser.put("amount", "50.00");
//        fakeDataUser.put("cardType", "Visa");
//
//        HashMap<String, String> responseHashMap = UserController.createUser(fakeDataUser);
//
//        if (responseHashMap.get("status").equals("created")) System.out.println("Test #testCreateUserController OK");
//        else System.out.println("Test #testCreateUserController FAIL");
//    }
//
//    public static void testChangePinView() {
//        //test view so we need to send data as string
//        String fakeDataUser = "1234123412341234\n" + "2569\n";
//        Scanner fakeReader = new Scanner(fakeDataUser);
//
//        String status = IOView.changePin(fakeReader);
//        if (status.equals("pinUpdated")) System.out.println("Test #testChangePinView OK");
//        else System.out.println("Test #testChangePinView FAIL");
//    }
//
//    public static void testChangePinController(ArrayList<User> users) {
//        //test: check
//        HashMap<String, String> fakeDataUser = new HashMap<>();
//        //fill data hashmap object
//        fakeDataUser.put("operation", "changePin");
//        fakeDataUser.put("cardNumber", "1234123412341234");
//        fakeDataUser.put("newPin", "6589");
//
//        HashMap<String, String> responseHashMap = UserController.changePin(fakeDataUser);
//
//        if (responseHashMap.get("status").equals("pinUpdated")) System.out.println("Test #testChangePinController OK");
//        else System.out.println("Test #testChangePinController FAIL");
//
//    }
//
//    public static void testTransferController(ArrayList<User> users) {
//        //test: check 4 methods to make a transfer
//        int positionOrigin = UserService.isCardNumber(1234123412341234L, users);
//        int positionDestination = UserService.isCardNumber(4321432143214321L, users);
//
//        if (positionOrigin >= 0 && positionDestination >= 0) System.out.println("Test #testTransferCards OK");
//        else System.out.println("Test #testTransferCards FAIL");
//
//        boolean isMoney = UserService.isEnoughAmount(users, positionOrigin, 50.00);
//        if (isMoney) System.out.println("Test #testTransferIsMoney OK");
//        else System.out.println("Test #testTransferIsMoney FAIL");
//
//        UserService.makeTransfer(positionOrigin, positionDestination, 50.00, users);
//
//        double rightAmountAfterMakeTransferOrigin = users.get(positionOrigin).getCard().getAmount();
//        if (rightAmountAfterMakeTransferOrigin == 450.00) System.out.println("Test #testTransferMakeOrigin OK");
//        else System.out.println("Test #testTransferMakeOrigin FAIL");
//
//        double rightAmountAfterMakeTransferDestination = users.get(positionDestination).getCard().getAmount();
//        if (rightAmountAfterMakeTransferDestination == 1550.00)
//            System.out.println("Test #testTransferMakeDestination OK");
//        else System.out.println("Test #testTransferMakeDestination FAIL");
//
//    }
//
//    public static void testTransferView() {
//
//        String testInput = "1234123412341234\n" + "4321432143214321\n" + "50.00\n";
//        Scanner readerTest = new Scanner(testInput);
//        IOView.transfer(readerTest);
//
//        ArrayList<User> usersFromContorller = UserController.getFakeUsers();
//
//        double rightAmountAfterMakeTransferOrigin = 450.00;
//        double amountAfterMakeTransferOrigin = usersFromContorller.get(0).getCard().getAmount();
//        boolean isAmountOrigin = amountAfterMakeTransferOrigin == rightAmountAfterMakeTransferOrigin;
//        if (isAmountOrigin)
//            System.out.println("Test #testTransferMakeOrigin OK");
//        else System.out.println("Test #testTransferMakeOrigin FAIL");
//
//        double rightAmountAfterMakeTransferDestination = usersFromContorller.get(1).getCard().getAmount();
//        double amountAfterMakeTransferDestination = 1550.00;
//        boolean isAmountDestination = amountAfterMakeTransferDestination == rightAmountAfterMakeTransferDestination;
//        if (isAmountDestination)
//            if (isAmountDestination)
//                System.out.println("Test #testTransferMakeDestination OK");
//            else System.out.println("Test #testTransferMakeDestination FAIL");
//    }
//
//
//    public static void testDepositView() {
//        String testInput = "4444333322221111\n" + "100.00\n";
//        Scanner readerTest = new Scanner(testInput);
//        IOView.deposit(readerTest);
//
//        double rightAmountAfterMakeDeposit = 2000.00;
//        double amountAfterMakeDeposit = UserController.getFakeUsers().get(3).getCard().getAmount();
//        boolean isAmount = amountAfterMakeDeposit == rightAmountAfterMakeDeposit;
//        if (isAmount)
//            System.out.println("Test #testDeposit OK");
//        else System.out.println("Test #testDeposit FAIL");
//    }
//
//    public static void loan(ArrayList<User> users) {
//        //to-do
//    }

}
