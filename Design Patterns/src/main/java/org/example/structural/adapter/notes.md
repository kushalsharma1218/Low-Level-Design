# Adapter Design Pattern

## Definition
- Adapter : Kind of converted, Power adapter
- Its a kind of intermediate layer that transform one form to another, like 2/3 pin extension


> Adapter DP ensures that our code base remains maintainable
> when we are talking to third party api library/sdk


## Problem Statement
Lets suppose you have a software system, it is connected to third party api like aws.
- I might want to change third party provider in future
- Third party api we were dependent on gets deprecated.



## Solution

> Whenever connecting a third party api, never connect directly, always use an interface

We don't want to tightly couple third party into out code. So lets use adapter to connect to third party


### How to use Adapter
1. **When ever you are connecting to a third arty api, you create an interface with the methods that you need from the third party** 

    ```java
    class PhonePe{
        
    }
    
    interface Bank{
        double checkBal();
        void addBankAccount();
        boolean pay();
    }
    
    class YeaBank{
        int getBal(){}
        boolean fetchAccount(String accNumber){}
        List<Account> getAccounts(Bank bank){}
        boolean sendMoney(int ammount){}
    }
    ```
    Yes bank don't have same methods that are required by Bank

2. As third party api, will not implements our interface, we should create a wrapper class that implements our interface and uses the third party.

    ```java
    class PhonePe {}
    
    class YesBankApiAdapter implements Bank {
        YeaBank yesBank = new YeaBank();
        double checkBal() {
            return (double) yesBank.getBal();
        }
        void addBankAccount() {}
        boolean pay() {}
    }
    
    interface Bank {
        double checkBal();
        void addBankAccount();
        boolean pay();
    }
    
    class YeaBank {
        int getBal() {}
        boolean fetchAccount(String accNumber) {}
        List<Account> getAccounts(Bank bank) {}
        boolean sendMoney(int amount) {}
    }
    ```
    
    purpose of adapter is create object of YesBan and implement Bank interface methods using yes bank object
3. If some new bank we have to use lest say Icici bank, just create adapter and use.


**When do you use adapter**
- When ever we have to connect with third party api

Without Adapter, you might use direct object of YeasBank, it can violate
- Open close principle, if in future you want to use some other bank, then you will have change impl for existing code
- Dependency Inversion principle, two concrete classes cannot interact directly


> In Adapter, we can define methods the way we needed, and call third parties