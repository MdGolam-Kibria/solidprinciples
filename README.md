**# SOLID PRINCIPLE**

SOLID is a popular set of design principles that are used in object-oriented software development.

**SOLID** is an acronym that stands for **five** key design principles:

1) Single responsibility principle [**SRP**]<br/>
2) Open-closed principle [**OCP**]<br/>
3) Liskov substitution principle [**LSP**]<br/>
4) Interface segregation principle [**ISP**]<br/>
5) Dependency inversion principle [**DIP**]<br/>

**1. Single responsibility principle [**SRP**] : <br/>**<br/>
The single-responsibility principle is a computer programming principle that states that "A module should be responsible
to one, and only one, actor."<br/>
**Example**: <br/>

#### Below `BankService.class` only responsible to manage `bank` related service.

```java
public class BankService {
    private long deposit(BigDecimal amount, String accountNumber) {
        //TODO need to add deposit logic here...
        return 0;
    }

    private long withdraw(BigDecimal amount, String accountNumber) {
        //TODO need to add withdraw logic here...
        return 0;
    }
}
```

#### Below `LoanService.class` only responsible to manage `Loan` related service.

```java
public class LoanService {
    private void getLoanInterestInfo(String loanType) {
        if (loanType.equalsIgnoreCase("HomeLoan")) {
            System.out.println("This is homeLoan info");
        }
        if (loanType.equalsIgnoreCase("personalLoan")) {
            System.out.println("This is personal loan info");
        }
        if (loanType.equalsIgnoreCase("car")) {
            System.out.println("This is car loan info");
        }
    }
}
```

**2. Open-closed principle [**OCP**] : <br/>**<br/>
Open-closed Principle (OCP) states: Objects or entities should be open for extension but closed for modification. This
means that a class should be extendable without modifying the class itself.<br/><br/>
The Open Close Principle encourages software developers to design and write code in a fashion that adding new
functionality would involve minimal changes to existing code.<br/><br/>
**_Open-closed Principle (OCP) states: Objects or entities should be open for extension but closed for modification.
This means that a class should be extendable without modifying the class itself<br/>_**<br/>
**Example:**<br/>

#### Below `NotificationService.class` only responsible to manage `Notification` related service.

```java
public interface NotificationService {
    void sendOTP();

    void sendTransactionReport(String medium);
}
```

#### Below `EmailNotificationService.class` only responsible to manage `Email Notification` related service.

```java
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendOTP() {
        System.out.println("Successfully send OTP");
    }

    @Override
    public void sendTransactionReport(String medium) {
        System.out.println("Successfully send transaction report");
    }
}
```

#### Below `MobileNotificationService.class` only responsible to manage `Mobile Notification` related service.

```java
public class MobileNotificationService implements NotificationService {
    @Override
    public void sendOTP() {
        System.out.println("Successfully send OTP");
    }

    @Override
    public void sendTransactionReport(String medium) {
        System.out.println("Successfully send transaction report");
    }
}
```


So total scenario is `NotificationService.class` is extendable without modifying the `NotificationService.class`
class.


**3. Liskov substitution principle [**LSP**] : <br/>**<br/>
Simply put, the Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of its subclasses without breaking the application. In other words, what we want is to have the objects of our subclasses behaving the same way as the objects of our superclass.<br/>


**This means that every subclass or derived class should 
be substitutable for their base or parent class.**

**PROBLEM :** <br/>

Let's go to create a super class called SocialMedia.class and having implementation like below code snips<br/>

```java
public abstract class SocialMedia {
    public abstract void chatWithFriend();
    public abstract void publishPost(Object post);
    public abstract void sendPhotosAndVideos();
    public abstract void groupCall(Object...userInfo);
}
```

Now, Create some child class called `Facebook.class, Instragram.class, WhatsApp.class` having a parent class called the newly created parent
class `SocialMedia.class` <br/>
```java
public class Facebook extends SocialMedia {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {

    }
}
```

```java
public class Instagram extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {
        //not application in this platform
        /**
         * Here we can see Instagram[child] is not substitute of the SocialMedia[parent] class.
         * So we can say this platform not follow the liskov substitution principle.
         * */
    }
}
```

```java
public class WhatsApp extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {
        //not application in this platform
        /**
         * Here we can see WhatsApp[child] is not substitute of the SocialMedia[parent] class.
         * So we can say this platform not follow the liskov substitution principle.
         * */
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {

    }
}
```

#### As per above implementation we saw in `WhatsApp.class` WhatsApp [`child`] is not substitute of the SocialMedia[`parent`] class 
because `publishPost()` method not support in WhatsApp.<br/>
Also in `Instagram.class` Instagram  [`child`] is not substitute of the SocialMedia[`parent`] class <br/>
because `groupCall()` method not support in WhatsApp.<br/>

How can be generic the design ?

**SOLUTION :** <br/>

Create a generic parent `abstract` class called `SocialMedia.class` 
having available all method which will be suitable for all social media child class.

```java
public abstract class SocialMedia {
    public abstract void chatWithFriend();
    public abstract void sendPhotosAndVideos();
}
```

Now create 2 individual interface to serve 2 new service as like this 
problem need to service for `publishPost()` and `groupCall` .

```java
public interface PostMediaManager {
    void publishPost(Object post);
}
```
```java
public interface SocialVideoCallManager {
   void groupCall(Object...userInfo);
}
```


Now create **Facebook.class** child with implementing the newly 
created parent class called **SocialMedia.class** and also as we know Facebook support
publish post and group video call, So we need also implement these classes who service these service
in our case we have created 2 serviceable class called
`PostMediaManager.class` for serve post service and 
`SocialVideoCallManager.class` for serve groupVideoCall service
```java
/**
 * Here we can see WhatsApp[child] is substitute of the SocialMedia[parent] class.
 * So we can say this platform follow the liskov substitution principle.
 */
public class Facebook extends SocialMedia implements PostMediaManager, SocialVideoCallManager {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void groupCall(Object... userInfo) {

    }
}

```



Now create **WhatsApp.class** child with implementing the newly
created parent class called **SocialMedia.class** and also we know that the WahtsApp 
Support group video call, so we need to implement the serving class called 
`SocialVideoCallManager.class`


```java
/**
 * Here we can see WhatsApp[child] is substitute of the SocialMedia[parent] class.
 * So we can say this platform follow the liskov substitution principle.
 */
public class WhatsApp extends SocialMedia implements SocialVideoCallManager {
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {

    }
}
```

So finally we can say the **WhatsApp** and **Facebook** [**child**] is substitute of the SocialMedia[**parent**] class.
<br/>_**So we can say this platform follow the liskov substitution principle.**_



**4. Interface segregation principle [**ISP**] : <br/>**<br/>

A client should never be forced to implement an interface that 
it doesn't use, or clients shouldn't be forced to depend on methods 
they do not use.

The goal of this principle is to reduce the side effects of 
using larger interfaces by breaking application interfaces 
into smaller ones.


**PROBLEM :** <br/>

Let's go to create a class called **UPIPayment.class** that will serve 
related implemented services.

```java
public interface UPIPayment {
    void payMoney();
    void getScratchCard();
    void getCashBackAsCreditBalance();
}
```
Now create a client [**CHILD**] class called **GooglePlay.class** having newly created implementation class called **UPIPayment.class**

```java
/**All feature available in google*/
public class GooglePlay implements UPIPayment {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {

    }
}
```

create another client [**CHILD**] class called **PayATM.class** having newly created implementation class called **UPIPayment.class**

```java
public class PayATM implements UPIPayment {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {
        /**This feature is not available in this platform
         * As we know [[We should not force the client to use the methods that they don't wanna use]]
         * So here this platform[PayATM] force to implement this [getCashBackAsCreditBalance()] method that actually not need here....
         * So we can say this process not follow the ISP [Interface Segregation Principle]
         * */
    }
}
```

You can see in GooglePlay [**CHILD**] client all feature available of the parent class
called **UPIPayment.class** but in PayATM [**CHILD**] `getCashBackAsCreditBalance()` service 
is not available
problem is here PayATM platform[PayATM] force to implement this [getCashBackAsCreditBalance()] method that actually not need here

How can we generalize this  ?


**SOLUTION :** <br/>
Create a `parent` class called `UPIPayment.class` having all related methods 
that will be available for all clients.


```java
public interface UPIPayment {
    void payMoney();
    void getScratchCard();
}
```
Create a new interface called `CashBackManager.class` that will serve `getCashBackAsCreditBalance()`
method related service.
```java
public interface CashBackManager  {
    void getCashBackAsCreditBalance();
}
```

Now, Create two `child` client class called `GooglePay.class` with implemented the newly created 
parent class called `UPIPayment.java`  and also we know `getCashBackAsCreditBalance` service is available in
GooglePay service, so we also need to implement the serviceable class called 
`CashBackManager.class`

another client class called `PayATM.class` having implemented the parent class called **UPIPayment.class**
in this platform don't need ``getCashBackAsCreditBalance()`` service, so 
we can skip the serviceable class.

```java
public class GooglePay implements UPIPayment, CashBackManager {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {

    }
}
```

```java
public class PayATM implements UPIPayment {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

}
```
So, you can see here PayATM service don't need ``getCashBackAsCreditBalance()`` service
without braking the application and the parent class we already solved the issue.


**5. Dependency inversion principle [**DIP**] : <br/>**<br/>

The principle states: High-level modules should not import 
anything from low-level modules. Both should depend on 
abstractions (e.g., interfaces).
Abstractions should not depend on details.<br/>

**Say we gonna market to buy some cloths, so we must be pay for the cloths.
let's get a sample thy have only 2 payment option debit/ credit card.**

let's see a problem and solution.

**PROBLEM :** <br/>

```java

public class CreditCard {
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using credit card");
    }
}
```
```java
public class DebitCard {
    public void doTransaction(BigDecimal amount){
        System.out.println("Payment using debit card");
    }
}
```

```java
public class ShoppingMall {
    private DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }
    public void doPurchageSomething(BigDecimal amount){
        debitCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard = new DebitCard();
        ShoppingMall shoppingMall =  new ShoppingMall(debitCard);
        shoppingMall.doPurchageSomething(BigDecimal.valueOf(12342.0));
        /**You can see here if we wanna do transaction using credit card we need to change the code
         * because this case tightly coupled with [DebitCard] .....\n
         * that will violate the dependency inversion principle [DSI] concept
         * as per the [DSI] concept we always need to maintain the Loosely coupled between the class
         *
         * So how we solve this problem ?
         * Solution: Follow the [solution] package.
         * */
    }
}
```


You can see here if we wanna do transaction using credit card we need to change the code
because this case tightly coupled with [DebitCard] .....\n
that will violate the dependency inversion principle [DSI] concept
 as per the [DSI] concept we always need to maintain the Loosely coupled between the class.


**SOLUTION :** <br/>


```java
public interface BankCard {
    void doTransaction(BigDecimal amount);
}
```

```java

public class CreditCard implements BankCard{

    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using credit card");
    }
}
```

```java
public class DebitCard implements BankCard{

    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println("Payment using debit card");
    }
}
```

```java
public class ShoppingMall {
    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }
    public void doPurchageSomething(BigDecimal amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        /**Using debit card*/
        BankCard bankCard = new DebitCard();
        ShoppingMall shoppingMall =  new ShoppingMall(bankCard);
        shoppingMall.doPurchageSomething(BigDecimal.valueOf(53345.0));
        /**Using credit card*/
        BankCard bankCar = new CreditCard();
        ShoppingMall shoppingMal =  new ShoppingMall(bankCar);
        shoppingMal.doPurchageSomething(BigDecimal.valueOf(234243.5));
    }
}
```

You can see here we can purchase any products either credit or debit card 
without changing any code because all class is loosely coupled.




