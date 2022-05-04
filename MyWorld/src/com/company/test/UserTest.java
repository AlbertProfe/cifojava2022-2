package com.company.test;

public class UserTest {

    public static void userTest() {
//        //array list users to test
//        ArrayList<User> usersTest = new ArrayList<>();
//        createFakeUsers(usersTest);
//        printUsers(usersTest);
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
    }

//    public static void createFakeUsers(ArrayList<User> usersTest) {
//
//        User newUser1 = new User("Alex", "Pixel", 25, new Card(1234123412341234L, 500.00, "Visa"));
//        User newUser2 = new User("Thomas", "Edison", 35, new Card(4321432143214321L, 1500.00, "Master Card"));
//        User newUser3 = new User("Susan", "Lane", 46, new Card(1111222233334444L, 2500.00, "American Express"));
//        User newUser4 = new User("Marta", "Gross", 86, new Card(4444333322221111L, 1900.00, "American Express"));
//        usersTest.add(newUser1);
//        usersTest.add(newUser2);
//        usersTest.add(newUser3);
//        usersTest.add(newUser4);
//
//        if (usersTest.size() == 4) System.out.println("Test #createFakeUsers OK");
//        else System.out.println("Test #createFakeUsers FAIL");
//    }
//
//    public static void printUsers(ArrayList<User> users) {
//        System.out.println("Users:" + users + "\n");
//    }
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
