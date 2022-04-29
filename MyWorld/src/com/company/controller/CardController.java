package com.company.controller;

public class CardController {

//    public static HashMap<String, String> changePin(HashMap<String, String> dataToChangePin) {
//        //get data from hashmap
//        long cardNumber = Long.parseLong((dataToChangePin.get("cardNumber")));
//        int newPin = Integer.parseInt(dataToChangePin.get("newPin"));
//
//        //and get the index from the array, if it does not exist, get -1
//        int position = UserService.isCardNumber(cardNumber, users);
//        HashMap<String, String> changePinResponse = new HashMap<>();
//        changePinResponse.put("response", "changePinResponse");
//        int oldPin = users.get(position).getCard().getPin();
//
//        //if card number exists make the change Pin operation
//        if (position > -1) {
//            UserService.updatePin(newPin, users, position);
//            changePinResponse.put("status", "pinUpdated");
//            changePinResponse.put("message", "Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");
//            //if card number does not exist monitor this to user
//        } else {
//            changePinResponse.put("status", "pinNotUpdated");
//            changePinResponse.put("message", "This credit card number ( #: " + cardNumber + " ) does not exist");
//        }
//
//        return changePinResponse;
//    }
//
//    public static HashMap<String, String> transfer(HashMap<String, String> dataToTransfer) {
//        //
//        long originCardNumber = Long.valueOf((dataToTransfer.get("originCardNumber")));
//        long destinationCardNumber = Long.valueOf((dataToTransfer.get("destinationCardNumber")));
//        double amount = Double.parseDouble(dataToTransfer.get("amount"));
//
//        int originPosition = UserService.isCardNumber(originCardNumber, users);
//        boolean isOriginCardNumber = originPosition > -1;
//
//        int destinationPosition = UserService.isCardNumber(destinationCardNumber, users);
//        boolean isDestinationCardNumber = destinationPosition > -1;
//
//        boolean isMoney = false;
//        if (isOriginCardNumber) {
//            isMoney = UserService.isEnoughAmount(users, originPosition, amount);
//        }
//
//        HashMap<String, String> transferResponse = new HashMap<>();
//        transferResponse.put("response", "transferResponse");
//        transferResponse.put("status", "transfer NOT done");
//
//        if (!isOriginCardNumber) {
//            transferResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
//        } else if (!isDestinationCardNumber) {
//            transferResponse.put("message", "This credit card number (destination) ( #: " + destinationCardNumber + " ) does not exist");
//        } else if (!isMoney) {
//            transferResponse.put("message", "Check if credit card has not got enough money to make a transfer ...");
//        } else {
//            //now it is possible to make a transfer, call makeTransfer
//            double originBalance = users.get(originPosition).getCard().getAmount();
//            double depositBalance = users.get(destinationPosition).getCard().getAmount();
//            UserService.makeTransfer(originPosition, destinationPosition, amount, users);
//            double originBalanceAfterDeposit = users.get(originPosition).getCard().getAmount();
//            double destinationBalanceAfterDeposit = users.get(destinationPosition).getCard().getAmount();
//
//            transferResponse.put("status", "transfer done");
//            transferResponse.put("message", "From " + originCardNumber + " to " + destinationCardNumber + " " + amount
//                    + "\nBalance Origin account: " + originBalance + " to " + originBalanceAfterDeposit
//                    + "\nBalance Destination account: " + depositBalance + " to " + destinationBalanceAfterDeposit);
//        }
//
//        return transferResponse;
//    }
//
//    public static HashMap<String, String> deposit(HashMap<String, String> dataToDeposit) {
//        //
//        long originCardNumber = Long.valueOf((dataToDeposit.get("originCardNumber")));
//        double amount = Double.parseDouble(dataToDeposit.get("amount"));
//
//        int originPosition = UserService.isCardNumber(originCardNumber, users);
//        boolean isOriginCardNumber = originPosition > -1;
//
//        HashMap<String, String> depositResponse = new HashMap<>();
//        depositResponse.put("response", "depositResponse");
//        depositResponse.put("status", "deposit NOT done");
//
//        if (isOriginCardNumber) {
//            double balance = users.get(originPosition).getCard().getAmount();
//            UserService.makeDeposit(originPosition, amount, users);
//            double balanceAfterDeposit = users.get(originPosition).getCard().getAmount();
//
//            depositResponse.put("message", "Deposit " + originCardNumber + " of " + amount + ". Balance account: " + balance + " to " + balanceAfterDeposit);
//            depositResponse.put("status", "transfer done");
//        } else {
//            depositResponse.put("message", "This credit card number (origin) ( #: " + originCardNumber + " ) does not exist");
//        }
//
//        return depositResponse;
//    }


}
